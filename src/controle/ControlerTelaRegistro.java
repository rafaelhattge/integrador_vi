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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;
import tela.TelaLogin;
import tela.TelaRegistro;

/**
 *
 * @author Diana
 */
public class ControlerTelaRegistro {

    private final TelaRegistro view;

    public ControlerTelaRegistro(TelaRegistro view) {
        this.view = view;
    }

    public void salvarUsuario() {
        if (view.getjPasswordSenha().getText().equals(view.getjPasswordSenhaRepete().getText())) {

            if (view.getjTextNome().getText().equals("")
                    || view.getjTextEmail().getText().equals("")
                    || view.getjTextUser().getText().equals("")
                    || view.getjPasswordSenha().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos campos são obrigátorios");
            } else {
                Usuario user = new Usuario(view.getjTextNome().getText(), view.getjTextEmail().getText(), view.getjTextUser().getText(), view.getjPasswordSenha().getText());

                try {
                    Connection conexao = new conexao().conectarBanco();
                    UsuarioDao userDao = new UsuarioDao(conexao);
                    userDao.InserirUsuario(user);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                    limparRegistro();
                    TelaLogin telalogin = new TelaLogin();
                    TelaLogin login = new TelaLogin();
                    login.setVisible(true);
                    view.dispose();
                } catch (SQLException ex) {
                    //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível a conexão!");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Senhas não correspodem");
            view.getjPasswordSenha().setText("");
            view.getjPasswordSenhaRepete().setText("");
        }
    }

    public void limparRegistro() {
        view.getjPasswordSenha().setText("");
        view.getjPasswordSenhaRepete().setText("");
        view.getjTextEmail().setText("");
        view.getjTextNome().setText("");
        view.getjTextUser().setText("");
    }
}
