/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ppine.visual.calculators;

import cytoscape.CyNetwork;
import cytoscape.visual.Appearance;
import cytoscape.visual.VisualPropertyType;
import cytoscape.visual.calculators.BasicCalculator;
import cytoscape.visual.mappings.ObjectMapping;
import giny.model.Edge;
import java.awt.Color;
import java.util.Properties;
import ppine.main.PluginDataHandle;
import ppine.viewmodel.controllers.CytoDataHandle;
import ppine.viewmodel.structs.CytoAbstractPPINetwork;
import ppine.viewmodel.structs.CytoExpInteraction;
import ppine.viewmodel.structs.CytoInteraction;

/**
 *
 * @author misiek
 */
public class PPINEBasicEdgeCalculator extends BasicCalculator {

    public PPINEBasicEdgeCalculator(String name, Properties props, String baseKey, VisualPropertyType type) {
        super(name, props, baseKey, type);
    }

    public PPINEBasicEdgeCalculator(String name, ObjectMapping m, VisualPropertyType type) {
        super(name, m, type);
    }

    @Override
    public void apply(Appearance appr, Edge edge, CyNetwork cyNetwork) {
        CytoDataHandle cdh = PluginDataHandle.getCytoDataHandle();

        if (cdh == null) {
            return;
        }

        CytoAbstractPPINetwork cytoNetwork = cdh.tryFindNetworkByCytoID(cyNetwork.getIdentifier());

        if (cytoNetwork != null) {
            CytoInteraction cytoInteraction = cdh.getCytoInteractionByIndex(edge.getRootGraphIndex());
            if (cytoInteraction != null) {
                double probability = cytoInteraction.getProbability().doubleValue();

                appr.set(VisualPropertyType.EDGE_LINE_WIDTH, new Float(probability * 5.0)); //TODO - BAD CONST
                appr.set(VisualPropertyType.EDGE_TOOLTIP, String.valueOf(probability));
                appr.set(VisualPropertyType.EDGE_COLOR, Color.GRAY);
            }

            CytoExpInteraction cytoExpInteraction = cdh.getCytoExpInteractionByIndex(edge.getRootGraphIndex());
            if (cytoExpInteraction != null) {

                appr.set(VisualPropertyType.EDGE_LINE_WIDTH, 4.0); //TODO - BAD CONST
                appr.set(VisualPropertyType.EDGE_TOOLTIP, "Experiment ID: " + cytoExpInteraction.getExp().getExpID());
                appr.set(VisualPropertyType.EDGE_COLOR, cytoExpInteraction.getExp().getColor());
            }
        }
        //appr.applyBypass(edge, new LinkedList<VisualPropertyType>());

    }
}
