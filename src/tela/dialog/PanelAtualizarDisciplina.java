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
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import modelo.Disciplina;
import tela.InternoJfTelaDisciplina;

/**
 *
 * @author Rafael
 */
public class PanelAtualizarDisciplina extends javax.swing.JPanel {


    private final ControleTelaDisciplina controle;
    private final JFrame frame;
    
    /**
     * Creates new form PanelAdicionarCurso
     */
    public PanelAtualizarDisciplina(InternoJfTelaDisciplina view, JFrame frame) {
        initComponents();
        this.frame = frame;
        controle = new ControleTelaDisciplina(view, this);
        JDialog modal = new JDialog(frame, false);
        modal.add(this);
        modal.setUndecorated(true);
        modal.setVisible(true);
        modal.pack();
        modal.setLocationRelativeTo(frame);
        Disciplina disciplina = controle.passarDisciplina();
        this.getjTextFieldNome().setText(disciplina.getNome());
        try {
            this.getjTextFieldInicio().setText(controle.formatarData(disciplina.getDataInicio()));
        } catch (ParseException ex) {
            Logger.getLogger(PanelAtualizarDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.getjTextFieldTermino().setText(controle.formatarData(disciplina.getDataTermino()));
        } catch (ParseException ex) {
            Logger.getLogger(PanelAtualizarDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getjCheckBoxDom().setSelected(disciplina.isDomingo());
        this.getjCheckBoxSeg().setSelected(disciplina.isSegunda());
        this.getjCheckBoxTer().setSelected(disciplina.isTerca());
        this.getjCheckBoxQua().setSelected(disciplina.isQuarta());
        this.getjCheckBoxQui().setSelected(disciplina.isQuinta());
        this.getjCheckBoxSex().setSelected(disciplina.isSexta());
        this.getjCheckBoxSab().setSelected(disciplina.isSabado());
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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelInicio = new javax.swing.JLabel();
        jLabelTermino = new javax.swing.JLabel();
        jTextFieldInicio = new javax.swing.JTextField();
        jTextFieldTermino = new javax.swing.JTextField();
        jLabelDias = new javax.swing.JLabel();
        jCheckBoxDom = new javax.swing.JCheckBox();
        jCheckBoxSeg = new javax.swing.JCheckBox();
        jCheckBoxTer = new javax.swing.JCheckBox();
        jCheckBoxQui = new javax.swing.JCheckBox();
        jCheckBoxSab = new javax.swing.JCheckBox();
        jCheckBoxQua = new javax.swing.JCheckBox();
        jCheckBoxSex = new javax.swing.JCheckBox();

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

        jLabel1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Atualizar Disciplina");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jTextFieldNome.setBackground(new java.awt.Color(69, 69, 69));
        jTextFieldNome.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 162, 26)));

        jLabelNome.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome da Disciplina");

        jLabelInicio.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabelInicio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInicio.setText("Data de Início da Disciplina");

        jLabelTermino.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabelTermino.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTermino.setText("Data de Conclusão da Disciplina");

        jTextFieldInicio.setBackground(new java.awt.Color(69, 69, 69));
        jTextFieldInicio.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 162, 26)));

        jTextFieldTermino.setBackground(new java.awt.Color(69, 69, 69));
        jTextFieldTermino.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTermino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 162, 26)));

        jLabelDias.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabelDias.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDias.setText("Dias em que Ocorre a Disciplina");

        jCheckBoxDom.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDom.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxDom.setText("Domingo");
        jCheckBoxDom.setOpaque(false);

        jCheckBoxSeg.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSeg.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSeg.setText("Segunda-feira");
        jCheckBoxSeg.setOpaque(false);

        jCheckBoxTer.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxTer.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxTer.setText("Terça-feira");
        jCheckBoxTer.setOpaque(false);

        jCheckBoxQui.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxQui.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxQui.setText("Quinta-feira");
        jCheckBoxQui.setOpaque(false);

        jCheckBoxSab.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSab.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSab.setText("Sábado");
        jCheckBoxSab.setOpaque(false);

        jCheckBoxQua.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxQua.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxQua.setText("Quarta-feira");
        jCheckBoxQua.setOpaque(false);

        jCheckBoxSex.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSex.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSex.setText("Sexta-feira");
        jCheckBoxSex.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 31, Short.MAX_VALUE))
                                    .addComponent(jLabelDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxDom)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldTermino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jCheckBoxSeg)
                                    .addComponent(jCheckBoxTer)
                                    .addComponent(jCheckBoxQui)
                                    .addComponent(jCheckBoxQua)
                                    .addComponent(jCheckBoxSex)
                                    .addComponent(jCheckBoxSab)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jButtonCancelar)
                                .addGap(48, 48, 48)
                                .addComponent(jButtonAtualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelNome)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDias, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxDom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSeg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxTer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxQua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxQui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
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
            controle.editarDisciplina();
            SwingUtilities.getWindowAncestor(this).dispose();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data em formato errado. O formato correto é 'dd/mm/AAAA'");
        }
    }//GEN-LAST:event_jButtonAtualizarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JCheckBox jCheckBoxDom;
    private javax.swing.JCheckBox jCheckBoxQua;
    private javax.swing.JCheckBox jCheckBoxQui;
    private javax.swing.JCheckBox jCheckBoxSab;
    private javax.swing.JCheckBox jCheckBoxSeg;
    private javax.swing.JCheckBox jCheckBoxSex;
    private javax.swing.JCheckBox jCheckBoxTer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDias;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTermino;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldInicio;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTermino;
    // End of variables declaration//GEN-END:variables

    public JCheckBox getjCheckBoxDom() {
        return jCheckBoxDom;
    }

    public void setjCheckBoxDom(JCheckBox jCheckBoxDom) {
        this.jCheckBoxDom = jCheckBoxDom;
    }

    public JCheckBox getjCheckBoxQua() {
        return jCheckBoxQua;
    }

    public void setjCheckBoxQua(JCheckBox jCheckBoxQua) {
        this.jCheckBoxQua = jCheckBoxQua;
    }

    public JCheckBox getjCheckBoxQui() {
        return jCheckBoxQui;
    }

    public void setjCheckBoxQui(JCheckBox jCheckBoxQui) {
        this.jCheckBoxQui = jCheckBoxQui;
    }

    public JCheckBox getjCheckBoxSab() {
        return jCheckBoxSab;
    }

    public void setjCheckBoxSab(JCheckBox jCheckBoxSab) {
        this.jCheckBoxSab = jCheckBoxSab;
    }

    public JCheckBox getjCheckBoxSeg() {
        return jCheckBoxSeg;
    }

    public void setjCheckBoxSeg(JCheckBox jCheckBoxSeg) {
        this.jCheckBoxSeg = jCheckBoxSeg;
    }

    public JCheckBox getjCheckBoxSex() {
        return jCheckBoxSex;
    }

    public void setjCheckBoxSex(JCheckBox jCheckBoxSex) {
        this.jCheckBoxSex = jCheckBoxSex;
    }

    public JCheckBox getjCheckBoxTer() {
        return jCheckBoxTer;
    }

    public void setjCheckBoxTer(JCheckBox jCheckBoxTer) {
        this.jCheckBoxTer = jCheckBoxTer;
    }

    public JTextField getjTextFieldInicio() {
        return jTextFieldInicio;
    }

    public void setjTextFieldInicio(JTextField jTextFieldInicio) {
        this.jTextFieldInicio = jTextFieldInicio;
    }

    public JTextField getjTextFieldNome() {
        return jTextFieldNome;
    }

    public void setjTextFieldNome(JTextField jTextFieldNome) {
        this.jTextFieldNome = jTextFieldNome;
    }

    public JTextField getjTextFieldTermino() {
        return jTextFieldTermino;
    }

    public void setjTextFieldTermino(JTextField jTextFieldTermino) {
        this.jTextFieldTermino = jTextFieldTermino;
    }
}