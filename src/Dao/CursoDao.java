package Dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public void adicionarCurso(Curso curso, UsuarioDao usuarioAtivo) throws SQLException {

        String sql = "INSERT INTO curso(nome, idusuario) VALUES(?, ?);";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, curso.getNome());
        statement.setInt(2, usuarioAtivo.getUserAtivo().getId());
        statement.execute();
        conectar.close();
    }
    
    public ArrayList carregarCursos(UsuarioDao usuarioAtivo) throws SQLException {
        
        String sql = "SELECT nome FROM curso WHERE idusuario = ? ORDER BY nome ASC";
        
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setInt(1, usuarioAtivo.getUserAtivo().getId());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        ArrayList<String> results = new ArrayList();
        while(resultSet.next()){
            results.add(resultSet.getString(1));
        }

        return results;
    }
}