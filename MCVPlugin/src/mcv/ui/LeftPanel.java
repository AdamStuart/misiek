/*
 * LeftPanel.java
 *
 * Created on 23 wrzesień 2008, 20:25
 */
package mcv.ui;

import cytoscape.Cytoscape;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.help.CSH;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mcv.help.MCVHelpBroker;
import mcv.viewmodel.structs.CytoProtein;
import mcv.logicmodel.structs.PPINetwork;
import mcv.main.PluginDataHandle;
import mcv.ui.dataloading.DataLoadingErrorsJPanel;
import mcv.utils.JTreeModelSpeciesGenerator;
import mcv.utils.Messenger;
import mcv.utils.Stats;
import mcv.viewmodel.controllers.CytoProjector;

/**
 *
 * 
 * @author  misiek
 */
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
        tresholdSpinner = new javax.swing.JSpinner();
        showLoadedButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        testButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(280, 32767));
        setPreferredSize(new java.awt.Dimension(270, 305));

        dataPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dataPanel.setPreferredSize(new java.awt.Dimension(268, 51));

        updateDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/update.png"))); // NOI18N
        updateDataButton.setText("Update");
        updateDataButton.setToolTipText("Ładuje dane z plików .spy, .trees, .int");
        updateDataButton.setAlignmentY(0.0F);
        updateDataButton.setEnabled(false);
        updateDataButton.setIconTextGap(2);
        updateDataButton.setMargin(new java.awt.Insets(2, 5, 2, 14));
        updateDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDataButtonActionPerformed(evt);
            }
        });

        newDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/open.png"))); // NOI18N
        newDataButton.setText("New");
        newDataButton.setMargin(new java.awt.Insets(2, 5, 2, 14));
        newDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDataButtonActionPerformed(evt);
            }
        });

        deleteVataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/clean.png"))); // NOI18N
        deleteVataButton.setText("Clean");
        deleteVataButton.setEnabled(false);
        deleteVataButton.setMargin(new java.awt.Insets(2, 5, 2, 14));
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
                .addComponent(newDataButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteVataButton, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteVataButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        netsActionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        netsActionsPanel.setPreferredSize(new java.awt.Dimension(268, 160));

        projectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/cast.png"))); // NOI18N
        projectButton.setText("Casting...");
        projectButton.setToolTipText("Rzutuje na zaznaczone sieci w drzewku");
        projectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectButtonActionPerformed(evt);
            }
        });

        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/run.png"))); // NOI18N
        showButton.setText("Show network");
        showButton.setToolTipText("Wyswietla zaznaczone sieci w drzewku");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(spaciesTree);

        javax.swing.GroupLayout netsActionsPanelLayout = new javax.swing.GroupLayout(netsActionsPanel);
        netsActionsPanel.setLayout(netsActionsPanelLayout);
        netsActionsPanelLayout.setHorizontalGroup(
            netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(netsActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(netsActionsPanelLayout.createSequentialGroup()
                        .addComponent(projectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        netsActionsPanelLayout.setVerticalGroup(
            netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(netsActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectButton)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );

        intPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        intPanel.setPreferredSize(new java.awt.Dimension(268, 82));

        tresholdSpinner.setName("TresholdSpinner"); // NOI18N

        showLoadedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/refresh.png"))); // NOI18N
        showLoadedButton.setText("Refresh loaded interactions");
        showLoadedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLoadedButtonActionPerformed(evt);
            }
        });

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/help.png"))); // NOI18N
        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        testButton.setText("Test");
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
                .addGroup(intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showLoadedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGroup(intPanelLayout.createSequentialGroup()
                        .addComponent(helpButton)
                        .addGap(35, 35, 35)
                        .addComponent(testButton)
                        .addGap(18, 18, 18)
                        .addComponent(tresholdSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        intPanelLayout.setVerticalGroup(
            intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showLoadedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton)
                    .addComponent(tresholdSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(testButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(netsActionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
            .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
            .addComponent(intPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(netsActionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDataButtonActionPerformed
        UIController.getInstance().updateData();
}//GEN-LAST:event_updateDataButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        UIController.getInstance().showSelectedNetworks();
        UIController.getInstance().setMCVActiveTab();
}//GEN-LAST:event_showButtonActionPerformed

private void projectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectButtonActionPerformed
    Collection<PPINetwork> networks = UIController.getInstance().getSelectedNetworks();
    Collection<CytoProtein> selectedProteins = UIController.getInstance().getSelectedProteins(Cytoscape.getCurrentNetwork());

    if (selectedProteins.size() > 0) {
        CytoProjector.projectSelected(selectedProteins, networks);
        UIController.getInstance().setMCVActiveTab();
    } else {
        Messenger.message("You have to select proteins and target network!");
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
    CSH.DisplayHelpFromSource csh = new CSH.DisplayHelpFromSource(MCVHelpBroker.getHelpBroker("Introduction"));
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
    Stats.printStats();
    DataLoadingErrorsJPanel errorsPanel = new DataLoadingErrorsJPanel();
    JFrame frame = new JFrame("MCV plugin errors");

    frame.setLocationRelativeTo(Cytoscape.getDesktop());
    frame.add(errorsPanel);
    frame.pack();
    frame.setVisible(true);
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
    private javax.swing.JSpinner tresholdSpinner;
    private javax.swing.JButton updateDataButton;
    // End of variables declaration//GEN-END:variables
}
