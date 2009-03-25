package cyto;

import algorithm.abs.AffinityPropagationAlgorithm;
import algorithm.matrix.MatrixPropagationAlgorithm;
import algorithm.smart.Cluster;
import algorithm.smart.SmartPropagationAlgorithm;
import cytoscape.CyEdge;
import cytoscape.CyNode;
import cytoscape.Cytoscape;
import cytoscape.data.CyAttributes;
import cytoscape.task.TaskMonitor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JPanel;
import listeners.IterationListener;
import panel.AffinityPanelController;

/**
 *
 * @author misiek
 */
public class CytoAffinityClustering extends CytoAbstractClusterAlgorithm {

    private String nodeNameAttr;
    private String edgeNameAttr;
    private int iterations;
    private double preferences;
    private double lambda;
    private Integer convits = null;
    private AffinityPropagationAlgorithm<String> af = null;
    private CyAttributes nodesAttributes = Cytoscape.getNodeAttributes();
    private Map<String, Integer> nodeMapping = new HashMap<String, Integer>();
    private Map<Integer, String> idMapping = new HashMap<Integer, String>();

    public CytoAffinityClustering(int implementation, final String nodeNameAttr, final String edgeNameAttr, final double lambda, final double preferences, final int iterations) {
        this.nodeNameAttr = nodeNameAttr;
        this.edgeNameAttr = edgeNameAttr;
        this.lambda = lambda;
        this.preferences = preferences;
        this.iterations = iterations;
        this.convits = null;
        this.af = createAlgorithm(implementation);
    }

    public CytoAffinityClustering(final int implementation, final String nodeNameAttr, final String edgeNameAttr, final double lambda, final double preferences, final int iterations, final Integer convits) {
        this.nodeNameAttr = nodeNameAttr;
        this.edgeNameAttr = edgeNameAttr;
        this.lambda = lambda;
        this.preferences = preferences;
        this.iterations = iterations;
        this.convits = convits;
        this.af = createAlgorithm(implementation);
    }

    @Override
    public String getShortName() {
        return "AP";
    }

    @Override
    public String getName() {
        return "Affinity Propagation";
    }

    @Override
    public void updateSettings() {
    }

    @Override
    public JPanel getSettingsPanel() {
        return clusterProperties.getTunablePanel();
    }

    @Override
    public void doCluster(final TaskMonitor monitor) {
        super.setMyThread(Thread.currentThread());
        PriorityQueue<Cluster<String>> clusterprior = new PriorityQueue<Cluster<String>>();

        monitor.setStatus("Loading similarity matrix...");

        setParameters();
        monitor.setStatus("Clustering...");
        createIteractionListener(monitor);

        Map<String, Cluster<String>> clusters = af.doClusterAssoc();

        if (!canceled) {
            for (Cluster<String> cluster : clusters.values()) {
                clusterprior.add(cluster);
            }

            int i = 0;

            while (clusterprior.size() > 0) {
                Cluster<String> cluster = clusterprior.poll();
                for (String element : cluster.getElements()) {
                    String nodeID = idMapping.get(Integer.valueOf(element));
                    nodesAttributes.setAttribute(nodeID, nodeNameAttr, Integer.valueOf(i));
                }
                i++;
            }


            clustersNumber = clusters.size();
            monitor.setPercentCompleted(100);
        }
    }

    private AffinityPropagationAlgorithm<String> createAlgorithm(int implementation) {
        if (implementation == AffinityPanelController.MATRIX_IMPLEMENTATION) {
            return new MatrixPropagationAlgorithm();
        } else {
            return new SmartPropagationAlgorithm();
        }
    }

    private Set<String> selectConnectedNodes(final List<CyEdge> edges, final List<CyNode> nodes) {
        Set<String> nodesNames = new TreeSet<String>();


        for (CyEdge edge : edges) {
            String sourceID = edge.getSource().getIdentifier();
            String targetID = edge.getTarget().getIdentifier();

            nodesNames.add(targetID);
            nodesNames.add(sourceID);

        }

        return nodesNames;
    }

    private void setParameters() {
        @SuppressWarnings("unchecked")
        List<CyEdge> edges = Cytoscape.getCurrentNetwork().edgesList();
        @SuppressWarnings("unchecked")
        List<CyNode> nodes = Cytoscape.getCurrentNetwork().nodesList();
        Set<String> nodeNames = selectConnectedNodes(edges, nodes);

        CyAttributes edgesAttributes = Cytoscape.getEdgeAttributes();

        af.setLambda(lambda);
        af.setIterations(iterations);
        af.setConvits(convits);
        af.setN(nodeNames.size());
        af.init();

        int i = 0;

        for (String name : nodeNames) {
            Integer it = Integer.valueOf(i);
            idMapping.put(it, name);
            nodeMapping.put(name, it);
            af.setSimilarities(it.toString(), it.toString(), preferences);
            i++;
        }

        for (CyEdge edge : edges) {

            String id = edge.getIdentifier();
            String sourceID = edge.getSource().getIdentifier();
            String targetID = edge.getTarget().getIdentifier();
            Integer sourceIndex = nodeMapping.get(sourceID);
            Integer targetIndex = nodeMapping.get(targetID);

            if (!sourceID.equals(targetID)) {
                Double probOrNull = edgesAttributes.getDoubleAttribute(id, edgeNameAttr);
                if (probOrNull != null) {
                    af.setSimilarities(sourceIndex.toString(), targetIndex.toString(), Math.log(probOrNull));
                    af.setSimilarities(targetIndex.toString(), sourceIndex.toString(), Math.log(probOrNull));
                }
            //                af.setSimilarity(sourceID, targetID, Math.log(prob));
            //                af.setSimilarity(targetID, sourceID, Math.log(prob));
            }
        }

    }

    public void createIteractionListener(final TaskMonitor monitor) {
        af.addIterationListener(new IterationListener(monitor, iterations));
    }
}
