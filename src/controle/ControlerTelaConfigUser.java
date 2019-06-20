/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.UsuarioDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import tela.InternoJfTelaConfigUser;

/**
 *
 * @author Diana
 */
public class ControlerTelaConfigUser {

    private final InternoJfTelaConfigUser view;
  //private Usuario user =new Usuario();
    private static Usuario usuarioAtivo;
    public ControlerTelaConfigUser(InternoJfTelaConfigUser view,Usuario user) {
        this.view = view;
    this.usuarioAtivo = user;
       // MostrarDados(user);
    }
    public void MostrarDados(Usuario user){
       view.getjTextUserCod().setText(Integer.toString(user.getId()));
        view.getjTextTipo().setText(user.getTipo());
        view.getjTextNome().setText(user.getNome());
        view.getjTextEmail().setText(user.getEmail());
        view.getjTextUser().setText(user.getUsuario());
        view.getjPasswordSenha().setText(user.getSenha());
        if(user.getMensagem().equals("sim")){
            view.getjRadioButtoMensagem().setSelected(true);
        }else{
            view.getjRadioButtonNMensagem().setSelected(true);
        }
    }

    public ControlerTelaConfigUser(InternoJfTelaConfigUser view) {
        this.view = view;
    }
    public void liberareditacaoUser(){
         if(view.getjButtonEditar().getText().equals("EDITAR")){
              view.getjTextTipo().setEditable(true);
        view.getjTextNome().setEditable(true);
        view.getjTextEmail().setEditable(true);
        view.getjTextUser().setEditable(true);
        view.getjPasswordSenha().setEditable(true);
      view.getjPasswordSenha2().setEnabled(true);
      view.getjPasswordSenha2().setEditable(true);
            view.getjRadioButtoMensagem().setEnabled(true);
       
            view.getjRadioButtonNMensagem().setEnabled(true);
            view.getjTextTipo().requestFocus(true);
            view.getjButtonEditar().setText("SALVAR");
                
         }else{
             AlterarUsuario();
         }
    }
    ///metodo Update User
    public void AlterarUsuario() {
        if (view.getjPasswordSenha().getText().equals(view.getjPasswordSenha2().getText())) {

            if (view.getjTextNome().getText().equals("")
                    || view.getjTextEmail().getText().equals("")
                    || view.getjTextUser().getText().equals("")
                    || view.getjPasswordSenha().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos campos são obrigátorios");
            } else {
            int id = Integer.parseInt(view.getjTextUserCod().getText());
            String nome = view.getjTextNome().getText();
            String email =view.getjTextEmail().getText();
            String usuar =view.getjTextUser().getText();
            String senh = view.getjPasswordSenha().getText();
  String tip = view.getjTextTipo().getText();
          String mensa = mensageSelecionada();
                Usuario usuarioU = new Usuario(id, nome, email, usuar, senh,tip,mensa);
                try {
                    Connection conecta = new conexao().conectarBanco();
                    System.out.println("Conectou");
                    UsuarioDao userDao = new UsuarioDao(conecta);
                     System.out.println("Entrou no usuario DAO");
                    userDao.InserirUsuario(usuarioAtivo);
                    System.out.println("Echegou Update");
                    JOptionPane.showMessageDialog(null, "Usuário Atualizado com sucesso");
                 //   limparRegistro();
                 //   MostrarDados(usuario);
                    
                } catch (SQLException ex) {
                    //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível a atualizar usuario\n"+nome);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Senhas não correspodem");
            view.getjPasswordSenha().setText("");
            view.getjPasswordSenha2().setText("");
        }
    }
       
       public void DeleTarUsuario() {
       
            int id = Integer.parseInt(view.getjTextUserCod().getText());
            String nome = view.getjTextNome().getText();
            String email =view.getjTextEmail().getText();
            String usuar =view.getjTextUser().getText();
            String senh = view.getjPasswordSenha().getText();
            String tip = view.getjTextTipo().getText();
            String mensa = mensageSelecionada();
                Usuario usuarioU = new Usuario(id, nome, email, usuar, senh, tip, mensa);
                try {
                    Connection conecta = new conexao().conectarBanco();
                    System.out.println("Conectou");
                    UsuarioDao userDao = new UsuarioDao(conecta);
                     System.out.println("Entrou no usuario DAO");
                    userDao.deletarUsuario(usuarioU);
                    System.out.println("Echegou Update");
                    JOptionPane.showMessageDialog(null, "Usuário Atualizado com sucesso");
                 //   limparRegistro();
                 //   MostrarDados(usuario);
                    
                } catch (SQLException ex) {
                    //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível deletar o usuario\n"+nome);
                }
      


    }
       
         
        public String mensageSelecionada(){
String mensagem="";
 if(view.getjRadioButtoMensagem().isSelected()){
          mensagem="sim";
        }else{
           mensagem="nao";
        }
return mensagem;
}
    public void naoPermitido(){
        if(view.getjButtonEditar().getText().equals("SALVAR")){
            view.getjLabelMensagemUser().setText("Não é permitido editar este campo!");
          }
    }
}
