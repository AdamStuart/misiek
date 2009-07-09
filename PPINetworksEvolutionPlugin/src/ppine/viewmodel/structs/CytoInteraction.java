package ppine.viewmodel.structs;

public class CytoInteraction extends CytoNetworkObject {

    private Double probability;
    private CytoProtein source;
    private CytoProtein target;

    public CytoInteraction(String CytoID, CytoProtein source, CytoProtein target, CytoAbstractPPINetwork cytoNetwork, Double probability) {
        this.setCytoID(CytoID);
        this.setCytoNetwork(cytoNetwork);
        this.source = source;
        this.target = target;
        this.probability = probability;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public CytoProtein getSource() {
        return source;
    }

    public void setSource(CytoProtein source) {
        this.source = source;
    }

    public CytoProtein getTarget() {
        return target;
    }

    public void setTarget(CytoProtein target) {
        this.target = target;
    }
}
