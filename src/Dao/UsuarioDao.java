/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Diana
 */
public class UsuarioDao {

    private final Connection conectar;
  //  private Usuario userAtivo;

    //conexao com o banco
    public UsuarioDao(Connection conectar) {
        this.conectar = conectar;
    }

    //inserir usuario
    public void InserirUsuario(Usuario user) throws SQLException {

        // TODO add your handling code here:
        String sql = "insert into usuario (nome,email,usuario,senha,tipo,mensagem)values(?,?,?,?,?,?);";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, user.getNome());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getUsuario());
        statement.setString(4, user.getSenha());
        statement.setString(5, user.getTipo());
        statement.setString(6, user.getMensagem());
        statement.execute();
   // conectar.close();

    }

    public void UpdateUsuario(Usuario user) throws SQLException {
        String sql = "update usuario set nome = ?,email= ?,usuario= ?,senha= ?, tipo =?,mensagem =? where id =?;";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, user.getNome());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getUsuario());
        statement.setString(4, user.getSenha());
        statement.setString(5, user.getTipo());
        statement.setString(6, user.getMensagem());
        statement.setInt(7, user.getId());
        statement.execute();
    //  conectar.close();
    }

    public void deletarUsuario(Usuario user) throws SQLException {
        String sql = "Delete from usuario where id =?;";

        PreparedStatement statement = conectar.prepareStatement(sql);

        statement.setInt(1, user.getId());
        statement.execute();
    conectar.close();
    }

    public ArrayList<Usuario> selecionarTodoUser() throws SQLException {
        String sql = "select * from usuario ORDER BY id ASC";

        PreparedStatement statement = conectar.prepareStatement(sql);
        return pesquisarArrayUser(statement);
    }

    private ArrayList<Usuario> pesquisarArrayUser(PreparedStatement statement) throws SQLException {
        Usuario user;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            user = new Usuario(resultSet.getInt("id"), resultSet.getString("nome"),
                    resultSet.getString("email"), resultSet.getString("usuario"),
                    resultSet.getString("senha"), resultSet.getString("tipo"),
                    resultSet.getString("mensagem"));
            usuarios.add(user);
        }
        return usuarios;
    }


    //////PASSAR USUARIO PARA TELA PRINCIPAL
  public Usuario retornarUsuarioUnico(String usuario,String senha) throws SQLException {
    String sql = "select * from usuario where usuario = ? and senha = ?;";

        PreparedStatement statement = conectar.prepareStatement(sql);
      statement.setString(1, usuario);
        statement.setString(2, senha);
        return pesquisarArrayUser(statement).get(0);

    }
    public Usuario usuarioAtivo(Usuario user) throws SQLException {

        String sql = "select * from usuario where usuario = ? and senha = ?;";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, user.getUsuario());
        statement.setString(2, user.getSenha());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        //      verificar  = resultSet.next();

        while (resultSet.next()) {
            user = new Usuario(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("email"), resultSet.getString("usuario"), resultSet.getString("senha"), resultSet.getString("tipo"), resultSet.getString("mensagem"));

        }
        return user;

        // 
    }
////AUTENTICAR O USUARIO NA TELA LOGIN
    public boolean autenticarUsuario(Usuario userAutenticar) throws SQLException {
        String sql = "select * from usuario where usuario = ? and senha = ?;";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, userAutenticar.getUsuario());
        statement.setString(2, userAutenticar.getSenha());
        statement.execute();
        //pegar resultado do select e colocar na variavel result

        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }



}
