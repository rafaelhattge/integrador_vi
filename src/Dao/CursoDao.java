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
import java.sql.Statement;
import modelo.Curso;
import tela.InternoJfTelaDisciplina;

/**
 *
 * @author Rafael
 */
public class CursoDao {
    private final Connection conectar;

    //conexao com o banco
    public CursoDao(Connection conectar) {
        this.conectar = conectar;
    }

    public void AdicionarCurso(Curso curso, UsuarioDao usuarioAtivo) throws SQLException {

        // TODO add your handling code here:
        String sql = "INSERT INTO curso(nome, idusuario) VALUES(?, ?);";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, curso.getNome());
        statement.setInt(2, usuarioAtivo.getUserAtivo().getId());
        statement.execute();
        conectar.close();
    }
}