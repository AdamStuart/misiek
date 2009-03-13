package controllers.interactions;

import cytoscape.CyNetwork;
import cytoscape.Cytoscape;
import cytoscape.view.CyNetworkView;
import viewmodel.controllers.CytoInteractionsConverter;
import viewmodel.controllers.CytoDataHandle;
import viewmodel.structs.CytoAbstractPPINetwork;
import logicmodel.structs.Interaction;
import logicmodel.structs.PPINetwork;
import main.PluginDataHandle;
import viewmodel.controllers.CytoVisualHandle;

public class DefaultInteractionsManager extends InteractionsManager {

    @Override
    public void loadInteractionsFromModel(CytoAbstractPPINetwork cytoNetwork, double treshold) {
        CytoDataHandle cdh = PluginDataHandle.getCytoDataHandle();

        PPINetwork network = cytoNetwork.getNetwork();
        System.out.println(network.getInteractions().size());

        for (Interaction interaction : network.getInteractions().values()) {

            if (interaction.getProbability().doubleValue() >= treshold) {
                cdh.createCytoInteraction(interaction, cytoNetwork);
            }
        }
    }

    @Override
    public void deleteViewInteracions(CytoAbstractPPINetwork cytoNetwork) {
        CytoDataHandle cdh = PluginDataHandle.getCytoDataHandle();

        cdh.deleteCytoscapeInteractions(cytoNetwork);
        cytoNetwork.deleteCytoInteractions();
    }

    @Override
    public void showInteractions(CytoAbstractPPINetwork cytoNetwork) {
        CyNetworkView cyNetworkView = Cytoscape.getNetworkView(cytoNetwork.getCytoID());
        CyNetwork cyNetwork = cyNetworkView.getNetwork();

        CytoInteractionsConverter.convertCytoNetworkInteractions(cyNetwork, cytoNetwork.getCytoInteractions());
        CytoVisualHandle.applyVisualStyleForNetwork(cyNetworkView);
    }

    @Override
    public void loadAndShowInteractionsFromModel(CytoAbstractPPINetwork cytoNetwork, double treshold) {
        deleteViewInteracions(cytoNetwork);
        loadInteractionsFromModel(cytoNetwork, treshold);
        showInteractions(cytoNetwork);
    }
}
