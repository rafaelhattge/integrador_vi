/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.UsuarioDao;
import Dao.conexao;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Usuario;
import tela.TelaLogin;
import tela.TelaMensagem;
import tela.TelaPrincipal;
import tela.TelaRegistro;

/**
 *
 * @author Diana
 */
public class ControlerTelaLogin {
    private final TelaLogin view ;

    public ControlerTelaLogin(TelaLogin view) {
        this.view = view;
    }
    public void autenticarUsuario() throws SQLException{
        //buscar usuario da view
        String usuario = view.getjTextUser().getText();
        String senha = view.getjPasswordSenha().getText();
        if(usuario.isEmpty()|| senha.isEmpty()){
            view.getJlblMessagem().setText("Todos campos são obrigatórios!");
      view.getjTextUser().requestFocus();
          
        }else{
         Usuario userAutenticar = new Usuario(usuario, senha);
        //conexao
        
        Connection conexao = new conexao().conectarBanco();
            UsuarioDao userDao = new UsuarioDao(conexao);
             //verificar se existe no banco
            boolean autenticar = userDao.AutenticarUsuario(userAutenticar);
            if(autenticar){
       //     Usuario UsuarioAtivo= userDao.usuarioAtivo(userAutenticar);
              
            TelaPrincipal tela = new TelaPrincipal();
                  tela.getjLabelUsarioLogado().setText(userAutenticar.getNome()); 
                  System.out.println(userAutenticar.getNome());
                  
        
      tela.getContentPane().setBackground(new Color(69, 69, 71));
 //   tela.setResizable(false);
   //   tela.setLocationRelativeTo(null);
  // tela.pack();
            tela.setVisible(true);
            view.dispose();
            //Exibe mensagem inicial
            TelaMensagem mensagem = new TelaMensagem(tela, true);
                  mensagem.setVisible(true);
            
       
            }else{
                 view.getJlblMessagem().setText("Usuário ou senha inválidos!");
                 view.getjTextUser().requestFocus();
                 view.getjTextUser().setText("");
                 view.getjPasswordSenha().setText("");
                
         
            
            }
       
        }
       
        
        
        
    }
    public void limparTelaLogin(){
        view.getJlblMessagem().setText("");
                 view.getjTextUser().setText("");
                 view.getjTextUser().setText("");
                 view.getjPasswordSenha().setText("");
        
    }
    public void chamarTelaCadastro(){
         TelaRegistro registro = new TelaRegistro();
        registro.setVisible(true);
      
        view.dispose();
    }
}
