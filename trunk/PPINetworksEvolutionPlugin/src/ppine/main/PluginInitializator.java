/* ===========================================================
 * NetworkEvolutionPlugin : Cytoscape plugin for visualizing stages of
 * protein networks evolution.
 * ===========================================================
 *
 *
 * Project Info:  http://bioputer.mimuw.edu.pl/veppin/
 * Sources: http://code.google.com/p/misiek/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * NetworkEvolutionPlugin  Copyright (C) 2008-2009
 * Authors:  Michal Wozniak (code) (m.wozniak@mimuw.edu.pl)
 *           Janusz Dutkowski (idea, data) (j.dutkowski@mimuw.edu.pl)
 *           Jerzy Tiuryn (supervisor) (tiuryn@mimuw.edu.pl)
 */

package ppine.main;

import ppine.cytolisteners.CytoListeners;
import cytoscape.Cytoscape;
import cytoscape.view.cytopanels.CytoPanelImp;
import cytoscape.visual.CalculatorCatalog;
import cytoscape.visual.VisualMappingManager;
import cytoscape.visual.VisualStyle;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import ppine.ui.LeftPanel;
import ppine.ui.PPINEMainPanel;
import ppine.ui.PluginMenusHandle;
import ppine.ui.familycolors.SpeciesFamilyColorPanel;
import ppine.visual.calculators.PPINEEdgeAppearanceCalculator;
import ppine.visual.calculators.PPINENodeAppearanceCalculator;
import org.jdesktop.swingx.VerticalLayout;

public class PluginInitializator {

    private static void initCommonVisualStyle() {
        VisualMappingManager vmm = Cytoscape.getVisualMappingManager();
        CalculatorCatalog catalog = vmm.getCalculatorCatalog();
        VisualStyle PPINEStyle = catalog.getVisualStyle("PPINEStyle");
        if (PPINEStyle == null) {

            PPINEStyle = new VisualStyle(vmm.getVisualStyle());
            PPINEStyle.setName("PPINEStyle");
            PPINEStyle.setNodeAppearanceCalculator(new PPINENodeAppearanceCalculator());
            PPINEStyle.setEdgeAppearanceCalculator(new PPINEEdgeAppearanceCalculator());

            catalog.addVisualStyle(PPINEStyle);
        } else {
        }
    }

    private static void initNetworkListeners() {
        CytoListeners.createListeners();
    }

    private static void initUI() {
        CytoPanelImp leftPanel = (CytoPanelImp) Cytoscape.getDesktop().getCytoPanel(SwingConstants.WEST);

        LeftPanel myLeftPanel = new LeftPanel();
        JPanel myPanel = new PPINEMainPanel();

        //   JPanel logsPanel = new LogsPanel();
        SpeciesFamilyColorPanel families = new SpeciesFamilyColorPanel();
      //  MIPSPanel mipsPanel = new MIPSPanel();
        myPanel.setLayout(new VerticalLayout());
        myPanel.add(myLeftPanel);
        myPanel.add(families);
  //      myPanel.add(mipsPanel);
        //     myPanel.add(logsPanel);

        PluginMenusHandle.setPPINEPanel(myPanel);
        PluginMenusHandle.setFamiliesColorListPanel(families);
        leftPanel.add(ResourceBundle.getBundle("ppine/resources/ui").getString("TABNAME"), myPanel);
    }

    public static void initAll() {
        initUI();
        initVisualStyles();
    }

    public static void initVisualStyles() {
        initCommonVisualStyle();
        initNetworkListeners();
    }
}
