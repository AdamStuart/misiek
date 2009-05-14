/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AffinityGraphModePanel.java
 *
 * Created on 2009-05-13, 22:29:46
 */
package panel;

/**
 *
 * @author misiek
 */
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

        setPreferredSize(new java.awt.Dimension(270, 49));

        graphModePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose graph edges mode"));
        graphModePanel.setName("graphModePanel"); // NOI18N
        graphModePanel.setPreferredSize(new java.awt.Dimension(270, 49));

        graphModeGroup.add(directedModeRadio);
        directedModeRadio.setText("directed edges");
        directedModeRadio.setName("directedModeRadio"); // NOI18N

        graphModeGroup.add(undirectedModeRadio);
        undirectedModeRadio.setSelected(true);
        undirectedModeRadio.setText("undirected edges");
        undirectedModeRadio.setName("undirectedModeRadio"); // NOI18N

        javax.swing.GroupLayout graphModePanelLayout = new javax.swing.GroupLayout(graphModePanel);
        graphModePanel.setLayout(graphModePanelLayout);
        graphModePanelLayout.setHorizontalGroup(
            graphModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(undirectedModeRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
            .addComponent(graphModePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
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
