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
import modelo.Subtarefa;
import modelo.Usuario;

/**
 *
 * @author Rafael
 */
public class SubtarefaDao {
    
    private final Connection conectar;
    
    public SubtarefaDao(Connection conectar) {
        this.conectar = conectar;
    }
    
    public void adicionarTarefa(Subtarefa subtarefa) throws SQLException {
        
        String sql = "INSERT INTO subtarefa(nome, status, idtarefa) VALUES(?, ?, ?);";
        
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, subtarefa.getNome());
        statement.setBoolean(2, subtarefa.isStatus());
        statement.setInt(3, subtarefa.getIdTarefa());
        statement.execute();
        statement.close();
        conectar.close();
    }
    
    public void atualizarTarefa(Subtarefa subtarefa) throws SQLException {
        
        String sql = "UPDATE subtarefa SET nome = ?, status = ?, idtarefa = ? WHERE idsubtarefa = ?;";
        
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, subtarefa.getNome());
        statement.setBoolean(2, subtarefa.isStatus());
        statement.setInt(3, subtarefa.getIdTarefa());
        statement.setInt(4, subtarefa.getIdSubtarefa());
        statement.execute();
        statement.close();
        conectar.close();
    }
    
    public ArrayList<Subtarefa> carregarSubtarefas(int idTarefa) throws SQLException {
        
        Subtarefa subtarefa;
        ArrayList<Subtarefa> subtarefas = new ArrayList();
        String sql = "SELECT idsubtarefa, subtarefa.nome, subtarefa.status, "
                + "subtarefa.idtarefa, tarefa.nome "
                + "FROM subtarefa, tarefa, usuario, disciplina, curso "
                + "WHERE tarefa.idtarefa = ? AND subtarefa.idtarefa = tarefa.idtarefa "
                + "AND tarefa.iddisciplina = disciplina.iddisciplina "
                + "AND curso.idcurso = disciplina.idcurso "
                + "AND curso.idusuario = usuario.id "
                + "ORDER BY subtarefa.nome ASC";
        
        try {
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, idTarefa);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            
            while(resultSet.next()){
                subtarefa = new Subtarefa(resultSet.getInt(1),
                                          resultSet.getString(2),
                                          resultSet.getBoolean(3), 
                                          resultSet.getInt(4),
                                          resultSet.getString(5));
                subtarefas.add(subtarefa);
            }
        } catch (SQLException e){
            System.out.println("Conexão falhou.");
            while (e != null) {
                String errorMessage = e.getMessage();
                System.err.println("sql error message:" + errorMessage);
                String sqlState = e.getSQLState();
                System.err.println("sql state:" + sqlState);
                int errorCode = e.getErrorCode();
                System.err.println("error code:" + errorCode);
                e = e.getNextException();
            }
        }
        return subtarefas;
    }
}
