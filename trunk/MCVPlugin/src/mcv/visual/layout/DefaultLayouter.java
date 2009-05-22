package mcv.visual.layout;

import cytoscape.CyNode;
import cytoscape.Cytoscape;
import cytoscape.view.CyNetworkView;
import giny.view.NodeView;
import java.util.Collection;
import mcv.viewmodel.structs.CytoGroupNode;
import mcv.viewmodel.structs.CytoPPINetworkProjectionToDown;
import mcv.viewmodel.structs.CytoPPINetworkProjectionToUp;
import mcv.viewmodel.structs.CytoProtein;
import mcv.viewmodel.structs.CytoProteinProjection;

public class DefaultLayouter extends Layouter {

    private static double R = 30.0;  //TODO bad constant

    private static void groupNodeLayout(CytoGroupNode cytoGroupNode, CyNetworkView cyNetworkView) {
        Collection<CytoProtein> cytoProteins = cytoGroupNode.getContext().getInsideProteins();

        CytoProtein parentProtein = cytoGroupNode.getContext().getMotherProtein();
        String parentNetworkCytoID = parentProtein.getCytoNetwork().getCytoID();
        CyNetworkView parentNetworkView = Cytoscape.getNetworkView(parentNetworkCytoID);
        CyNode parentNode = Cytoscape.getCyNode(parentProtein.getCytoID());
        NodeView nodeView = parentNetworkView.getNodeView(parentNode);


        int i = 0;
        int count = cytoProteins.size();

        for (CytoProtein cytoProtein : cytoProteins) {

            CyNode node = Cytoscape.getCyNode(cytoProtein.getCytoID());
            NodeView proteinView = cyNetworkView.getNodeView(node);

            setProteinViewPosition(proteinView, nodeView, i, count);
            i++;
        }
    }

    @Override
    public void projectionToDownLayout(CytoPPINetworkProjectionToDown projection) {
        CyNetworkView cyNetworkView = Cytoscape.getNetworkView(projection.getCytoID());
        System.out.println("getting net: " + cyNetworkView.getTitle());
        projectionToDownLayout(projection, cyNetworkView);
    }

    private void projectionToDownLayout(CytoPPINetworkProjectionToDown projection, CyNetworkView cyNetworkView) {
        Collection<CytoGroupNode> cytoGroupNodes = projection.getCytoGroupNodes();

        for (CytoGroupNode cytoGroupNode : cytoGroupNodes) {
            groupNodeLayout(cytoGroupNode, cyNetworkView);
        }
    }

    @Override
    public void projectionToUpLayout(CytoPPINetworkProjectionToUp projection) {
        CyNetworkView cyNetworkView = Cytoscape.getNetworkView(projection.getCytoID());
        projectionToUpLayout(projection, cyNetworkView);
    }

    private void projectionToUpLayout(CytoPPINetworkProjectionToUp projection, CyNetworkView cyNetworkView) {


        for (CytoProteinProjection cytoProteinProjection : projection.getCytoProteinsProjections()) {
            CytoProtein cytoMotherProteinOrNull = cytoProteinProjection.tryGetCytoMotherProtein();

            if (cytoMotherProteinOrNull != null) {
                String motherNetworkCytoID = cytoMotherProteinOrNull.getCytoNetwork().getCytoID();
                CyNetworkView parentNetworkView = Cytoscape.getNetworkView(motherNetworkCytoID);
                CyNode parentNode = Cytoscape.getCyNode(cytoMotherProteinOrNull.getCytoID());
                NodeView nodeView = parentNetworkView.getNodeView(parentNode);

                CyNode node = Cytoscape.getCyNode(cytoProteinProjection.getCytoID());
                NodeView proteinView = cyNetworkView.getNodeView(node);
                proteinView.setXPosition(nodeView.getXPosition());
                proteinView.setYPosition(nodeView.getYPosition());
            }
        }

    }

    private static void setProteinViewPosition(NodeView proteinView, NodeView nodeView, int i, int count) {
        if (count == 1) {
            proteinView.setXPosition(nodeView.getXPosition());
            proteinView.setYPosition(nodeView.getYPosition());
        } else {
            double arg = 2 * Math.PI * i / count;
            double x_offset = R * Math.cos(arg);
            double y_offset = R * Math.sin(arg);
            proteinView.setXPosition(nodeView.getXPosition() + x_offset);
            proteinView.setYPosition(nodeView.getYPosition() + y_offset);
        }
    }
}
