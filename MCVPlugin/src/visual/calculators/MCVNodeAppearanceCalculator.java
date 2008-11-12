package visual.calculators;

import cytoscape.CyNetwork;
import cytoscape.visual.NodeAppearance;
import cytoscape.visual.NodeAppearanceCalculator;
import cytoscape.visual.VisualPropertyType;
import giny.model.Node;
import main.CytoDataHandle;
import main.DataHandle;
import structs.model.CytoAbstractPPINetwork;
import structs.model.CytoProtein;
import structs.model.Family;
import structs.model.PPINetwork;
import structs.model.Protein;

public class MCVNodeAppearanceCalculator extends NodeAppearanceCalculator {

    @Override
    public void calculateNodeAppearance(NodeAppearance appr, Node node, CyNetwork cyNetwork) {
        super.calculateNodeAppearance(appr, node, cyNetwork);

        CytoAbstractPPINetwork cytoNetwork = CytoDataHandle.findNetworkByCytoID(cyNetwork.getIdentifier());
        if (cytoNetwork != null) {
            CytoProtein cytoProtein = cytoNetwork.getCytoProtein(node.getIdentifier());
            Family family = cytoProtein.getProtein().getFamily();

            appr.set(VisualPropertyType.NODE_LABEL, cytoProtein.getProtein().getID());
            appr.set(VisualPropertyType.NODE_FILL_COLOR, family.getColor());
        }
    }
}
