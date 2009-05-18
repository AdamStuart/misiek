/*
 * DataLoaderPanel.java
 *
 * Created on 2009-04-27, 15:57:08
 */
package mcv.ui.dataloading;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import mcv.main.LoadedDataHandle;
import mcv.main.PluginDataHandle;
import mcv.ui.listeners.InteractionsLoadedListener;
import mcv.ui.listeners.ProteinsLoadedListener;
import mcv.ui.listeners.SpeciesLoadedListener;

/**
 *
 * @author misiek
 */
public class DataLoaderPanel extends javax.swing.JPanel {

    InteractionsLoaderPanel intLoader;
    SpeciesTreeLoaderPanel speciesTree;
    GenesTreesLoaderPanel genesTree;
    JFrame parentFrame;

    public void setParentFrameOnTop() {
        parentFrame.toFront();
    }

    public void refreshStats() {
        if (genesTree != null) {
            genesTree.refreshStats();
        }
    }

    private void setActiveTab() {
        LoadedDataHandle ldh = PluginDataHandle.getLoadedDataHandle();
        if (ldh.isProteinsLoaded()) {
            this.getTabbedPane().setSelectedIndex(2);
        } else if (ldh.speciesTreeLoaded()) {
            this.getTabbedPane().setSelectedIndex(1);
        } else {
            this.getTabbedPane().setSelectedIndex(0);
        }
    }

    /*    private void setEnableSpeciesTab(boolean b) {
    this.getTabbedPane().setEnabledAt(0, b);
    }*/
    private void setEnableProteinsTab(boolean b) {
        this.getTabbedPane().setEnabledAt(1, b);
    }

    private void setEnableInteractionsTab(boolean b) {
        this.getTabbedPane().setEnabledAt(2, b);
    }

    /** Creates new form DataLoaderPanel
     * @param parentFrame
     */
    public DataLoaderPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        InteractionsLoadedListener intlist = new InteractionsLoadedListener(this);
        intLoader = new InteractionsLoaderPanel(intlist);

        ProteinsLoadedListener list = new ProteinsLoadedListener(this, intLoader);
        SpeciesLoadedListener list2 = new SpeciesLoadedListener(this);

        speciesTree = new SpeciesTreeLoaderPanel(list2);
        genesTree = new GenesTreesLoaderPanel(list);
        intLoader.setName("Interactions loading...");
        speciesTree.setName("Species tree loading...");
        genesTree.setName("Proteins data loading...");

        initComponents();
        this.getTabbedPane().addTab(speciesTree.getName(), speciesTree);
        this.getTabbedPane().addTab(genesTree.getName(), genesTree);
        this.getTabbedPane().addTab(intLoader.getName(), intLoader);

        enableTabs();
        setActiveTab();
    }

    public void enableTabs() {

        LoadedDataHandle ldh = PluginDataHandle.getLoadedDataHandle();
        setEnableProteinsTab(ldh.speciesTreeLoaded());
        setEnableInteractionsTab(ldh.isProteinsLoaded());
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();

        tabbedPane.setName("tabbedPane"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
