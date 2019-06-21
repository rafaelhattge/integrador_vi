/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.Usuario;
import tela.TelaPrincipal;

/**
 *
 * @author Diana
 */
public class ControlerTelaPrincipal {

    private final TelaPrincipal view;
    
   private Usuario usuarioAtivo;

    public ControlerTelaPrincipal(TelaPrincipal view) {
        this.view = view;
    }

    public ControlerTelaPrincipal(TelaPrincipal view, Usuario usuarioAtivo) {
        this.view = view;
     this.usuarioAtivo = usuarioAtivo;
        ControleTelaDisciplina controleTelaDisciplina = new ControleTelaDisciplina(view.getTelaDisicplina(), view.getTelaDisicplina().getDialog(), this.usuarioAtivo);
        controleTelaDisciplina.exibirCursos();
        try {
         controleTelaDisciplina.exibirDisciplinas();
        } catch (ParseException ex) {
            Logger.getLogger(ControlerTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///////
        ControleTarefa controleTarefa = new ControleTarefa(view.getTelaTarefas(), this.usuarioAtivo);
        controleTarefa.exibirTarefas();
        ControleTelaRelatorio controleRelatorio = new ControleTelaRelatorio(view.getTelaRelatorio(), this.usuarioAtivo);
        try {
            controleRelatorio.listarDatas();
        } catch (SQLException ex) {
            Logger.getLogger(ControlerTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////////////////
        ControlerTelaConfigUser controleUser = new ControlerTelaConfigUser(view.getTelaUser(), this.usuarioAtivo);
     //   controleUser.MostrarDados(this.usuarioAtivo);
    }


    /*  public void contadorLogin() throws SQLException{
        if(view.getuserAtivo().getMensagem().equals("sim")){
          TelaMensagem boavinda  = new TelaMensagem(view, true);
          boavinda.setVisible(true);
        if(boavinda.getjCheckMostrarFrase().isSelected()){
            view.getuserAtivo().setMensagem("nao");
             Connection conexao = new conexao().conectarBanco();
            UsuarioDao user = new UsuarioDao(conexao);
            user.UpdateUsuario(view.getuserAtivo());
        }else{
           boavinda.setVisible(true); 
        }
        
}
}*/
    public void ControleTelas(javax.swing.JInternalFrame tela) {

        if (tela.isVisible()) {
            tela.toFront();
            tela.getFocusOwner();
            try {
                tela.setSelected(true);
            } catch (PropertyVetoException ex) {
                //  Logger.getLogger(ControleTelas.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        } else {
            ((BasicInternalFrameUI) tela.getUI()).setNorthPane(null); //retirar o painel superior

            tela.getContentPane().setBackground(new Color(69, 69, 71));
            tela.setBorder(null);//retirar bordas

            view.getjDesktopPrincipal().add(tela).setVisible(true);
        }

    }

   /* public Usuario getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(Usuario UsuarioAtivo) {
        this.usuarioAtivo = UsuarioAtivo;
    }*/

}
