package envinterface.cytoscape;

import cytoscape.CyNetwork;
import cytoscape.CyNode;
import cytoscape.Cytoscape;
import envinterface.EnvEdge;
import envinterface.EnvInterface;
import envinterface.EnvNetwork;
import envinterface.EnvNode;
import giny.model.Edge;
import giny.model.Node;

public class CytoscapeInterface extends EnvInterface {

    @Override
    public EnvNetwork createNetwork(String title) {
        CyNetwork cyNetwork = Cytoscape.createNetwork(title, true);
        EnvNetwork network = new EnvNetwork(cyNetwork.getIdentifier(), title);
        getNetworks().put(network.getID(), network);
        return network;
    }

    @Override
    public EnvNode createNode(EnvNetwork network, String ID) {
        CyNetwork cyNetwork = Cytoscape.getNetwork(network.getID());
        int rootID = Cytoscape.getRootGraph().createNode();
        Node cyNode = Cytoscape.getRootGraph().getNode(rootID);
        cyNode.setIdentifier(ID);
        cyNetwork.addNode(cyNode);
        EnvNode node = new EnvNode(network, ID, rootID);
        getNodes().put(new Integer(rootID), node);
        return node;
    }

    @Override
    public EnvEdge createEdge(EnvNetwork network, String ID, EnvNode source, EnvNode target) {
        CyNetwork cyNetwork = Cytoscape.getNetwork(network.getID());
        CyNode cysource = (CyNode) Cytoscape.getRootGraph().getNode(source.getRootID().intValue());
        CyNode cytarget = (CyNode) Cytoscape.getRootGraph().getNode(target.getRootID().intValue());
        int rootID = Cytoscape.getRootGraph().createEdge(cysource, cytarget);
        Edge cyEdge = Cytoscape.getRootGraph().getEdge(rootID);
        cyEdge.setIdentifier(ID);
        cyNetwork.addEdge(cyEdge);
        EnvEdge edge = new EnvEdge(network, ID, rootID, source, target);
        getEdges().put(new Integer(rootID), edge);
        return edge;
    }

    @Override
    public void deleteNode(int index) {
        Cytoscape.getRootGraph().removeNode(index);
        getNodes().remove(new Integer(index));
    }

    @Override
    public void deleteEdge(int index) {
        Cytoscape.getRootGraph().removeEdge(index);
        getEdges().remove(new Integer(index));
    }

    @Override
    public EnvNetwork currentNetwork() {
        return getNetworks().get(Cytoscape.getCurrentNetwork().getIdentifier());
    }
}
