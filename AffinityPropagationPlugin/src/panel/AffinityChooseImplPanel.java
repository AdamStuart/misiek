/*
 * AffinityChooseImplPanel.java
 *
 * Created on 2009-05-13, 13:59:23
 */

package panel;

/**
 *
 * @author misiek
 */
public class AffinityChooseImplPanel extends javax.swing.JPanel {

    private AffinityPanelController pc;
    /** Creates new form AffinityChooseImplPanel
     * @param pc
     */
    public AffinityChooseImplPanel(final AffinityPanelController pc) {
        this.pc = pc;
        initComponents();
        pc.setMatrixImplementation(radioMatrix);
        pc.setSmartImplementation(radioSibling);
     //   pc.initPanelFields();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioImplementationGroup = new javax.swing.ButtonGroup();
        implementationPanel = new javax.swing.JPanel();
        radioSibling = new javax.swing.JRadioButton();
        radioMatrix = new javax.swing.JRadioButton();

        implementationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose implementation"));
        implementationPanel.setMaximumSize(new java.awt.Dimension(270, 32767));
        implementationPanel.setName("implementationPanel"); // NOI18N
        implementationPanel.setPreferredSize(new java.awt.Dimension(270, 56));

        radioImplementationGroup.add(radioSibling);
        radioSibling.setSelected(true);
        radioSibling.setText("Sibling lists");
        radioSibling.setToolTipText("faster");
        radioSibling.setName("radioSibling"); // NOI18N

        radioImplementationGroup.add(radioMatrix);
        radioMatrix.setText("Matrix");
        radioMatrix.setName("radioMatrix"); // NOI18N

        javax.swing.GroupLayout implementationPanelLayout = new javax.swing.GroupLayout(implementationPanel);
        implementationPanel.setLayout(implementationPanelLayout);
        implementationPanelLayout.setHorizontalGroup(
            implementationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(implementationPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(radioMatrix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(radioSibling)
                .addGap(46, 46, 46))
        );
        implementationPanelLayout.setVerticalGroup(
            implementationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(implementationPanelLayout.createSequentialGroup()
                .addGroup(implementationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMatrix)
                    .addComponent(radioSibling))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(implementationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(implementationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel implementationPanel;
    private javax.swing.ButtonGroup radioImplementationGroup;
    private javax.swing.JRadioButton radioMatrix;
    private javax.swing.JRadioButton radioSibling;
    // End of variables declaration//GEN-END:variables

}