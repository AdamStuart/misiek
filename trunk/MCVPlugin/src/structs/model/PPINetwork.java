package structs.model;

import java.util.HashMap;
import java.util.Map;

public class PPINetwork {

    private Map<String, Protein> proteins = new HashMap<String, Protein>();
    private Map<String, Interaction> interactions = new HashMap<String, Interaction>();
    private PPINetworkContext context = null;
    private String ID;

    public PPINetwork(String NetworkID, PPINetwork ParentNetwork) {
        ID = NetworkID;
        context = new PPINetworkContext(ParentNetwork);
    }

    public void addInteraction(String ID, String SourceID, String TargetID, Double Probability) {
        Protein source = this.getProtein(SourceID);
        Protein target = this.getProtein(TargetID);

        Interaction interaction = new Interaction(ID, source, target, Probability, this);

        interactions.put(ID, interaction);
    }

    public boolean containsProtein(String ProteinID) {
        return proteins.containsKey(ProteinID);
    }

    public boolean containsInteraction(String InteractionID) {
        return interactions.containsKey(InteractionID);
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

    public Interaction getInteraction(String IntaractionID) {
        return interactions.get(IntaractionID);
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

    public Map<String, Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(Map<String, Interaction> interactions) {
        this.interactions = interactions;
    }

    public Map<String, Protein> getProteins() {
        return proteins;
    }

    public void setProteins(Map<String, Protein> proteins) {
        this.proteins = proteins;
    }
}
