/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import static javafx.scene.input.KeyCode.I;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.Usuario;
import tela.InternoJfTelaConfGeral;
import tela.InternoJfTelaConfigUser;
import tela.InternoJfTelaDisicplina;
import tela.InternoJfTelaRelatorio;
import tela.InternoJfTelaTarefa;
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
    
    public void TelaInicio(){
        InternoJfTelaRelatorio telaInicio = new InternoJfTelaRelatorio();
        configGeralInternoFrame(telaInicio);
        
    }
  public void TelaTarefas(){
        InternoJfTelaTarefa telaTarefas = new InternoJfTelaTarefa();
        configGeralInternoFrame(telaTarefas);
        
    }
    
  public void TelaDisicplinas(){
        InternoJfTelaDisicplina telaDisicplina = new InternoJfTelaDisicplina();
        configGeralInternoFrame(telaDisicplina);
        
    }
   public void TelaUserComum(){
        InternoJfTelaConfigUser telaConfigUser = new InternoJfTelaConfigUser();
        configGeralInternoFrame(telaConfigUser);
        
    }
    public void TelaUserGeral(){
        InternoJfTelaConfGeral telaConfigGeral = new InternoJfTelaConfGeral();
        configGeralInternoFrame(telaConfigGeral);
        
    }
    private void configGeralInternoFrame(javax.swing.JInternalFrame tela) {
        ((BasicInternalFrameUI)tela.getUI()).setNorthPane(null); //retirar o painel superior
//telaInicio.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
tela.getContentPane().setBackground(new Color(69,69,71));
tela.setBorder(null);//retirar bordas
//    telaInicio.setBounds(0, 0, view.getjDesktopPrincipal().getWidth(), view.getjDesktopPrincipal().getHeight());
view.getjDesktopPrincipal().add(tela).setVisible(true);
    }

    public Usuario getUsuarioAtivo() {
        return UsuarioAtivo;
    }

    public void setUsuarioAtivo(Usuario UsuarioAtivo) {
        this.UsuarioAtivo = UsuarioAtivo;
    }
    
   
  
  
}