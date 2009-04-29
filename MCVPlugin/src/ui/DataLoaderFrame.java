/*
 * DataLoaderFrame.java
 *
 * Created on 2009-04-27, 22:47:20
 */
package ui;

import cytoscape.Cytoscape;
import java.awt.FlowLayout;

/**
 *
 * @author misiek
 */
public class DataLoaderFrame extends javax.swing.JFrame {

    private void initPanel() {
        DataLoaderPanel loaderpanel = new DataLoaderPanel(this);
        this.add(loaderpanel);
        this.setVisible(true);
        loaderpanel.setVisible(true);
    }

    /** Creates new form DataLoaderFrame */
    public DataLoaderFrame() {
        initComponents();
        this.setLocationRelativeTo(Cytoscape.getDesktop());
        this.setResizable(true);
        this.setLayout(new FlowLayout());
        initPanel();
        this.repaint();
        this.pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data loading panel.");
        setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DataLoaderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
