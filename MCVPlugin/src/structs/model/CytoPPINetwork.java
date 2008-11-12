package structs.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CytoPPINetwork extends CytoAbstractPPINetwork {

    private Map<String, CytoProtein> proteins = new HashMap<String, CytoProtein>();
    private Map<String, CytoInteraction> interactions = new HashMap<String, CytoInteraction>();

    public CytoPPINetwork(PPINetwork network, String ID) {
        super(network, ID);
    }

    public void addCytoInteraction(CytoInteraction cytoInteraction) {
        interactions.put(cytoInteraction.getCytoID(), cytoInteraction);
    }

    public void addCytoProtein(CytoProtein cytoProtein) {
        proteins.put(cytoProtein.getCytoID(), cytoProtein);
    }

    @Override
    public Collection<CytoProtein> getCytoProteins() {
        return proteins.values();
    }

    @Override
    public CytoProtein getCytoProtein(String ID) {
        return proteins.get(ID);
    }

    @Override
    public Collection<CytoInteraction> getCytoInteractions() {
        return interactions.values();
    }

    @Override
    public CytoInteraction getCytoInteraction(String ID) {
        return interactions.get(ID);
    }
}
