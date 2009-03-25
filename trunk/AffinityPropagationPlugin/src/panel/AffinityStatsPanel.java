/*
 * AffinityStatsPanel.java
 *
 * Created on 2009-03-09, 13:38:13
 */
package panel;

/**
 *
 * @author misiek
 */
public class AffinityStatsPanel extends javax.swing.JPanel {

    private AffinityStatsPanelController psc = null;

    /** Creates new form AffinityStatsPanel */
    public AffinityStatsPanel() {
        initComponents();
    }

    public AffinityStatsPanel(final AffinityStatsPanelController psc) {
        this.psc = psc;
        initComponents();
        psc.setStatsTable(statsTable);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        statsTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(279, 297));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        statsTable.setFocusCycleRoot(true);
        statsTable.setMaximumSize(new java.awt.Dimension(90, 0));
        statsTable.setName("statsTable"); // NOI18N
        jScrollPane1.setViewportView(statsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable statsTable;
    // End of variables declaration//GEN-END:variables
}