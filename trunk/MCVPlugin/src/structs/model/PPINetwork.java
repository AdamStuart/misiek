package structs.model;

import java.util.HashMap;
import java.util.Map;

public class PPINetwork {

    private Map<String, Protein> proteins = new HashMap<String, Protein>();
    private PPINetworkContext context = null;
    private String ID;

    public PPINetwork(String NetworkID, PPINetwork ParentNetwork) {
        ID = NetworkID;
        context = new PPINetworkContext(ParentNetwork);
    }

    public boolean containsProtein(String ProteinID) {
        return proteins.containsKey(ProteinID);
    }

    public void addProtein(String ProteinID, Protein ParentProtein, Family Family) {
        Protein protein = new Protein(ProteinID, ParentProtein, this, Family);
        proteins.put(ProteinID, protein);
    }

    public void addRootProtein(String ProteinID, Family Family) {
        Protein protein = new Protein(ProteinID, this, Family);
        proteins.put(ProteinID, protein);
    }

    public Protein getProtein(String ProteinID) {
        return proteins.get(ProteinID);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public PPINetworkContext getContext() {
        return context;
    }

    public void setContext(PPINetworkContext context) {
        this.context = context;
    }

    public Map<String, Protein> getProteins() {
        return proteins;
    }

    public void setProteins(Map<String, Protein> proteins) {
        this.proteins = proteins;
    }
}
