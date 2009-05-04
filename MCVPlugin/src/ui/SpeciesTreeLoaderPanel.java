/*
 * SpeciesTreeLoaderPanel.java
 *
 * Created on 2009-04-27, 22:44:30
 */
package ui;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.tree.TreeModel;
import logicmodel.controllers.DataHandle;
import main.PluginDataHandle;
import ui.listeners.ProteinsLoadedListener;
import ui.listeners.SpeciesLoadedListener;
import utils.JTreeModelSpeciesGenerator;

/**
 *
 * @author misiek
 */
public class SpeciesTreeLoaderPanel extends javax.swing.JPanel {

    private String filepath;
    private SpeciesLoadedListener list;

    /** Creates new form SpeciesTreeLoaderPanel
     * @param list 
     */
    public SpeciesTreeLoaderPanel(SpeciesLoadedListener list) {
        this.list = list;
        initComponents();
        initState();

    }

    public void initState() {
        DataHandle dh = PluginDataHandle.getDataHandle();
        if (dh.speciesTreeLoaded()) {
            setLoadedState();
        } else {
            setUnloadedState();
        }
    }

    private void setFilenameLabel() {
        String filename = PluginDataHandle.getLoadingDataHandle().getSpeciesFilename();
        if (filename != null) {
            filenameLabel.setText(filename);
            filepath = filename;
        } else {
            loadTreeButton.setEnabled(false);
        }
    }

    public void setLoadedState() {
        loadTreeButton.setEnabled(false);
        chooseFile.setEnabled(false);
        TreeModel treeModel = JTreeModelSpeciesGenerator.generateModel();
        speciesTree.setModel(treeModel);
        JTreeModelSpeciesGenerator.decorateJTree(speciesTree);
        setFilenameLabel();
    }

    public void setUnloadedState() {
        speciesTree.setModel(null);
        loadTreeButton.setEnabled(true);
        chooseFile.setEnabled(true);
        setFilenameLabel();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseFile = new javax.swing.JButton();
        filenameLabel = new javax.swing.JLabel();
        loadTreeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        speciesTree = new javax.swing.JTree();

        chooseFile.setText("Choose file");
        chooseFile.setName("chooseFile"); // NOI18N
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        filenameLabel.setText("filename");
        filenameLabel.setName("filenameLabel"); // NOI18N

        loadTreeButton.setText("Load tree");
        loadTreeButton.setName("loadTreeButton"); // NOI18N
        loadTreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTreeButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        speciesTree.setName("speciesTree"); // NOI18N
        jScrollPane1.setViewportView(speciesTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filenameLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadTreeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFile)
                    .addComponent(loadTreeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filenameLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(fc);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filepath = file.getAbsolutePath();
            filenameLabel.setText(filepath);
            PluginDataHandle.getLoadingDataHandle().setSpeciesFilename(filepath);
            loadTreeButton.setEnabled(true);
        }
    }//GEN-LAST:event_chooseFileActionPerformed

    private void loadTreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTreeButtonActionPerformed
        if (filepath != null) {
            UIController.getInstance().loadSpeciesTreeData(filepath);
            setLoadedState();
            list.actionPerformed(new ActionEvent(this, 1, "Species loaded"));
        }
    }//GEN-LAST:event_loadTreeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFile;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadTreeButton;
    private javax.swing.JTree speciesTree;
    // End of variables declaration//GEN-END:variables
}
