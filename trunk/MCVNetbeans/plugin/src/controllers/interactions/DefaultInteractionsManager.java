package controllers.interactions;

import viewmodel.controllers.CytoInteractionsConverter;
import cytoscape.CyNetwork;
import cytoscape.Cytoscape;
import cytoscape.view.CyNetworkView;
import viewmodel.controllers.CytoDataHandle;
import viewmodel.controllers.CytoVisualHandle;
import viewmodel.structs.CytoAbstractPPINetwork;
import logicmodel.structs.Interaction;
import logicmodel.structs.PPINetwork;

public class DefaultInteractionsManager extends InteractionsManager {

    @Override
    public void loadInteractionsFromModel(CytoAbstractPPINetwork cytoNetwork, double treshold) {

        PPINetwork network = cytoNetwork.getNetwork();

        for (Interaction interaction : network.getInteractions().values()) {

            if (interaction.getProbability().doubleValue() >= treshold) {
                CytoDataHandle.createCytoInteraction(interaction, cytoNetwork);
            }
        }
    }

    @Override
    public void deleteViewInteracions(CytoAbstractPPINetwork cytoNetwork) {
        CytoDataHandle.deleteCytoscapeInteractions(cytoNetwork);
        cytoNetwork.deleteCytoInteractions();
    }

    @Override
    public void showInteractions(CytoAbstractPPINetwork cytoNetwork) {
        CyNetworkView cyNetworkView = Cytoscape.getNetworkView(cytoNetwork.getCytoID());
        //CyNetwork cyNetwork = cyNetworkView.getNetwork();

   //     CytoInteractionsConverter.convertCytoNetworkInteractions(cyNetwork, cytoNetwork.getCytoInteractions());
   //     CytoVisualHandle.applyVisualStyleForNetwork(cyNetworkView);
    }

    @Override
    public void loadAndShowInteractionsFromModel(CytoAbstractPPINetwork cytoNetwork, double treshold) {
        deleteViewInteracions(cytoNetwork);
        loadInteractionsFromModel(cytoNetwork, treshold);
        showInteractions(cytoNetwork);
    }
}
