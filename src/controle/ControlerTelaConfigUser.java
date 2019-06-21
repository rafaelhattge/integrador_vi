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
import tela.TelaPrincipal;

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
    public void MostrarDados(){
       view.getjTextUserCod().setText(Integer.toString(usuarioAtivo.getId()));
        view.getjTextTipo().setText(usuarioAtivo.getTipo());
        view.getjTextNome().setText(usuarioAtivo.getNome());
        view.getjTextEmail().setText(usuarioAtivo.getEmail());
        view.getjTextUser().setText(usuarioAtivo.getUsuario());
        view.getjPasswordSenha().setText(usuarioAtivo.getSenha());
        if(usuarioAtivo.getMensagem().equals("sim")){
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
            
      controleBotoes(true);
            view.getjButtonEditar().setText("SALVAR");
                
         }else{
             AlterarUsuario();
             controleBotoes(false);
              view.getjButtonEditar().setText("EDITAR");
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
                usuarioAtivo =usuarioU;
                try {
                    Connection conecta = new conexao().conectarBanco();
                   
                    UsuarioDao userDao = new UsuarioDao(conecta);
                     
                   
                   int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja alterar o usuário:\n"+usuarioAtivo.getNome(),"Confirmar alteração",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(resposta==JOptionPane.OK_OPTION){
                     userDao.UpdateUsuario(usuarioAtivo);
                    JOptionPane.showMessageDialog(null, "Usuário Atualizado com sucesso");
                    }
               limpardados();
               MostrarDados();
                    
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
                usuarioAtivo =usuarioU;
                try {
                    Connection conecta = new conexao().conectarBanco();
                    System.out.println("Conectou");
                    UsuarioDao userDao = new UsuarioDao(conecta);
                      int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir a sua conta?\nApós a exclusão você perderá todos dados","Confirmar Excluir",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(resposta==JOptionPane.OK_OPTION){
                     userDao.deletarUsuario(usuarioAtivo);
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
                    System.exit(0);
                    }
                     System.out.println("Entrou no usuario DAO");
                    userDao.deletarUsuario(usuarioAtivo);
                    System.out.println("Echegou Update");
                    JOptionPane.showMessageDialog(null, "Usuário Atualizado com sucesso");
             
                    
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

    private void limpardados() {
       view.getjTextNome().setText("");
        view.getjTextEmail().setText("");
        view.getjTextUser().setText("");
        view.getjPasswordSenha().setText("");
      view.getjPasswordSenha2().setText("");
     
          
    }

    private void controleBotoes(boolean b) {
      view.getjTextNome().setEditable(b);
        view.getjTextEmail().setEditable(b);
        view.getjTextUser().setEditable(b);
        view.getjPasswordSenha().setEditable(b);
      view.getjPasswordSenha2().setEnabled(b);
      view.getjPasswordSenha2().setEditable(b);
            view.getjRadioButtoMensagem().setEnabled(b);
             view.getjRadioButtonNMensagem().setEnabled(b);
            
            view.getjTextNome().requestFocus(b);
    }
}
