/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.dialog;

import controle.ControleTelaDisciplina;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import tela.InternoJfTelaDisciplina;

/**
 *
 * @author Rafael
 */
public class PanelAtualizarCurso extends javax.swing.JPanel {


    private final ControleTelaDisciplina controle;
    private final JFrame frame;
    /**
     * Creates new form PanelAdicionarCurso
     */
    public PanelAtualizarCurso(InternoJfTelaDisciplina view, JFrame frame /*,String nomeCurso*/) {
        initComponents();
        this.frame = frame;
        controle = new ControleTelaDisciplina(view, this);
        JDialog modal = new JDialog(frame, false);
        modal.add(this);
        modal.setUndecorated(true);
        modal.setVisible(true);
        modal.pack();
        modal.setLocationRelativeTo(frame);
        this.getjTextFieldAtualizar().setText(controle.passarNomeCurso());
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

        jButtonAtualizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelAtualizar = new javax.swing.JLabel();
        jTextFieldAtualizar = new javax.swing.JTextField();

        setBackground(new java.awt.Color(69, 69, 69));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 83, 44), 6));

        jButtonAtualizar.setBackground(new java.awt.Color(227, 162, 26));
        jButtonAtualizar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jButtonAtualizar.setForeground(new java.awt.Color(240, 240, 240));
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.setFocusable(false);
        jButtonAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAtualizarMouseClicked(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(227, 162, 26));
        jButtonCancelar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(240, 240, 240));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setFocusable(false);
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(218, 83, 44));

        jLabelAtualizar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabelAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAtualizar.setText("Atualizar Curso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabelAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldAtualizar.setBackground(new java.awt.Color(69, 69, 69));
        jTextFieldAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldAtualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 162, 26)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButtonCancelar)
                .addGap(48, 48, 48)
                .addComponent(jButtonAtualizar)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldAtualizar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAtualizar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        frame.setEnabled(true);
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_jButtonCancelarMouseClicked

    private void jButtonAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtualizarMouseClicked
        frame.setEnabled(true);
        try {
            controle.editarCurso();
        } catch (ParseException ex) {
            Logger.getLogger(PanelAtualizarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButtonAtualizarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelAtualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAtualizar;
    // End of variables declaration//GEN-END:variables

    public JTextField getjTextFieldAtualizar() {
        return jTextFieldAtualizar;
    }

    public void setjTextField1(JTextField jTextFieldAtualizar) {
        this.jTextFieldAtualizar = jTextFieldAtualizar;
    }
}