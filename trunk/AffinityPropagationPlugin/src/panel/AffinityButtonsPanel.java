
/*
 * JActionButton.java
 *
 * Created on 2009-05-13, 14:16:11
 */
package panel;

import help.AffHelpBroker;
import java.awt.event.ActionEvent;
import javax.help.CSH;

/**
 *
 * @author misiek
 */
public class AffinityButtonsPanel extends javax.swing.JPanel {

    private AffinityPanelController pc;

    /** Creates new form JActionButton
     * @param pc
     */
    public AffinityButtonsPanel(final AffinityPanelController pc) {
        this.pc = pc;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(270, 32767));
        setPreferredSize(new java.awt.Dimension(270, 25));

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("panel/ui_properties"); // NOI18N
        refreshButton.setToolTipText(bundle.getString("RafreshButton.ToolTip")); // NOI18N
        refreshButton.setMargin(new java.awt.Insets(2, 6, 2, 14));
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/run.png"))); // NOI18N
        startButton.setText("Start");
        startButton.setToolTipText(bundle.getString("StartButton.ToolTip")); // NOI18N
        startButton.setMargin(new java.awt.Insets(2, 6, 2, 14));
        startButton.setName("startButton"); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/help.png"))); // NOI18N
        helpButton.setToolTipText(bundle.getString("HelpButton.ToolTip")); // NOI18N
        helpButton.setName("helpButton"); // NOI18N
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(refreshButton)
                .addComponent(startButton))
            .addComponent(helpButton)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        pc.refresh();
}//GEN-LAST:event_refreshButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        pc.doCluster();
}//GEN-LAST:event_startButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        CSH.DisplayHelpFromSource csh = new CSH.DisplayHelpFromSource(AffHelpBroker.getHelpBroker("Introduction"));
        csh.actionPerformed(new ActionEvent(this, 120, "Introduction"));
    }//GEN-LAST:event_helpButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton helpButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
