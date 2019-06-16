package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Curso;

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

    //Adiciona um curso ao bd para o usuario ativo
    public void adicionarCurso(Curso curso, UsuarioDao usuarioAtivo) throws SQLException {

        String sql = "INSERT INTO curso(nome, idusuario) VALUES(?, ?);";

        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, curso.getNome());
        statement.setInt(2, usuarioAtivo.getUserAtivo().getId());
        statement.execute();
        conectar.close();
    }
    
    public void atualizarCurso(Curso curso, int idCurso, String nome)throws SQLException {
        String sql = "UPDATE curso SET nome = ? WHERE idcurso = ?;";
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setInt(2, idCurso);
        statement.execute();
        conectar.close();
    }
    
    //Carrega todos os cursos do bd para o usuário ativo e retorna uma ArrayList de cursos
    public ArrayList<Curso> carregarCursos(UsuarioDao usuarioAtivo) throws SQLException {
        
        Curso curso;
        String sql = "SELECT * FROM curso WHERE idusuario = ? ORDER BY nome ASC";
        
        PreparedStatement statement = conectar.prepareStatement(sql);
        statement.setInt(1, usuarioAtivo.getUserAtivo().getId());
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        ArrayList<Curso> cursos = new ArrayList();
        while(resultSet.next()){
            curso = new Curso(resultSet.getInt("idcurso"), 
                    resultSet.getString("nome"), resultSet.getInt("idusuario"));
            cursos.add(curso);
        }

        return cursos;
    }
    
    public void deletarCurso(int idCurso) throws SQLException {
        String sql = "DELETE FROM curso WHERE idcurso = ?;";

        PreparedStatement statement = conectar.prepareStatement(sql);

        statement.setInt(1, idCurso);
        statement.execute();    
    }
}