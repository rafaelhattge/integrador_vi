/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tarefa;
import modelo.Usuario;

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
    
    
    public void adicionarTarefa(Tarefa tarefa) throws SQLException {
        
        String sql = "INSERT INTO tarefa(nome, data, hora, descricao, "
                + "status, iddisciplina) VALUES(?, ?, ?, ?, ?, ?);";
        
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, tarefa.getNome());
        statement.setDate(2, tarefa.getData());
        statement.setTime(3, tarefa.getHora());
        statement.setString(4, tarefa.getDescricao());
        statement.setBoolean(5, tarefa.isStatus());
        statement.setInt(6, tarefa.getIdDisciplina());
        statement.execute();
        statement.close();
        conectar.close();
    }
    
    public void atualizarTarefa(Tarefa tarefa) throws SQLException {
        
        String sql = "UPDATE disciplina SET nome = ?, data = ?, hora = ?, descricao = ?, status = ? WHERE idtarefa = ?;";
        
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, tarefa.getNome());
        statement.setDate(2, tarefa.getData());
        statement.setTime(3, tarefa.getHora());
        statement.setString(4, tarefa.getDescricao());
        statement.setBoolean(5, tarefa.isStatus());
        statement.setInt(6, tarefa.getIdTarefa());
        statement.execute();
        statement.close();
        conectar.close();

    }
    
    //Carrega todas as tarefas do bd para o usuário ativo e retorna uma ArrayList de tarefas
    public ArrayList<Tarefa> carregarTarefas(Usuario usuarioAtivo) throws SQLException {
        
        Tarefa tarefa;
        ArrayList<Tarefa> tarefas = new ArrayList();
        String sql = "SELECT idtarefa, tarefa.nome, data, hora, "
                + "descricao, status, tarefa.iddisciplina, disciplina.nome "
                + "FROM tarefa, usuario, disciplina, curso "
                + "WHERE id = ? AND tarefa.iddisciplina = disciplina.iddisciplina "
                + "AND curso.idcurso = disciplina.idcurso AND curso.idusuario = "
                + "usuario.id ORDER BY data ASC, hora ASC;";
        
        try {
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, usuarioAtivo.getId());
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
                tarefas.add(tarefa);
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
        return tarefas;
    }
    
    //Deletar a tarefa selecionada
    public void deletarTarefa(int idTarefa) throws SQLException {
        String sql = "DELETE FROM tarefa WHERE idtarefa = ?;";

        PreparedStatement statement = conectar.prepareStatement(sql);

        statement.setInt(1, idTarefa);
        statement.execute();
        statement.close();
        conectar.close();
    }
    
    public ArrayList<Date> carregarDatasTarefas(Usuario usuarioAtivo) throws SQLException {
        ArrayList<Date> datas = new ArrayList();
        
        String sql = "SELECT data FROM tarefa, usuario, disciplina, curso "
                + "WHERE id = ? AND tarefa.iddisciplina = disciplina.iddisciplina "
                + "AND curso.idcurso = disciplina.idcurso AND curso.idusuario = "
                + "usuario.id GROUP BY data ORDER BY data ASC;";
        try {
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, usuarioAtivo.getId());
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            
            while(resultSet.next()){
              
                datas.add(resultSet.getDate(1));
            }
            return datas;
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
                e = e.getNextException();
            }
            return datas;
        }
    }
    
    public ArrayList<Tarefa> carregarTarefasPorData(Usuario usuarioAtivo, Date data) throws SQLException {
        Tarefa tarefa;
        ArrayList<Tarefa> tarefas = new ArrayList();
        
        String sql = "SELECT idtarefa, hora, tarefa.nome FROM tarefa, usuario, disciplina, curso "
                + "WHERE data = ? AND id = ? "
                + "AND tarefa.iddisciplina = disciplina.iddisciplina "
                + "AND curso.idcurso = disciplina.idcurso "
                + "AND curso.idusuario = usuario.id "
                + "ORDER BY hora ASC;";
        try {
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setDate(1, data);
            statement.setInt(2, usuarioAtivo.getId());
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            
            while(resultSet.next()){
                tarefa = new Tarefa(resultSet.getInt(1),
                                    resultSet.getString(3),
                                    resultSet.getTime(2));
                tarefas.add(tarefa);
            }
            return tarefas;
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
                e = e.getNextException();
            }
            return tarefas;
        }
    }
}
