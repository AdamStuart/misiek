/*
 * InteractionsLoaderPanel.java
 *
 * Created on 2009-04-11, 22:30:19
 */
package ui;

import java.awt.GridLayout;
import logicmodel.controllers.DataHandle;
import main.PluginDataHandle;

/**
 *
 * @author misiek
 */
public class InteractionsLoaderPanel extends javax.swing.JPanel {

    //private JFrame parentFrame = null;
    /** Creates new form InteractionsLoaderPanel
     */
    public InteractionsLoaderPanel() {
        //       this.parentFrame = parentFrame;
        initComponents();
        //    System.out.println("HEHEHE");
        // initSpeciesList();
        initSpeciesList();
    }

    private Double genereteTreshold(String species) {
        return Double.valueOf(0.5);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingPanel = new javax.swing.JPanel();
        loadButton = new javax.swing.JButton();

        loadingPanel.setName("loadingPanel"); // NOI18N

        javax.swing.GroupLayout loadingPanelLayout = new javax.swing.GroupLayout(loadingPanel);
        loadingPanel.setLayout(loadingPanelLayout);
        loadingPanelLayout.setHorizontalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        loadingPanelLayout.setVerticalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        loadButton.setText("Load");
        loadButton.setName("loadButton"); // NOI18N
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadButton, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /* private void initSpeciesList() {
    DataHandle dh = PluginDataHandle.getDataHandle();
    if (dh == null) {
    return;
    }

    DefaultTableModel tableModel = (DefaultTableModel) intLoadingTable.getModel();
    for (String species : dh.getNetworks().keySet()) {
    tableModel.addRow(new Object[]{species, genereteTreshold(species)});
    }
    }*/
    public void initSpeciesList() {
        DataHandle dh = PluginDataHandle.getDataHandle();
        if (!dh.isProteinsLoaded()) {
            return;
        }

        loadingPanel.setLayout(new GridLayout(dh.getNetworks().keySet().size(), 1));

        for (String species : dh.getNetworks().keySet()) {
            SpeciesInteractionsLoaderPanel panel = new SpeciesInteractionsLoaderPanel(species);
            System.out.println(species);
            loadingPanel.add(panel);
        }
    }

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        /*  DefaultTableModel model = (DefaultTableModel) intLoadingTable.getModel();
        Map<String, Double> tresholds = new TreeMap<String, Double>();

        for (int i = 0; i < model.getRowCount(); i++) {
        @SuppressWarnings("unchecked")
        Vector<Object> row = (Vector<Object>) model.getDataVector().get(i);
        String species = String.valueOf(row.get(0));
        String treshold_str = String.valueOf(row.get(1));
        if (treshold_str != null && !treshold_str.equals("")) {

        Double treshold = Double.valueOf(treshold_str);
        tresholds.put(species, treshold);
        }
        }*/

        //parentFrame.dispose();
        //  UIController.getInstance().loadAllInteractions(tresholds);
}//GEN-LAST:event_loadButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loadButton;
    private javax.swing.JPanel loadingPanel;
    // End of variables declaration//GEN-END:variables
}
