/* ===========================================================
 * NetworkEvolutionPlugin : Cytoscape plugin for visualizing stages of
 * protein networks evolution.
 * ===========================================================
 *
 *
 * Project Info:  http://bioputer.mimuw.edu.pl/modevo/
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

package ppine.ui.dataloading;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import ppine.main.LoadedDataHandle;
import ppine.main.PluginDataHandle;
import ppine.ui.listeners.ExperimentsLoadedListener;
import ppine.ui.listeners.InteractionsLoadedListener;
import ppine.ui.listeners.ProteinsLoadedListener;
import ppine.ui.listeners.SpeciesLoadedListener;
import org.jdesktop.swingx.error.ErrorEvent;

/**
 *
 * @author misiek
 */
public class DataLoaderPanel extends javax.swing.JPanel {

    InteractionsLoaderPanel intLoader;
    SpeciesTreeLoaderPanel speciesTree;
    GenesTreesLoaderPanel genesTree;
    ExperimentsLoaderPanel experimentsPanel;
    JFrame parentFrame;

    public void setParentFrameOnTop() {
        parentFrame.toFront();
    }

    public void refreshStats() {
        if (genesTree != null) {
            genesTree.refreshStats();
        }
    }

    public void showErrorOccuredLabel(ErrorEvent errorEvent) {
        errorLabel.setText("Some errors occured, see log for more details: " + errorEvent);

    }

    private void setActiveTab() {
        LoadedDataHandle ldh = PluginDataHandle.getLoadedDataHandle();
        if (ldh.isProteinsLoaded()) {
            this.getTabbedPane().setSelectedIndex(2);
        } else if (ldh.speciesTreeLoaded()) {
            this.getTabbedPane().setSelectedIndex(1);
        } else {
            this.getTabbedPane().setSelectedIndex(0);
        }
    }

    /*    private void setEnableSpeciesTab(boolean b) {
    this.getTabbedPane().setEnabledAt(0, b);
    }*/
    private void setEnableProteinsTab(boolean b) {
        this.getTabbedPane().setEnabledAt(1, b);
    }

    private void setEnableInteractionsTab(boolean b) {
        this.getTabbedPane().setEnabledAt(2, b);
    }

    private void setEnableExperimentsTab(boolean b) {
        this.getTabbedPane().setEnabledAt(3, b);
    }

    /** Creates new form DataLoaderPanel
     * @param parentFrame
     */
    public DataLoaderPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        InteractionsLoadedListener intlist = new InteractionsLoadedListener(this);
        intLoader = new InteractionsLoaderPanel(intlist);
        intLoader.setLoaderPanel(this);

        ProteinsLoadedListener list = new ProteinsLoadedListener(this, intLoader);
        SpeciesLoadedListener list2 = new SpeciesLoadedListener(this);
        ExperimentsLoadedListener expList = new ExperimentsLoadedListener(this);

        speciesTree = new SpeciesTreeLoaderPanel(list2);
        speciesTree.setLoaderPanel(this);
        genesTree = new GenesTreesLoaderPanel(list);
        genesTree.setLoaderPanel(this);
        experimentsPanel = new ExperimentsLoaderPanel(this, expList);

        intLoader.setName("Interactions");
        speciesTree.setName("Species tree");
        genesTree.setName("Protein family trees");
        experimentsPanel.setName("Experiments");

        initComponents();
        this.getTabbedPane().addTab(speciesTree.getName(), speciesTree);
        this.getTabbedPane().addTab(genesTree.getName(), genesTree);
        this.getTabbedPane().addTab(intLoader.getName(), intLoader);
        this.getTabbedPane().addTab(experimentsPanel.getName(), experimentsPanel);

        enableTabs();
        setActiveTab();
    }

    public void enableTabs() {

        LoadedDataHandle ldh = PluginDataHandle.getLoadedDataHandle();
        setEnableProteinsTab(ldh.speciesTreeLoaded());
        setEnableInteractionsTab(ldh.isProteinsLoaded());
        setEnableExperimentsTab(ldh.isProteinsLoaded());
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        logButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        errorLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        tabbedPane.setName("tabbedPane"); // NOI18N

        logButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/stop2.png"))); // NOI18N
        logButton.setText("Show log");
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ppine/ui/resources/Loading"); // NOI18N
        logButton.setToolTipText(bundle.getString("ShowLogButton.ToolTip")); // NOI18N
        logButton.setName("logButton"); // NOI18N
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        errorLabel.setBackground(new java.awt.Color(255, 0, 0));
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setName("errorLabel"); // NOI18N
        jScrollPane3.setViewportView(errorLabel);

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/exit.png"))); // NOI18N
        closeButton.setText("Close ");
        closeButton.setToolTipText(bundle.getString("CloseButton.ToolTip")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        DefaultLoadingController.showPPINELogsPanel();
    }//GEN-LAST:event_logButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        parentFrame.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logButton;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
