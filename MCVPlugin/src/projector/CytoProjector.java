package projector;

import converter.CytoNetworkConverter;
import cytoscape.CyNode;
import cytoscape.Cytoscape;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import main.CytoDataHandle;
import structs.model.CytoAbstractPPINetwork;
import structs.model.CytoPPINetworkProjection;
import structs.model.CytoProtein;
import structs.model.PPINetwork;
import utils.Messenger;

public class CytoProjector {

    public static void projectSelected(Collection<PPINetwork> networks) {
        Collection<CytoProtein> selectedProteins = getSelectedProteins();
        CytoAbstractPPINetwork motherCytoNetwork = selectedProteins.iterator().next().getCytoNetowork();
        CytoPPINetworkProjection ret = null;
        for (PPINetwork network : networks) {
            PPINetwork motherNetwork = motherCytoNetwork.getNetwork();

            switch (network.getContext().getHierarchy().getNetworkPosition(motherNetwork)) {
                case ABOVE:
                    ret = ProjectorNetwork.projectProteinsToDownOnNetwork(selectedProteins, network, motherCytoNetwork);
                    CytoNetworkConverter.convertCytoNetwork(ret);
                    break;
                case BELOW:
                    ret = ProjectorNetwork.projectProteinsToUpOnNetwork(selectedProteins, network, motherCytoNetwork);
                    CytoNetworkConverter.convertCytoNetwork(ret);
                    break;
                case NEIGHBOUR:
                    Messenger.Message("NEIGHBOUR");
                    break;
                default:
                    Messenger.Message("DEFAULT");
            }
        }
    }

    public static Collection<CytoProtein> getSelectedProteins() {
        Set<CyNode> cyNodes = Cytoscape.getCurrentNetwork().getSelectedNodes();
        String PPINetworkCytoID = Cytoscape.getCurrentNetwork().getIdentifier();
        CytoAbstractPPINetwork currCytoNetwork = CytoDataHandle.findNetworkByCytoID(PPINetworkCytoID);
        Collection<CytoProtein> ret = new HashSet<CytoProtein>();

        if (currCytoNetwork != null) {
            for (CyNode node : cyNodes) {
                ret.add(currCytoNetwork.getCytoProtein(node.getIdentifier()));
            }
        }
        return ret;
    }
}
