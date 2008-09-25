package visual.calculators;

import cytoscape.CyNetwork;
import cytoscape.visual.NodeAppearance;
import cytoscape.visual.NodeAppearanceCalculator;
import cytoscape.visual.VisualPropertyType;
import giny.model.Node;
import main.DataHandle;
import structs.PPINetwork;
import structs.Protein;

public class MCVNodeAppearanceCalculator extends NodeAppearanceCalculator {

    @Override
    public void calculateNodeAppearance(NodeAppearance appr, Node node, CyNetwork cyNetwork) {
        super.calculateNodeAppearance(appr, node, cyNetwork);

        PPINetwork network = DataHandle.findNetworkByCytoID(cyNetwork.getIdentifier());
        if (network != null) {
            Protein protein = network.getProtein(node.getIdentifier());

            appr.set(VisualPropertyType.NODE_LABEL, protein.getID());
        }
    }
}
