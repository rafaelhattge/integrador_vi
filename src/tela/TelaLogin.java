/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import controle.ControlerTelaLogin;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Diana
 */
public class TelaLogin extends javax.swing.JFrame {

    private final ControlerTelaLogin controler;

    /**
     * Creates new form TelaLogar
     */
    public TelaLogin() {
        initComponents();
        controler = new ControlerTelaLogin(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFundoLogar = new javax.swing.JPanel();
        jPanelBarraLogar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextUser = new javax.swing.JTextField();
        jPasswordSenha = new javax.swing.JPasswordField();
        jButtonSair = new javax.swing.JButton();
        jButtonLogar = new javax.swing.JButton();
        jLabelRegistrar = new javax.swing.JLabel();
        jlblMessagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanelFundoLogar.setBackground(new java.awt.Color(69, 69, 71));
        jPanelFundoLogar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 215, 244), 6));

        jPanelBarraLogar.setBackground(new java.awt.Color(66, 215, 244));
        jPanelBarraLogar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 215, 244)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/estudante.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBarraLogarLayout = new javax.swing.GroupLayout(jPanelBarraLogar);
        jPanelBarraLogar.setLayout(jPanelBarraLogarLayout);
        jPanelBarraLogarLayout.setHorizontalGroup(
            jPanelBarraLogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraLogarLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBarraLogarLayout.setVerticalGroup(
            jPanelBarraLogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraLogarLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jTextUser.setBackground(new java.awt.Color(69, 69, 71));
        jTextUser.setForeground(new java.awt.Color(255, 255, 255));
        jTextUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 215, 244), 1, true), "Usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(214, 206, 55))); // NOI18N
        jTextUser.setMaximumSize(new java.awt.Dimension(385, 40));
        jTextUser.setPreferredSize(new java.awt.Dimension(385, 40));
        jTextUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextUserMouseClicked(evt);
            }
        });

        jPasswordSenha.setBackground(new java.awt.Color(69, 69, 71));
        jPasswordSenha.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 215, 244), 1, true), "Senha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(214, 206, 55))); // NOI18N

        jButtonSair.setBackground(new java.awt.Color(181, 92, 28));
        jButtonSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSair.setText("SAIR");
        jButtonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonLogar.setBackground(new java.awt.Color(66, 215, 244));
        jButtonLogar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonLogar.setText("LOGAR");
        jButtonLogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogarActionPerformed(evt);
            }
        });

        jLabelRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegistrar.setText("clique aqui para criar nova conta");
        jLabelRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegistrarMouseClicked(evt);
            }
        });

        jlblMessagem.setForeground(new java.awt.Color(255, 255, 255));
        jlblMessagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelFundoLogarLayout = new javax.swing.GroupLayout(jPanelFundoLogar);
        jPanelFundoLogar.setLayout(jPanelFundoLogarLayout);
        jPanelFundoLogarLayout.setHorizontalGroup(
            jPanelFundoLogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarraLogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelFundoLogarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelFundoLogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordSenha)
                    .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLogarLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanelFundoLogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLogarLayout.createSequentialGroup()
                        .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLogarLayout.createSequentialGroup()
                        .addComponent(jlblMessagem, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanelFundoLogarLayout.setVerticalGroup(
            jPanelFundoLogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLogarLayout.createSequentialGroup()
                .addComponent(jPanelBarraLogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jlblMessagem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanelFundoLogarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundoLogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundoLogar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(400, 336));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jLabelRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegistrarMouseClicked
        // TODO add your handling code here:
       controler.chamarTelaCadastro();
    }//GEN-LAST:event_jLabelRegistrarMouseClicked

    private void jButtonLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogarActionPerformed
      
        try {
            controler.autenticarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLogarActionPerformed

    private void jTextUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextUserMouseClicked
        // TODO add your handling code here:
        controler.limparTelaLogin();
    }//GEN-LAST:event_jTextUserMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelRegistrar;
    private javax.swing.JPanel jPanelBarraLogar;
    private javax.swing.JPanel jPanelFundoLogar;
    private javax.swing.JPasswordField jPasswordSenha;
    private javax.swing.JTextField jTextUser;
    private javax.swing.JLabel jlblMessagem;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JPasswordField getjPasswordSenha() {
        return jPasswordSenha;
    }

    public void setjPasswordSenha(javax.swing.JPasswordField jPasswordSenha) {
        this.jPasswordSenha = jPasswordSenha;
    }

    public javax.swing.JTextField getjTextUser() {
        return jTextUser;
    }

    public void setjTextUser(javax.swing.JTextField jTextUser) {
        this.jTextUser = jTextUser;
    }

    public javax.swing.JLabel getJlblMessagem() {
        return jlblMessagem;
    }

    public void setJlblMessagem(javax.swing.JLabel jlblMessagem) {
        this.jlblMessagem = jlblMessagem;
    } 
}
