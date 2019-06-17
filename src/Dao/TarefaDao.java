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
import modelo.Tarefa;

/**
 *
 * @author Rafael
 */
public class TarefaDao {
    private final Connection conectar;
    
    //Conexão com o banco
    public TarefaDao(Connection conectar) {
        this.conectar = conectar;
    }
    
    //Carrega todas as tarefas do bd para o usuário ativo e retorna uma ArrayList de tarefas
    public ArrayList<Tarefa> carregarTarefas(UsuarioDao usuarioAtivo) throws SQLException {
        
        Tarefa tarefa;
        ArrayList<Tarefa> tarefas = new ArrayList();
        String sql = "SELECT idtarefa, tarefa.nome, data, hora, descricao, status, tarefa.iddisciplina, disciplina.nome "
                + "FROM tarefa, usuario, disciplina "
                + "WHERE id = ? AND tarefa.iddisciplina = disciplina.iddisciplina "
                + "ORDER BY data ASC, hora ASC;";
        
        try {
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, usuarioAtivo.getUserAtivo().getId());
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            
            while(resultSet.next()){
                tarefa = new Tarefa(resultSet.getInt(1), 
                                    resultSet.getString(2), 
                                    resultSet.getDate(3), 
                                    resultSet.getTime(4), 
                                    resultSet.getString(5), 
                                    resultSet.getBoolean(6), 
                                    resultSet.getInt(7),
                                    resultSet.getString(8));
                System.out.println(tarefa.getIdTarefa());
                tarefas.add(tarefa);
            }
        } catch (SQLException e){
            System.out.println("Conexão falhou.");
            while (e != null) {
                String errorMessage = e.getMessage();
                System.err.println("sql error message:" + errorMessage);

                // This vendor-independent string contains a code.
                String sqlState = e.getSQLState();
                System.err.println("sql state:" + sqlState);

                int errorCode = e.getErrorCode();
                System.err.println("error code:" + errorCode);
                // String driverName = conn.getMetaData().getDriverName();
                // System.err.println("driver name:"+driverName);
                // processDetailError(drivername, errorCode);
                e = e.getNextException();
            }
        }
        return tarefas;
    }
    
    //Deletar a disciplina selecionada
    public void deletarTarefa(int idTarefa) throws SQLException {
        String sql = "DELETE FROM tarefa WHERE idtarefa = ?;";

        PreparedStatement statement = conectar.prepareStatement(sql);

        statement.setInt(1, idTarefa);
        statement.execute();
        statement.close();
        conectar.close();
    }
}
