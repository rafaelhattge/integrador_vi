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
    
    //Carregar as disciplinas a partir do banco de dados e retornar para um ArrayList
    public ArrayList<Disciplina> carregarDisciplinas(int idCurso) throws SQLException {
        
        Disciplina disciplina;
        String sql = "SELECT * FROM disciplina WHERE idcurso = ? ORDER BY nome ASC";
        
        try{
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setInt(1, idCurso);
        statement.execute();
        System.out.println(idCurso);
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
}
