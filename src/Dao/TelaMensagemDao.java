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
import java.util.Random;
import modelo.Mensagem;

/**
 *
 * @author Diana
 */
public class TelaMensagemDao {

    //so pode criar dao se passar conexao
    private final Connection conectar;
private Random aleatorio;
    public TelaMensagemDao(Connection conexao) {
        this.conectar = conexao;
    }

    public void insertmMensagem(Mensagem mensagem) throws SQLException {
        String sql = "insert into mensagem (mensagem)values(?);";

         PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, mensagem.getMensagem());
        statement.execute();
        conectar.close();
    }

  ////Arrayslist de mensagem
       public ArrayList<Mensagem> selecionarTodasMensagem() throws SQLException {
        String sql = "select * from mensagem ORDER BY id ASC";

        PreparedStatement statement = conectar.prepareStatement(sql);
        return pesquisarArrayUser(statement);
    }

    private ArrayList<Mensagem> pesquisarArrayUser(PreparedStatement statement) throws SQLException {
        Mensagem mensagem;
        ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            mensagem = new Mensagem(resultSet.getInt("id"), resultSet.getString("mensagem"));
            mensagens.add(mensagem);
        }
        return mensagens;
    }

    public void deletarMensagem(Mensagem men) throws SQLException {
         String sql = "Delete from mensagem where id =?;";

        PreparedStatement statement = conectar.prepareStatement(sql);

        statement.setInt(1, men.getId());
        statement.execute();
    conectar.close();
    }

    public void UpdateMensagem(Mensagem men) throws SQLException {
             String sql = "update mensagem set mensagem = ?  where id =?;";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, men.getMensagem());
        statement.setInt(2, men.getId());
        statement.execute();
        conectar.close();
    }
}
