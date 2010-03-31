/* ===========================================================
 * APGraphClusteringPlugin : Java implementation of affinity propagation
 * algorithm as Cytoscape plugin.
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
 * APGraphClusteringPlugin  Copyright (C) 2008-2009
 * Authors:  Michal Wozniak (code) (m.wozniak@mimuw.edu.pl)
 *           Janusz Dutkowski (idea) (j.dutkowski@mimuw.edu.pl)
 *           Jerzy Tiuryn (supervisor) (tiuryn@mimuw.edu.pl)
 */

package panel;

public class AffinityGraphModePanel extends javax.swing.JPanel {

    private AffinityPanelController pc;

    public AffinityGraphModePanel(AffinityPanelController pc) {
        this.pc = pc;
        initComponents();
        pc.setDirecedGraphRadio(directedModeRadio);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphModeGroup = new javax.swing.ButtonGroup();
        graphModePanel = new javax.swing.JPanel();
        directedModeRadio = new javax.swing.JRadioButton();
        undirectedModeRadio = new javax.swing.JRadioButton();

        graphModePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph mode"));
        graphModePanel.setMaximumSize(new java.awt.Dimension(280, 32767));
        graphModePanel.setName("graphModePanel"); // NOI18N

        graphModeGroup.add(directedModeRadio);
        directedModeRadio.setText("Directed edges");
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("panel/ui_properties"); // NOI18N
        directedModeRadio.setToolTipText(bundle.getString("DirectedOption.Tooltip")); // NOI18N
        directedModeRadio.setName("directedModeRadio"); // NOI18N

        graphModeGroup.add(undirectedModeRadio);
        undirectedModeRadio.setSelected(true);
        undirectedModeRadio.setText("Undirected edges");
        undirectedModeRadio.setToolTipText(bundle.getString("UndirectedOption.Tooltip")); // NOI18N
        undirectedModeRadio.setName("undirectedModeRadio"); // NOI18N

        javax.swing.GroupLayout graphModePanelLayout = new javax.swing.GroupLayout(graphModePanel);
        graphModePanel.setLayout(graphModePanelLayout);
        graphModePanelLayout.setHorizontalGroup(
            graphModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(undirectedModeRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(directedModeRadio)
                .addGap(36, 36, 36))
        );
        graphModePanelLayout.setVerticalGroup(
            graphModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(undirectedModeRadio)
                .addComponent(directedModeRadio))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphModePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphModePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton directedModeRadio;
    private javax.swing.ButtonGroup graphModeGroup;
    private javax.swing.JPanel graphModePanel;
    private javax.swing.JRadioButton undirectedModeRadio;
    // End of variables declaration//GEN-END:variables
}
