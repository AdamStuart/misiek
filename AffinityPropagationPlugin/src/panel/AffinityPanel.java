/* ===========================================================
 * APGraphClusteringPlugin : Java implementation of Affinity Propagation
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

public class AffinityPanel extends javax.swing.JPanel {

    private AffinityPanelController pc = null;

    /** Creates new form AffinityPanel */
    public AffinityPanel() {
        initComponents();
    }

    /** Creates new form AffinityPanel
     * @param pc
     */
    public AffinityPanel(final AffinityPanelController pc) {
        this.pc = pc;
        initComponents();
        pc.setCovitsField(convitsField);
        pc.setEdgeAttrField(edgeAttrCombo);
        pc.setNodeAttrField(nodeAttrNameField);
        pc.setIterationsField(iterationsSpinner);
        pc.setLambdaField(labmbdaField);
       // pc.setDirecedGraphRadio();
        pc.setPreferencesField(preferenceField);
    //   pc.setRefineCheckBox(refineCheckBox);
        pc.setLogCheckBox(transformingCheckbox);
        pc.setCentersAttrField(centersNameAttrField);
        pc.setNoiseCheckBox(noiseCheckBox);
    //    pc.setNoiseCheckBox(noiseCheckbox);
        pc.initPanelFields();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parametersPanel = new javax.swing.JPanel();
        edgeAttrNameLabel = new javax.swing.JLabel();
        iterationsSpinner = new javax.swing.JSpinner();
        iteretionsLabel = new javax.swing.JLabel();
        preferenceField = new javax.swing.JTextField();
        preferenceLabel = new javax.swing.JLabel();
        labmbdaField = new javax.swing.JTextField();
        lambdaLabel = new javax.swing.JLabel();
        convitsLabel = new javax.swing.JLabel();
        convitsField = new javax.swing.JTextField();
        edgeAttrCombo = new javax.swing.JComboBox();
        transforminLabel = new javax.swing.JLabel();
        transformingCheckbox = new javax.swing.JCheckBox();
        refreshButton = new javax.swing.JButton();
        refreshButton1 = new javax.swing.JButton();
        noiseCheckBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        centersNameAttrField = new javax.swing.JTextField();
        nodeAttrNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nodeAttrNameLabel = new javax.swing.JLabel();

        setRequestFocusEnabled(false);

        parametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Paremeters"));
        parametersPanel.setMaximumSize(new java.awt.Dimension(270, 32767));
        parametersPanel.setName("parametersPanel"); // NOI18N

        edgeAttrNameLabel.setText("Edge weight attribute:");
        edgeAttrNameLabel.setName("edgeAttrNameLabel"); // NOI18N

        iterationsSpinner.setToolTipText("Maximal number of iterations");
        iterationsSpinner.setName("iterationsSpinner"); // NOI18N
        iterationsSpinner.setValue(200);

        iteretionsLabel.setText("Number of iterations:");
        iteretionsLabel.setName("iteretionsLabel"); // NOI18N

        preferenceField.setText("0.5");
        preferenceField.setToolTipText("Median is default and recommended.");
        preferenceField.setName("preferenceField"); // NOI18N
        preferenceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenceFieldActionPerformed(evt);
            }
        });

        preferenceLabel.setText("Preference:");
        preferenceLabel.setName("preferenceLabel"); // NOI18N

        labmbdaField.setText("0.9");
        labmbdaField.setName("labmbdaField"); // NOI18N
        labmbdaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labmbdaFieldActionPerformed(evt);
            }
        });

        lambdaLabel.setText("Lambda:");
        lambdaLabel.setName("lambdaLabel"); // NOI18N

        convitsLabel.setText("Stop criterium:");
        convitsLabel.setName("convitsLabel"); // NOI18N

        convitsField.setText("10");
        convitsField.setToolTipText("If the set of centers will not change by this number of iterations, then the algorithm stops.");
        convitsField.setName("convitsField"); // NOI18N

        edgeAttrCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DEFAULT" }));
        edgeAttrCombo.setToolTipText("Default weight value: 0.5");
        edgeAttrCombo.setName("edgeAttrCombo"); // NOI18N
        edgeAttrCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edgeAttrComboActionPerformed(evt);
            }
        });

        transforminLabel.setText("Log transform edge weights:");
        transforminLabel.setName("transforminLabel"); // NOI18N

        transformingCheckbox.setSelected(true);
        transformingCheckbox.setName("transformingCheckbox"); // NOI18N

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/refresh.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("panel/ui_properties"); // NOI18N
        refreshButton.setToolTipText(bundle.getString("RafreshButton.ToolTip")); // NOI18N
        refreshButton.setMargin(new java.awt.Insets(1, 6, 1, 6));
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        refreshButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/refresh.png"))); // NOI18N
        refreshButton1.setToolTipText(bundle.getString("RafreshButton.ToolTip")); // NOI18N
        refreshButton1.setMargin(new java.awt.Insets(1, 6, 1, 6));
        refreshButton1.setName("refreshButton1"); // NOI18N
        refreshButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButton1ActionPerformed(evt);
            }
        });

        noiseCheckBox.setName("noiseCheckBox"); // NOI18N

        jLabel3.setText("Add noise:");
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout parametersPanelLayout = new javax.swing.GroupLayout(parametersPanel);
        parametersPanel.setLayout(parametersPanelLayout);
        parametersPanelLayout.setHorizontalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transforminLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parametersPanelLayout.createSequentialGroup()
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addComponent(iteretionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(preferenceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lambdaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parametersPanelLayout.createSequentialGroup()
                                .addComponent(edgeAttrNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addComponent(convitsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addComponent(preferenceField, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, parametersPanelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noiseCheckBox)
                                    .addComponent(transformingCheckbox)))
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addComponent(edgeAttrCombo, 0, 81, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(convitsField, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(iterationsSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(labmbdaField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        parametersPanelLayout.setVerticalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edgeAttrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edgeAttrNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iterationsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iteretionsLabel))
                .addGap(7, 7, 7)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convitsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(convitsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(preferenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(preferenceLabel))
                    .addComponent(refreshButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lambdaLabel)
                    .addComponent(labmbdaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addComponent(transformingCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noiseCheckBox))
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addComponent(transforminLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Output attributes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel1.setName("jPanel1"); // NOI18N

        centersNameAttrField.setText("center_id");
        centersNameAttrField.setToolTipText("Cytoscape attribute to store nearest center name");
        centersNameAttrField.setName("centersNameAttrField"); // NOI18N

        nodeAttrNameField.setText("cluster_id");
        nodeAttrNameField.setToolTipText("Cytoscape attribute to store cluster id's");
        nodeAttrNameField.setName("nodeAttrNameField"); // NOI18N

        jLabel2.setText("Center ID:");
        jLabel2.setName("jLabel2"); // NOI18N

        nodeAttrNameLabel.setText("Cluster ID:");
        nodeAttrNameLabel.setName("nodeAttrNameLabel"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nodeAttrNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(centersNameAttrField, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(nodeAttrNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nodeAttrNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nodeAttrNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(centersNameAttrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(parametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labmbdaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labmbdaFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_labmbdaFieldActionPerformed

    private void preferenceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferenceFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_preferenceFieldActionPerformed

    private void edgeAttrComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edgeAttrComboActionPerformed
        //      pc.refreshPreferences();
    }//GEN-LAST:event_edgeAttrComboActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        pc.refreshEdgeAttrField();
}//GEN-LAST:event_refreshButtonActionPerformed

    private void refreshButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButton1ActionPerformed
        pc.refreshPreferences();
    }//GEN-LAST:event_refreshButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField centersNameAttrField;
    private javax.swing.JTextField convitsField;
    private javax.swing.JLabel convitsLabel;
    private javax.swing.JComboBox edgeAttrCombo;
    private javax.swing.JLabel edgeAttrNameLabel;
    private javax.swing.JSpinner iterationsSpinner;
    private javax.swing.JLabel iteretionsLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField labmbdaField;
    private javax.swing.JLabel lambdaLabel;
    private javax.swing.JTextField nodeAttrNameField;
    private javax.swing.JLabel nodeAttrNameLabel;
    private javax.swing.JCheckBox noiseCheckBox;
    private javax.swing.JPanel parametersPanel;
    private javax.swing.JTextField preferenceField;
    private javax.swing.JLabel preferenceLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton refreshButton1;
    private javax.swing.JLabel transforminLabel;
    private javax.swing.JCheckBox transformingCheckbox;
    // End of variables declaration//GEN-END:variables
}
