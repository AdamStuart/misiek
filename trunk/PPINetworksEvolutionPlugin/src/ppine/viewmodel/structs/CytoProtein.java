package ppine.viewmodel.structs;

import ppine.logicmodel.structs.Protein;

public class CytoProtein extends CytoNetworkObject {

    private Protein protein;

    public CytoProtein(String CytoID, Protein protein, CytoAbstractPPINetwork cytoNetwork) {
        this.setCytoID(CytoID);
        this.setCytoNetwork(cytoNetwork);
        this.protein = protein;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }
}
