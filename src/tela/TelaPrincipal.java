/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import controle.ControlerTelaPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import modelo.Usuario;


/**
 *
 * @author Diana
 */
public class TelaPrincipal extends javax.swing.JFrame {
 private final InternoJfTelaRelatorio telaInicio = new InternoJfTelaRelatorio();
      private final InternoJfTelaTarefa telaTarefas = new InternoJfTelaTarefa();
       private final InternoJfTelaDisciplina telaDisicplina = new InternoJfTelaDisciplina();
        private final InternoJfTelaConfigUser telaConfigUser = new InternoJfTelaConfigUser();
        private final InternoJfTelaConfGeral telaConfigGeral = new InternoJfTelaConfGeral();
    private final ControlerTelaPrincipal controler;
    Usuario userAtivo;
//  private Usuario usuario;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
           
           controler = new ControlerTelaPrincipal(this);
           controler.ControleTelas(telaInicio);
           
         
   // pegarResolucao();     
 
  
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroupStatus = new javax.swing.ButtonGroup();
        JPanelFundoPrincipal = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jButtontarefas = new javax.swing.JButton();
        jButtonRelatorio = new javax.swing.JButton();
        jButtonDisciplina = new javax.swing.JButton();
        jButtonConfigUser = new javax.swing.JButton();
        jButtonConfigAdmin = new javax.swing.JButton();
        jDesktopPrincipal = new javax.swing.JDesktopPane();
        jPanelNomePrograma = new javax.swing.JPanel();
        jLabelsair = new javax.swing.JLabel();
        jLabelMini = new javax.swing.JLabel();
        jLabelNomePrograma = new javax.swing.JLabel();
        jLabelAluno = new javax.swing.JLabel();
        jLabelUsarioLogado = new javax.swing.JLabel();
        jLabelTipoUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(69, 69, 71));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JPanelFundoPrincipal.setBackground(new java.awt.Color(69, 69, 71));
        JPanelFundoPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(69, 69, 71));
        jPanelMenu.setFocusTraversalPolicyProvider(true);

        jButtontarefas.setBackground(new java.awt.Color(69, 69, 71));
        jButtontarefas.setForeground(new java.awt.Color(255, 255, 255));
        jButtontarefas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/tasks48color.png"))); // NOI18N
        jButtontarefas.setText("Tarefas");
        jButtontarefas.setBorder(null);
        jButtontarefas.setBorderPainted(false);
        jButtontarefas.setContentAreaFilled(false);
        jButtontarefas.setFocusable(false);
        jButtontarefas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtontarefas.setIconTextGap(1);
        jButtontarefas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/tasks32color.png"))); // NOI18N
        jButtontarefas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/tasks64color.png"))); // NOI18N
        jButtontarefas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtontarefas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtontarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontarefasActionPerformed(evt);
            }
        });

        jButtonRelatorio.setBackground(new java.awt.Color(69, 69, 71));
        jButtonRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/report48color.png"))); // NOI18N
        jButtonRelatorio.setText("Relatório");
        jButtonRelatorio.setBorder(null);
        jButtonRelatorio.setBorderPainted(false);
        jButtonRelatorio.setContentAreaFilled(false);
        jButtonRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatorio.setFocusable(false);
        jButtonRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelatorio.setIconTextGap(1);
        jButtonRelatorio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/report32color.png"))); // NOI18N
        jButtonRelatorio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/report64color.png"))); // NOI18N
        jButtonRelatorio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioActionPerformed(evt);
            }
        });

        jButtonDisciplina.setBackground(new java.awt.Color(69, 69, 71));
        jButtonDisciplina.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/book48color.png"))); // NOI18N
        jButtonDisciplina.setText("Disciplinas");
        jButtonDisciplina.setBorder(null);
        jButtonDisciplina.setBorderPainted(false);
        jButtonDisciplina.setContentAreaFilled(false);
        jButtonDisciplina.setFocusable(false);
        jButtonDisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDisciplina.setIconTextGap(1);
        jButtonDisciplina.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/book32color.png"))); // NOI18N
        jButtonDisciplina.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/book64color.png"))); // NOI18N
        jButtonDisciplina.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonDisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisciplinaActionPerformed(evt);
            }
        });

        jButtonConfigUser.setBackground(new java.awt.Color(69, 69, 71));
        jButtonConfigUser.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfigUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/config2-48color.png"))); // NOI18N
        jButtonConfigUser.setText("Configuração");
        jButtonConfigUser.setToolTipText("Configurar Usuário");
        jButtonConfigUser.setBorder(null);
        jButtonConfigUser.setBorderPainted(false);
        jButtonConfigUser.setContentAreaFilled(false);
        jButtonConfigUser.setFocusable(false);
        jButtonConfigUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConfigUser.setIconTextGap(1);
        jButtonConfigUser.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/config2-32color.png"))); // NOI18N
        jButtonConfigUser.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/config2-64color.png"))); // NOI18N
        jButtonConfigUser.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonConfigUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConfigUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigUserActionPerformed(evt);
            }
        });

        jButtonConfigAdmin.setBackground(new java.awt.Color(69, 69, 71));
        jButtonConfigAdmin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfigAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Admin2-48color.png"))); // NOI18N
        jButtonConfigAdmin.setText("Administrador");
        jButtonConfigAdmin.setToolTipText("Area administrador");
        jButtonConfigAdmin.setBorder(null);
        jButtonConfigAdmin.setBorderPainted(false);
        jButtonConfigAdmin.setContentAreaFilled(false);
        jButtonConfigAdmin.setFocusable(false);
        jButtonConfigAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConfigAdmin.setIconTextGap(1);
        jButtonConfigAdmin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Admin2-32color.png"))); // NOI18N
        jButtonConfigAdmin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Admin2-64color.png"))); // NOI18N
        jButtonConfigAdmin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonConfigAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConfigAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtontarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDisciplina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConfigUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConfigAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButtonDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButtontarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButtonConfigUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonConfigAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        JPanelFundoPrincipal.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 86, 90, 560));

        jDesktopPrincipal.setBackground(new java.awt.Color(69, 69, 71));
        jDesktopPrincipal.setOpaque(false);

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        JPanelFundoPrincipal.add(jDesktopPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 950, 570));

        jPanelNomePrograma.setBackground(new java.awt.Color(69, 69, 69));

        jLabelsair.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelsair.setForeground(new java.awt.Color(181, 92, 28));
        jLabelsair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelsair.setText("X");
        jLabelsair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelsairMouseClicked(evt);
            }
        });

        jLabelMini.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMini.setForeground(new java.awt.Color(181, 92, 28));
        jLabelMini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMini.setText("-");
        jLabelMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMiniMouseClicked(evt);
            }
        });

        jLabelNomePrograma.setFont(new java.awt.Font("Candara", 0, 48)); // NOI18N
        jLabelNomePrograma.setForeground(new java.awt.Color(66, 215, 244));
        jLabelNomePrograma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomePrograma.setText("Morpheus Study");

        jLabelAluno.setBackground(new java.awt.Color(66, 215, 244));
        jLabelAluno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/estudante.png"))); // NOI18N
        jLabelAluno.setOpaque(true);

        jLabelUsarioLogado.setBackground(new java.awt.Color(69, 69, 71));
        jLabelUsarioLogado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUsarioLogado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsarioLogado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsarioLogado.setOpaque(true);

        jLabelTipoUser.setBackground(new java.awt.Color(69, 69, 71));
        jLabelTipoUser.setForeground(new java.awt.Color(255, 255, 102));
        jLabelTipoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTipoUser.setOpaque(true);

        javax.swing.GroupLayout jPanelNomeProgramaLayout = new javax.swing.GroupLayout(jPanelNomePrograma);
        jPanelNomePrograma.setLayout(jPanelNomeProgramaLayout);
        jPanelNomeProgramaLayout.setHorizontalGroup(
            jPanelNomeProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNomeProgramaLayout.createSequentialGroup()
                .addComponent(jLabelAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanelNomeProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoUser, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNomePrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(jLabelMini, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelsair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanelNomeProgramaLayout.setVerticalGroup(
            jPanelNomeProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNomeProgramaLayout.createSequentialGroup()
                .addGroup(jPanelNomeProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNomeProgramaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNomePrograma))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNomeProgramaLayout.createSequentialGroup()
                        .addGroup(jPanelNomeProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelNomeProgramaLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanelNomeProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelsair)
                                    .addComponent(jLabelMini, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelNomeProgramaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelUsarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(610, 610, 610))
            .addGroup(jPanelNomeProgramaLayout.createSequentialGroup()
                .addComponent(jLabelAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JPanelFundoPrincipal.add(jPanelNomePrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1048, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelFundoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelFundoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //
      
    }//GEN-LAST:event_formWindowOpened

    private void jLabelsairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelsairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelsairMouseClicked

    private void jLabelMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMiniMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMiniMouseClicked

    private void jButtontarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontarefasActionPerformed

     jLabelAluno.setBackground(new java.awt.Color(66,244,158));
     jLabelNomePrograma.setForeground(new java.awt.Color(66,244,158));
     controler.ControleTelas(telaTarefas);
    }//GEN-LAST:event_jButtontarefasActionPerformed

    private void jButtonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioActionPerformed
     
     // controler.trocaPaneis(jPanelInicio);
     jLabelAluno.setBackground(new java.awt.Color(66,215,244));
        jLabelNomePrograma.setForeground(new java.awt.Color(66,215,244));
    controler.ControleTelas(telaInicio);
    }//GEN-LAST:event_jButtonRelatorioActionPerformed

    private void jButtonDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisciplinaActionPerformed
        // TODO add your handling code here:
        jLabelAluno.setBackground(new java.awt.Color(227,162,26));
        jLabelNomePrograma.setForeground(new java.awt.Color(227,162,26));
        controler.ControleTelas(telaDisicplina);
    }//GEN-LAST:event_jButtonDisciplinaActionPerformed

    private void jButtonConfigUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigUserActionPerformed
        
        jLabelAluno.setBackground(new java.awt.Color(177,72,210));
        jLabelNomePrograma.setForeground(new java.awt.Color(177,72,210));
        controler.ControleTelas(telaConfigUser);
    }//GEN-LAST:event_jButtonConfigUserActionPerformed

    private void jButtonConfigAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigAdminActionPerformed
    
    jLabelAluno.setBackground(new java.awt.Color(153,180,51));
    jLabelNomePrograma.setForeground(new java.awt.Color(153,180,51));
     controler.ControleTelas(telaConfigGeral);
    }//GEN-LAST:event_jButtonConfigAdminActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new TelaPrincipal().setVisible(true);
                
            }
        });
    }

    private void pegarResolucao() {
      Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
      //  System.out.println(t);
     
       
    
        this.setSize((dimensao.width - 410 ), (dimensao.height - 130));
      
    }
  

     
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelFundoPrincipal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroupStatus;
    private javax.swing.JButton jButtonConfigAdmin;
    private javax.swing.JButton jButtonConfigUser;
    private javax.swing.JButton jButtonDisciplina;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButtontarefas;
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JLabel jLabelAluno;
    private javax.swing.JLabel jLabelMini;
    private javax.swing.JLabel jLabelNomePrograma;
    private javax.swing.JLabel jLabelTipoUser;
    private javax.swing.JLabel jLabelUsarioLogado;
    private javax.swing.JLabel jLabelsair;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNomePrograma;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getjLabelUsarioLogado() {
        return jLabelUsarioLogado;
    }

    public void setjLabelUsarioLogado(javax.swing.JLabel jLabelUsarioLogado) {
        this.jLabelUsarioLogado = jLabelUsarioLogado;
    }

    public Usuario getuserAtivo() {
        return userAtivo;
    }

    public void setuserAtivo(Usuario usuario) {
        this.userAtivo = usuario;
    }

    public javax.swing.JLabel getjLabelTipoUser() {
        return jLabelTipoUser;
    }

    public void setjLabelTipoUser(javax.swing.JLabel jLabelTipoUser) {
        this.jLabelTipoUser = jLabelTipoUser;
    }

  

    public javax.swing.JDesktopPane getjDesktopPrincipal() {
        return jDesktopPrincipal;
    }

    public void setjDesktopPrincipal(javax.swing.JDesktopPane jDesktopPrincipal) {
        this.jDesktopPrincipal = jDesktopPrincipal;
    }
}
