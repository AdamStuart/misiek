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

package ppine.ui;

import cytoscape.Cytoscape;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.help.CSH;
import javax.swing.JOptionPane;
import ppine.help.PPINEHelpBroker;
import ppine.viewmodel.structs.CytoProtein;
import ppine.logicmodel.structs.SpeciesTreeNode;
import ppine.main.PluginDataHandle;
import ppine.ui.dataloading.DefaultLoadingController;
import ppine.utils.JTreeModelSpeciesGenerator;
import ppine.utils.Messenger;
import ppine.viewmodel.controllers.CytoProjector;

public class LeftPanel extends javax.swing.JPanel {

    /** Creates new form LeftPanel */
    public LeftPanel() {
        initComponents();
        initSpeciesTree();
        PluginMenusHandle.setTree(spaciesTree);
        PluginMenusHandle.setUpdateDataButton(updateDataButton);
        PluginMenusHandle.setDoProjectionButton(projectButton);
        PluginMenusHandle.setShowNetowrkButton(showButton);
        PluginMenusHandle.setShowLoadedInteractionsButton(showLoadedButton);
        PluginMenusHandle.setNewDataButton(newDataButton);
        PluginMenusHandle.setDeleteDataButton(deleteVataButton);
    //    PluginMenusHandle.setMapWithAttributesCkeckBox(mapWithAttrCheckbox);
        PluginMenusHandle.initButtonsState();
    }

    /*
    private void initJTable() {
    int vColIndex = 1;
    TableColumn col = jTable1.getColumnModel().getColumn(vColIndex);
    col.setCellRenderer(new TableColorCellRenderer());
    }*/
    private void initSpeciesTree() {

        JTreeModelSpeciesGenerator.decorateJTree(spaciesTree);
        spaciesTree.setModel(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanel = new javax.swing.JPanel();
        updateDataButton = new javax.swing.JButton();
        newDataButton = new javax.swing.JButton();
        deleteVataButton = new javax.swing.JButton();
        netsActionsPanel = new javax.swing.JPanel();
        projectButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        spaciesTree = new javax.swing.JTree();
        intPanel = new javax.swing.JPanel();
        showLoadedButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        testButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(280, 32767));

        dataPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dataPanel.setPreferredSize(new java.awt.Dimension(268, 51));

        updateDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/update.png"))); // NOI18N
        updateDataButton.setText("Update");
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ppine/ui/Bundle"); // NOI18N
        updateDataButton.setToolTipText(bundle.getString("UpdateButton.ToolTip")); // NOI18N
        updateDataButton.setAlignmentY(0.0F);
        updateDataButton.setEnabled(false);
        updateDataButton.setIconTextGap(2);
        updateDataButton.setMargin(new java.awt.Insets(2, 5, 1, 5));
        updateDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDataButtonActionPerformed(evt);
            }
        });

        newDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/open.png"))); // NOI18N
        newDataButton.setText("New");
        newDataButton.setToolTipText(bundle.getString("NewButton.ToolTip")); // NOI18N
        newDataButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        newDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDataButtonActionPerformed(evt);
            }
        });

        deleteVataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/clean.png"))); // NOI18N
        deleteVataButton.setText("Clean");
        deleteVataButton.setToolTipText(bundle.getString("CleanButton.ToolTip")); // NOI18N
        deleteVataButton.setEnabled(false);
        deleteVataButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        deleteVataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteVataButton, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteVataButton)
                    .addComponent(updateDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        netsActionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        netsActionsPanel.setPreferredSize(new java.awt.Dimension(268, 160));

        projectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/cast.png"))); // NOI18N
        projectButton.setText("Mapping");
        projectButton.setToolTipText(bundle.getString("CastingButton.ToolTip")); // NOI18N
        projectButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        projectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectButtonActionPerformed(evt);
            }
        });

        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/run.png"))); // NOI18N
        showButton.setText("Show network");
        showButton.setToolTipText(bundle.getString("ShowNetworkButton.ToolTip")); // NOI18N
        showButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        spaciesTree.setToolTipText("Tree of species networks");
        jScrollPane1.setViewportView(spaciesTree);

        javax.swing.GroupLayout netsActionsPanelLayout = new javax.swing.GroupLayout(netsActionsPanel);
        netsActionsPanel.setLayout(netsActionsPanelLayout);
        netsActionsPanelLayout.setHorizontalGroup(
            netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, netsActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGroup(netsActionsPanelLayout.createSequentialGroup()
                        .addComponent(projectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );
        netsActionsPanelLayout.setVerticalGroup(
            netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(netsActionsPanelLayout.createSequentialGroup()
                .addGroup(netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectButton)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        );

        intPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        intPanel.setPreferredSize(new java.awt.Dimension(268, 82));

        showLoadedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/refresh.png"))); // NOI18N
        showLoadedButton.setText("Refresh interactions");
        showLoadedButton.setToolTipText(bundle.getString("RefreshButton.ToolTip")); // NOI18N
        showLoadedButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        showLoadedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLoadedButtonActionPerformed(evt);
            }
        });

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/help.png"))); // NOI18N
        helpButton.setText("Help");
        helpButton.setToolTipText(bundle.getString("HelpButton.ToolTip")); // NOI18N
        helpButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        testButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ppine/resources/icons/stop2.png"))); // NOI18N
        testButton.setText("Show log");
        testButton.setToolTipText(bundle.getString("ShowLogButton.ToopTip")); // NOI18N
        testButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout intPanelLayout = new javax.swing.GroupLayout(intPanel);
        intPanel.setLayout(intPanelLayout);
        intPanelLayout.setHorizontalGroup(
            intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showLoadedButton)
                .addGap(34, 34, 34)
                .addGroup(intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(helpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(testButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        intPanelLayout.setVerticalGroup(
            intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showLoadedButton)
                    .addComponent(helpButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(intPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(netsActionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(netsActionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDataButtonActionPerformed
        UIController.getInstance().updateData();
}//GEN-LAST:event_updateDataButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        UIController.getInstance().showSelectedNetworks();
        UIController.getInstance().setPPINEActiveTab();
}//GEN-LAST:event_showButtonActionPerformed

private void projectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectButtonActionPerformed
    Collection<SpeciesTreeNode> networks = UIController.getInstance().getSelectedNetworks();
    Collection<CytoProtein> selectedProteins = UIController.getInstance().getSelectedProteins(Cytoscape.getCurrentNetwork());

    if (selectedProteins.size() > 0) {
        CytoProjector.projectSelected(selectedProteins, networks);
        UIController.getInstance().setPPINEActiveTab();
    } else {
        Messenger.message("You have to select proteins and target network.");
    }

}//GEN-LAST:event_projectButtonActionPerformed

private void showLoadedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLoadedButtonActionPerformed
//    double treshold = ((Integer) tresholdSpinner.getValue()).doubleValue() / 100.0;
    UIController.getInstance().showLoadedInteractions();

}//GEN-LAST:event_showLoadedButtonActionPerformed

private void newDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDataButtonActionPerformed

    if (PluginDataHandle.getLoadedDataHandle().speciesTreeLoaded()) {
        int ret = Messenger.confirmWarning("All loaded data will be deleted, are you sure?");
        if (ret == JOptionPane.OK_OPTION) {
            UIController.getInstance().newData();
        }
    } else {
        UIController.getInstance().newData();
    }
}//GEN-LAST:event_newDataButtonActionPerformed

private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
    CSH.DisplayHelpFromSource csh = new CSH.DisplayHelpFromSource(PPINEHelpBroker.getHelpBroker("Introduction"));
    csh.actionPerformed(new ActionEvent(this, 120, "Introduction"));
}//GEN-LAST:event_helpButtonActionPerformed

private void deleteVataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVataButtonActionPerformed
    if (PluginDataHandle.getLoadedDataHandle().speciesTreeLoaded()) {
        int ret = Messenger.confirmWarning("All loaded data will be deleted, are you sure?");
        if (ret == JOptionPane.OK_OPTION) {
            UIController.getInstance().deleteData();
        }
    }
}//GEN-LAST:event_deleteVataButtonActionPerformed

private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
//    Stats.printStats();
    DefaultLoadingController.showPPINELogsPanel();
}//GEN-LAST:event_testButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataPanel;
    private javax.swing.JButton deleteVataButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel intPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel netsActionsPanel;
    private javax.swing.JButton newDataButton;
    private javax.swing.JButton projectButton;
    private javax.swing.JButton showButton;
    private javax.swing.JButton showLoadedButton;
    private javax.swing.JTree spaciesTree;
    private javax.swing.JButton testButton;
    private javax.swing.JButton updateDataButton;
    // End of variables declaration//GEN-END:variables
}
