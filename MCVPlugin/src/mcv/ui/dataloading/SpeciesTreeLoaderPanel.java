/*
 * SpeciesTreeLoaderPanel.java
 *
 * Created on 2009-04-27, 22:44:30
 */
package mcv.ui.dataloading;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.help.CSH;
import javax.swing.JFileChooser;
import javax.swing.tree.TreeModel;
import mcv.help.MCVHelpBroker;
import mcv.io.listeners.SpeciesLoadingErrorsListener;
import mcv.main.LoadedDataHandle;
import mcv.main.PluginDataHandle;
import mcv.ui.UIController;
import mcv.ui.listeners.SpeciesLoadedListener;
import mcv.utils.JTreeModelSpeciesGenerator;
import org.jdesktop.swingx.error.ErrorEvent;

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
        LoadedDataHandle dh = PluginDataHandle.getLoadedDataHandle();
        if (dh.speciesTreeLoaded()) {
            setLoadedState();
        } else {
            setUnloadedState();
        }
    }

    public void logSpeciesLoadingError(ErrorEvent errorEvent) {
        errorLabel.setText(errorEvent.getThrowable().getMessage());
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
        if (PluginDataHandle.getLoadedDataHandle().isProteinsLoaded()) {
            cleanButton.setEnabled(false);
        } else {
            cleanButton.setEnabled(true);
        }

        setFilenameLabel();
    }

    public void setUnloadedState() {
        speciesTree.setModel(null);
        loadTreeButton.setEnabled(true);
        chooseFile.setEnabled(true);
        cleanButton.setEnabled(false);
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
        helpButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        cleanButton = new javax.swing.JButton();

        chooseFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/com.png"))); // NOI18N
        chooseFile.setText("Choose file");
        chooseFile.setName("chooseFile"); // NOI18N
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        filenameLabel.setText("filename");
        filenameLabel.setName("filenameLabel"); // NOI18N

        loadTreeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/save.png"))); // NOI18N
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

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/help.png"))); // NOI18N
        helpButton.setText("File format info");
        helpButton.setName("helpButton"); // NOI18N
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setName("errorLabel"); // NOI18N

        cleanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcv/resources/icons/clean.png"))); // NOI18N
        cleanButton.setText("Clean");
        cleanButton.setName("cleanButton"); // NOI18N
        cleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadTreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cleanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filenameLabel)
                    .addComponent(errorLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadTreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpButton)
                    .addComponent(cleanButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filenameLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLabel)
                .addGap(39, 39, 39))
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

            SpeciesLoadingErrorsListener errorListener = new SpeciesLoadingErrorsListener(this);
            DefaultLoadingController.loadSpeciesTreeData(filepath, errorListener);
            setLoadedState();
            list.actionPerformed(new ActionEvent(this, 1, "Species loaded"));
        }
    }//GEN-LAST:event_loadTreeButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        CSH.DisplayHelpFromSource csh = new CSH.DisplayHelpFromSource(MCVHelpBroker.getHelpBroker("Species file format"));
        csh.actionPerformed(new ActionEvent(this, 120, "Species file format"));
    }//GEN-LAST:event_helpButtonActionPerformed

    private void cleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanButtonActionPerformed
        UIController.getInstance().deleteData();
        setUnloadedState();
    }//GEN-LAST:event_cleanButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFile;
    private javax.swing.JButton cleanButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JButton helpButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadTreeButton;
    private javax.swing.JTree speciesTree;
    // End of variables declaration//GEN-END:variables
}
