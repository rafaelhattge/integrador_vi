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
import modelo.Curso;
import modelo.Disciplina;

/**
 *
 * @author Rafael
 */
public class DisciplinaDao {
    private final Connection conectar;
    
    //Conexão com o banco
    public DisciplinaDao(Connection conectar) {
        this.conectar = conectar;
    }
    
    public void adicionarDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "INSERT INTO disciplina(nome, datainicio, datatermino, domingo, "
                + "segunda, terca, quarta, quinta, sexta, sabado, idcurso) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, disciplina.getNome());
        statement.setDate(2, disciplina.getDataInicio());
        statement.setDate(3, disciplina.getDataTermino());
        statement.setBoolean(4, disciplina.isDomingo());
        statement.setBoolean(5, disciplina.isSegunda());
        statement.setBoolean(6, disciplina.isTerca());
        statement.setBoolean(7, disciplina.isQuarta());
        statement.setBoolean(8, disciplina.isQuinta());
        statement.setBoolean(9, disciplina.isSexta());
        statement.setBoolean(10, disciplina.isSabado());
        statement.setInt(11, disciplina.getIdCurso());
        statement.execute();
        statement.close();
        conectar.close();
    }
    
    public void atualizarDisciplina(Disciplina disciplina, int idDisciplina) throws SQLException {
        String sql = "UPDATE disciplina SET nome = ?, datainicio = ?, datatermino = ?, domingo = ?, "
                + "segunda = ?, terca = ?, quarta = ?, quinta = ?, sexta = ?, sabado = ? WHERE iddisciplina = ?;";
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, disciplina.getNome());
        statement.setDate(2, disciplina.getDataInicio());
        statement.setDate(3, disciplina.getDataTermino());
        statement.setBoolean(4, disciplina.isDomingo());
        statement.setBoolean(5, disciplina.isSegunda());
        statement.setBoolean(6, disciplina.isTerca());
        statement.setBoolean(7, disciplina.isQuarta());
        statement.setBoolean(8, disciplina.isQuinta());
        statement.setBoolean(9, disciplina.isSexta());
        statement.setBoolean(10, disciplina.isSabado());
        statement.setInt(11, idDisciplina);
        statement.execute();
        statement.close();
        conectar.close();
    }
    
    //Carregar as disciplinas a partir do banco de dados e retornar para um ArrayList
    public ArrayList<Disciplina> carregarDisciplinas(int idCurso) throws SQLException {
        
        Disciplina disciplina;
        String sql = "SELECT * FROM disciplina WHERE idcurso = ? ORDER BY nome ASC";
        
        try {
            PreparedStatement statement = conectar.prepareStatement(sql);
            statement.setInt(1, idCurso);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            ArrayList<Disciplina> disciplinas = new ArrayList();

            while(resultSet.next()){
                disciplina = new Disciplina(resultSet.getInt("iddisciplina"), 
                    resultSet.getString("nome"), resultSet.getDate("datainicio"), 
                    resultSet.getDate("datatermino"), resultSet.getBoolean("domingo"),
                    resultSet.getBoolean("segunda"), resultSet.getBoolean("terca"),
                    resultSet.getBoolean("quarta"), resultSet.getBoolean("quinta"),
                    resultSet.getBoolean("sexta"), resultSet.getBoolean("sabado"),
                    resultSet.getInt("idcurso"));
                disciplinas.add(disciplina);
        }
            
        return disciplinas;
        
        }catch(SQLException e){
            return null;
        }
    }
    
    //Deletar a disciplina selecionada
    public void deletarDisciplina(int idDisciplina) throws SQLException {
        String sql = "DELETE FROM disciplina WHERE iddisciplina = ?;";

        PreparedStatement statement = conectar.prepareStatement(sql);

        statement.setInt(1, idDisciplina);
        statement.execute();
        statement.close();
        conectar.close();
    }
}
