package panel;

import cyto.CytoAffinityClustering;
import cyto.CytoClusterAlgorithm;
import cyto.CytoClusterTask;
import cytoscape.CyEdge;
import cytoscape.Cytoscape;
import cytoscape.data.CyAttributes;
import cytoscape.task.util.TaskManager;
import giny.model.Edge;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import utils.Messenger;
import utils.MathStats;

/**
 *
 * @author misiek (mw219725@gmail.com)
 */
public class AffinityPanelController implements Serializable {

    private final static long serialVersionUID = 7526471155622776147L;
    private JTextField lambdaField = null;
    private JTextField convitsField = null;
    private JTextField nodeAttrField = null;
    private JComboBox edgeAttrField = null;
    private JSpinner iterationsField = null;
    private JTextField preferencesField = null;
    private AffinityStatsPanelController psc = null;

    public AffinityPanelController(AffinityStatsPanelController psc) {
        this.psc = psc;
    }

    public JPanel createAffinityPanel() {
        JPanel panel = new AffinityPanel(this);
        return panel;
    }

    void doCluster() {
        CytoClusterAlgorithm algorithm;

        Double lambda = getLambda();
        Double preferences = getPreferences();
        Integer iterations = getIterations();
        Integer convits = getConvits();
        String nodeNameAttr = getNodeAttr();
        String edgeNameAttr = getEdgeAttr();

        if (!validateValues(lambda, preferences, iterations, convits, nodeNameAttr, edgeNameAttr)) {
            return;
        }
        Double logpreferences = Math.log(preferences);

        if (convits != null) {
            algorithm = new CytoAffinityClustering(nodeNameAttr, edgeNameAttr, lambda.doubleValue(), logpreferences.doubleValue(), iterations.intValue(), convits);
        } else {
            algorithm = new CytoAffinityClustering(nodeNameAttr, edgeNameAttr, lambda.doubleValue(), logpreferences.doubleValue(), iterations.intValue());
        }
        TaskManager.executeTask(new CytoClusterTask(algorithm),
                CytoClusterTask.getDefaultTaskConfig());

        Integer clusters = algorithm.getClustersNumber();
        String network = Cytoscape.getCurrentNetwork().getTitle();
        psc.addClusteringStat(network, lambda, preferences, clusters, iterations, nodeNameAttr);
    }

    private boolean validateConvits(Integer convits) {
        return true;
    }

    private boolean validateEdgeNameAttr(String edgeNameAttr) {
        return (edgeNameAttr != null && !edgeNameAttr.equals(""));
    }

    private boolean validateIterations(Integer iterations) {
        return (iterations != null && iterations > 0);
    }

    private boolean validateLambda(Double lambda) {
        return (lambda != null && lambda < 1.0 && lambda > 0.0);
    }

    private boolean validateNodeNameAttr(String nodeNameAttr) {
        return (nodeNameAttr != null && !nodeNameAttr.equals(""));
    }

    private boolean validatePreferences(Double preferences) {
        return (preferences != null && preferences > 0.0);
    }

    private boolean validateValues(Double lambda, Double preferences, Integer iterations, Integer convits, String nodeNameAttr, String edgeNameAttr) {
        if (!validateLambda(lambda)) {
            Messenger.message("Lambda is not valid!");
            return false;
        }
        if (!validatePreferences(preferences)) {
            Messenger.message("Preferences are not valid!");
            return false;
        }
        if (!validateIterations(iterations)) {
            Messenger.message("Iteration number is not valid!");
            return false;
        }
        if (!validateConvits(convits)) {
            Messenger.message("Convits are not valid!");
            return false;
        }
        if (!validateEdgeNameAttr(edgeNameAttr)) {
            Messenger.message("Edge name attribute is not valid!");
            return false;
        }
        if (!validateNodeNameAttr(nodeNameAttr)) {
            Messenger.message("Node name attribure is not valid!");
            return false;
        }
        return true;
    }

    private void initConvitsField() {
        convitsField.setText("3");
    }

    public void refresh() {
        initEdgeAttrField();
        refreshStats();
    }

    public void initEdgeAttrField() {
        edgeAttrField.removeAllItems();
        CyAttributes edgesAttributes = Cytoscape.getEdgeAttributes();
        for (String attrName : edgesAttributes.getAttributeNames()) {
            final byte cyType = edgesAttributes.getType(attrName);
            if (cyType == CyAttributes.TYPE_FLOATING) {
                edgeAttrField.addItem(attrName);
            }
        }
    }

    public void refreshStats() {
        String edgeNameAttr = getEdgeAttr();
        if (!validateEdgeNameAttr(edgeNameAttr)) {
            return;
        }
        @SuppressWarnings("unchecked")
        List<CyEdge> edges = Cytoscape.getCurrentNetwork().edgesList();
        CyAttributes edgesAttributes = Cytoscape.getEdgeAttributes();
        Vector<Double> probs = new Vector<Double>();

        for (Edge edge : edges) {

            String id = edge.getIdentifier();
            String sourceID = edge.getSource().getIdentifier();
            String targetID = edge.getTarget().getIdentifier();

            if (!sourceID.equals(targetID)) {

                Double prob = edgesAttributes.getDoubleAttribute(id, edgeNameAttr);
                probs.add(prob);

            }
        }

        Double median = MathStats.median(probs);
        setPreferences(median);
    }

    private void initIterationsField() {
        iterationsField.setValue(Integer.valueOf(10));
    }

    private void initLambdaField() {
        lambdaField.setText("0.5");
    }

    private void initNodeAttrField() {
        nodeAttrField.setText("clusterid");
    }

    private void initPreferencesField() {
        preferencesField.setText("0.2");
    }

    public void initPanelFields() {
        initLambdaField();
        initConvitsField();
        initNodeAttrField();
        initEdgeAttrField();
        initIterationsField();
        initPreferencesField();
    }

    public Integer getIterations() {
        try {
            return (Integer) iterationsField.getValue();
        } catch (NumberFormatException e) {
            Messenger.error(e);
            return null;
        }
    }

    public Double getPreferences() {

        try {
            return Double.valueOf(preferencesField.getText());
        } catch (NumberFormatException e) {
            Messenger.error(e);
            return null;
        }
    }

    public void setPreferences(Double p) {

        preferencesField.setText(String.valueOf(p));
    }

    public Double getLambda() {
        try {
            return Double.valueOf(lambdaField.getText());
        } catch (NumberFormatException ex) {
            //Logger.getLogger(AffinityPanelController.class.getName()).log(Level.SEVERE, null, ex);
            Messenger.error(ex);
            return null;
        }
    }

    public Integer getConvits() {

        try {
            return Integer.valueOf(convitsField.getText());
        } catch (NumberFormatException e) {
            Messenger.error(e);
            return null;
        }
    }

    public String getNodeAttr() {
        return nodeAttrField.getText();
    }

    public String getEdgeAttr() {
        return (String) edgeAttrField.getSelectedItem();
    }

    public JTextField getCovitsField() {
        return convitsField;
    }

    public void setCovitsField(JTextField covitsField) {
        this.convitsField = covitsField;
    }

    public JTextField getConvitsField() {
        return convitsField;
    }

    public void setConvitsField(JTextField convitsField) {
        this.convitsField = convitsField;
    }

    public JComboBox getEdgeAttrField() {
        return edgeAttrField;
    }

    public void setEdgeAttrField(JComboBox edgeAttrField) {
        this.edgeAttrField = edgeAttrField;
    }

    public JSpinner getIterationsField() {
        return iterationsField;
    }

    public void setIterationsField(JSpinner iterationsField) {
        this.iterationsField = iterationsField;
    }

    public JTextField getLambdaField() {
        return lambdaField;
    }

    public void setLambdaField(JTextField lambdaField) {
        this.lambdaField = lambdaField;
    }

    public JTextField getNodeAttrField() {
        return nodeAttrField;
    }

    public void setNodeAttrField(JTextField nodeAttr) {
        this.nodeAttrField = nodeAttr;
    }

    public JTextField getPreferencesField() {
        return preferencesField;
    }

    public void setPreferencesField(JTextField preferencesField) {
        this.preferencesField = preferencesField;
    }
}
