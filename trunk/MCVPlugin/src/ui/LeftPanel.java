/*
 * LeftPanel.java
 *
 * Created on 23 wrzesień 2008, 20:25
 */
package ui;

import MCL.ClusterAlgorithm;
import MCL.ClusterSettingsDialog;
import MCL.MCLCluster;
import cytoscape.Cytoscape;
import java.awt.Color;
import java.util.Collection;
import javax.swing.Icon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import logicmodel.controllers.DataHandle;
import viewmodel.structs.CytoProtein;
import logicmodel.structs.Family;
import logicmodel.structs.PPINetwork;
import main.PluginDataHandle;
import utils.Messenger;
import utils.Stats;
import viewmodel.controllers.CytoProjector;

/**
 *
 * 
 * @author  misiek
 */
public class LeftPanel extends javax.swing.JPanel {

    /** Creates new form LeftPanel */
    public LeftPanel() {
        initComponents();
        initColorList();
        initSpeciesTree();
        PluginMenusHandle.setTree(spaciesTree);
        PluginMenusHandle.setMemo(loggerTextArea);
        PluginMenusHandle.setLoadDataButton(loadDataButton);
        PluginMenusHandle.setDoProjectionButton(projectButton);
        PluginMenusHandle.setShowNetowrkButton(showButton);
        PluginMenusHandle.setFamiliesList(familiesList);
        PluginMenusHandle.setLoadAllInteractionsButton(loadInteractionsButton);
        PluginMenusHandle.setShowLoadedInteractionsButton(showLoadedButton);
        PluginMenusHandle.setLoadInteractionsForNetworkButton(loadIntForNetworkButton);
        PluginMenusHandle.setDeleteAllDataButton(deleteDataButton);
        UIController.getInstance().initButtonsState();
    }

    private void initColorList() {
        familiesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        familiesList.setListData(new String[0]);
        familiesList.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                DataHandle dh = PluginDataHandle.getDataHandle();

                if (!e.getValueIsAdjusting()) {

                    String FamilyID = (String) familiesList.getSelectedValue();
                    if (FamilyID == null) {
                        return;
                    }
                    Family family = dh.getFamily(FamilyID);
                    Color color = family.getColor();
                    color = JColorChooser.showDialog(null, "Wybierz kolor dla rodziny białek: " + FamilyID, color);
                    family.setColor(color);
                    familiesList.clearSelection();
                }
            }
        });
    }

    private void initSpeciesTree() {

        Icon icon = PluginResources.getIcon("spec.jpg");
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) spaciesTree.getCellRenderer();

        renderer.setOpenIcon(icon);
        renderer.setClosedIcon(icon);
        renderer.setLeafIcon(icon);
        spaciesTree.setCellRenderer(renderer);

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
        loadDataButton = new javax.swing.JButton();
        deleteDataButton = new javax.swing.JButton();
        attrPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        spaciesTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        loggerTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        familiesList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        netsActionsPanel = new javax.swing.JPanel();
        projectButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        intActionsPanel = new javax.swing.JPanel();
        selectConnectedButton = new javax.swing.JButton();
        deleteUnconnectedButton = new javax.swing.JButton();
        unselecUncunnectedButton = new javax.swing.JButton();
        intPanel = new javax.swing.JPanel();
        loadInteractionsButton = new javax.swing.JButton();
        loadIntForNetworkButton = new javax.swing.JButton();
        tresholdSpinner = new javax.swing.JSpinner();
        showLoadedButton = new javax.swing.JButton();
        mclButton = new javax.swing.JButton();
        testButton = new javax.swing.JButton();

        dataPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        loadDataButton.setText("Załaduj dane o białkach");
        loadDataButton.setToolTipText("Ładuje dane z plików .spy, .trees, .int");
        loadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataButtonActionPerformed(evt);
            }
        });

        deleteDataButton.setText("Usuń dane");
        deleteDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(loadDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadDataButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteDataButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        attrPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setViewportView(spaciesTree);

        loggerTextArea.setEditable(false);
        loggerTextArea.setRows(5);
        jScrollPane2.setViewportView(loggerTextArea);

        familiesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(familiesList);

        javax.swing.GroupLayout attrPanelLayout = new javax.swing.GroupLayout(attrPanel);
        attrPanel.setLayout(attrPanelLayout);
        attrPanelLayout.setHorizontalGroup(
            attrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attrPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(attrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addGroup(attrPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(attrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addContainerGap())
        );
        attrPanelLayout.setVerticalGroup(
            attrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attrPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(attrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attrPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        netsActionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        projectButton.setText("Rzutuj");
        projectButton.setToolTipText("Rzutuje na zaznaczone sieci w drzewku");
        projectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectButtonActionPerformed(evt);
            }
        });

        showButton.setText("Wyświetl sieć");
        showButton.setToolTipText("Wyswietla zaznaczone sieci w drzewku");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout netsActionsPanelLayout = new javax.swing.GroupLayout(netsActionsPanel);
        netsActionsPanel.setLayout(netsActionsPanelLayout);
        netsActionsPanelLayout.setHorizontalGroup(
            netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(netsActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        netsActionsPanelLayout.setVerticalGroup(
            netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(netsActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(netsActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectButton)
                    .addComponent(showButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        intActionsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        selectConnectedButton.setText("Zaznacz tylko połączone białka");
        selectConnectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectConnectedButtonActionPerformed(evt);
            }
        });

        deleteUnconnectedButton.setText("Usuń niepołączone białka wśród zaznaczonych");
        deleteUnconnectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUnconnectedButtonActionPerformed(evt);
            }
        });

        unselecUncunnectedButton.setText("Odznacz niepołączone białka");
        unselecUncunnectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unselecUncunnectedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout intActionsPanelLayout = new javax.swing.GroupLayout(intActionsPanel);
        intActionsPanel.setLayout(intActionsPanelLayout);
        intActionsPanelLayout.setHorizontalGroup(
            intActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(intActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectConnectedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(unselecUncunnectedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(deleteUnconnectedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                .addContainerGap())
        );
        intActionsPanelLayout.setVerticalGroup(
            intActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteUnconnectedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unselecUncunnectedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(selectConnectedButton))
        );

        intPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        loadInteractionsButton.setText("Załaduj interakcje do pamięci");
        loadInteractionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadInteractionsButtonActionPerformed(evt);
            }
        });

        loadIntForNetworkButton.setText("Załaduj interakcje dla sieci");
        loadIntForNetworkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadIntForNetworkButtonActionPerformed(evt);
            }
        });

        tresholdSpinner.setName("TresholdSpinner"); // NOI18N

        showLoadedButton.setText("Wyświetl załadowane interakcje");
        showLoadedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLoadedButtonActionPerformed(evt);
            }
        });

        mclButton.setText("MCL");
        mclButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mclButtonActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, intPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loadIntForNetworkButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(loadInteractionsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, intPanelLayout.createSequentialGroup()
                        .addComponent(mclButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(testButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tresholdSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(showLoadedButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addContainerGap())
        );
        intPanelLayout.setVerticalGroup(
            intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadInteractionsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadIntForNetworkButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showLoadedButton)
                .addGap(11, 11, 11)
                .addGroup(intPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mclButton)
                    .addComponent(tresholdSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(testButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPanel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(netsActionsPanel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(intPanel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(intActionsPanel, 0, 279, Short.MAX_VALUE)
            .addComponent(attrPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(netsActionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intActionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attrPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataButtonActionPerformed
        UIController.getInstance().loadData();
}//GEN-LAST:event_loadDataButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        UIController.getInstance().showSelectedNetworks();
}//GEN-LAST:event_showButtonActionPerformed

private void projectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectButtonActionPerformed
    Collection<PPINetwork> networks = UIController.getInstance().getSelectedNetworks();
    Collection<CytoProtein> selectedProteins = UIController.getInstance().getSelectedProteins(Cytoscape.getCurrentNetwork());

    if (selectedProteins.size() > 0) {
        CytoProjector.projectSelected(selectedProteins, networks);
    } else {
        Messenger.message("Musisz zaznaczyć białka do rzutowania!");
    }

}//GEN-LAST:event_projectButtonActionPerformed

private void loadIntForNetworkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadIntForNetworkButtonActionPerformed

    /*  Thread thread = new Thread(new Runnable() {

    public void run() {*/
    double treshold = ((Integer) tresholdSpinner.getValue()).doubleValue() / 100.0;

    UIController.getInstance().loadInteractionsForCurrentNetwork(treshold);
/*       }
});
thread.run();*/
}//GEN-LAST:event_loadIntForNetworkButtonActionPerformed

private void loadInteractionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadInteractionsButtonActionPerformed
    JFrame frame = new JFrame("Set tresholds for loading interactions.");
    InteractionsLoaderPanel intLoaderPanel = new InteractionsLoaderPanel(frame);
    frame.add(intLoaderPanel);
    frame.pack();
    frame.setVisible(true);
    frame.pack();
    frame.setLocationRelativeTo(Cytoscape.getDesktop());
    intLoaderPanel.setVisible(true);
}//GEN-LAST:event_loadInteractionsButtonActionPerformed

private void showLoadedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLoadedButtonActionPerformed
    double treshold = ((Integer) tresholdSpinner.getValue()).doubleValue() / 100.0;
    UIController.getInstance().showLoadedInteractions(treshold);

}//GEN-LAST:event_showLoadedButtonActionPerformed

private void selectConnectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectConnectedButtonActionPerformed
    UIController.getInstance().selectConnectedNodes(Cytoscape.getCurrentNetwork());
}//GEN-LAST:event_selectConnectedButtonActionPerformed

private void unselecUncunnectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unselecUncunnectedButtonActionPerformed
    UIController.getInstance().unselectUnConnectedNodes(Cytoscape.getCurrentNetwork());
}//GEN-LAST:event_unselecUncunnectedButtonActionPerformed

private void deleteUnconnectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUnconnectedButtonActionPerformed
}//GEN-LAST:event_deleteUnconnectedButtonActionPerformed

private void mclButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mclButtonActionPerformed
    ClusterAlgorithm algorithm = new MCLCluster();

    ClusterSettingsDialog csd = new ClusterSettingsDialog(algorithm);
    csd.actionPerformed(evt);
}//GEN-LAST:event_mclButtonActionPerformed

private void deleteDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDataButtonActionPerformed
    UIController.getInstance().deleteAllData();
}//GEN-LAST:event_deleteDataButtonActionPerformed

private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
    Stats.printStats();
}//GEN-LAST:event_testButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel attrPanel;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JButton deleteDataButton;
    private javax.swing.JButton deleteUnconnectedButton;
    private javax.swing.JList familiesList;
    private javax.swing.JPanel intActionsPanel;
    private javax.swing.JPanel intPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton loadDataButton;
    private javax.swing.JButton loadIntForNetworkButton;
    private javax.swing.JButton loadInteractionsButton;
    private javax.swing.JTextArea loggerTextArea;
    private javax.swing.JButton mclButton;
    private javax.swing.JPanel netsActionsPanel;
    private javax.swing.JButton projectButton;
    private javax.swing.JButton selectConnectedButton;
    private javax.swing.JButton showButton;
    private javax.swing.JButton showLoadedButton;
    private javax.swing.JTree spaciesTree;
    private javax.swing.JButton testButton;
    private javax.swing.JSpinner tresholdSpinner;
    private javax.swing.JButton unselecUncunnectedButton;
    // End of variables declaration//GEN-END:variables
}
