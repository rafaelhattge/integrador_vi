/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.dialog;

import controle.ControleTelaRelatorio;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import tela.InternoJfTelaRelatorio;

/**
 *
 * @author Rafael
 */
public class PanelAdicionarSubtarefa extends javax.swing.JPanel {

    private final ControleTelaRelatorio controle;
    private final JFrame frame;
    
    /**
     * Creates new form PanelAdicionarCurso
     */
    public PanelAdicionarSubtarefa(InternoJfTelaRelatorio view, JFrame frame) {
        initComponents();
        this.frame = frame;
        controle = new ControleTelaRelatorio(view, this);
        JDialog modal = new JDialog(frame, false);
        modal.add(this);
        modal.setUndecorated(true);
        modal.setVisible(true);
        modal.pack();
        modal.setLocationRelativeTo(frame);
        frame.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdicionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldSubtarefa = new javax.swing.JTextField();

        setBackground(new java.awt.Color(69, 69, 69));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 87, 151), 6));

        jButtonAdicionar.setBackground(new java.awt.Color(66, 215, 244));
        jButtonAdicionar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jButtonAdicionar.setForeground(new java.awt.Color(240, 240, 240));
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setFocusable(false);
        jButtonAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAdicionarMouseClicked(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(66, 215, 244));
        jButtonCancelar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(240, 240, 240));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setFocusable(false);
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });

        jPanelTitulo.setBackground(new java.awt.Color(43, 87, 151));

        jLabelTitulo.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Adicionar Subtarefa");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(111, 111, 111))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldSubtarefa.setBackground(new java.awt.Color(69, 69, 69));
        jTextFieldSubtarefa.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSubtarefa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 215, 244)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButtonCancelar)
                .addGap(48, 48, 48)
                .addComponent(jButtonAdicionar)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldSubtarefa)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSubtarefa, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAdicionar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        frame.setEnabled(true);
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_jButtonCancelarMouseClicked

    private void jButtonAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAdicionarMouseClicked
        frame.setEnabled(true);
        try {
            controle.salvarSubtarefa();
        } catch (SQLException ex) {
            Logger.getLogger(PanelAdicionarSubtarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAdicionarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JTextField jTextFieldSubtarefa;
    // End of variables declaration//GEN-END:variables

    public JTextField getjTextField1() {
        return jTextFieldSubtarefa;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextFieldSubtarefa = jTextField1;
    }
}
