/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.Color;
import java.beans.PropertyVetoException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.Usuario;
import tela.TelaMensagem;
import tela.TelaPrincipal;

/**
 *
 * @author Diana
 */
public class ControlerTelaPrincipal {

    private final TelaPrincipal view;
    private Usuario UsuarioAtivo;

    public ControlerTelaPrincipal(TelaPrincipal view) {
        this.view = view;

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

    public Usuario getUsuarioAtivo() {
        return UsuarioAtivo;
    }

    public void setUsuarioAtivo(Usuario UsuarioAtivo) {
        this.UsuarioAtivo = UsuarioAtivo;
    }

}
