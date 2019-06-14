/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.CursoDao;
import Dao.UsuarioDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.Curso;
import tela.PanelAdicionarCurso;

/**
 *
 * @author Rafael
 */
public class ControleAdicionarCurso {
    
    private final PanelAdicionarCurso view;
    
    public ControleAdicionarCurso(PanelAdicionarCurso view){
        this.view = view;
    }
    
    public void salvarCurso(){
        String nome = view.getjTextField1().getText();
        Curso curso = new Curso(nome);
        
        try {
            if(nome.equals("")){
                JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
            } else {
                Connection conexao = new conexao().conectarBanco();
                CursoDao cursoDao = new CursoDao(conexao);
                UsuarioDao usuarioAtivo = new UsuarioDao(conexao);
                cursoDao.AdicionarCurso(curso, usuarioAtivo);
                JOptionPane.showMessageDialog(null, "Curso adicionado com sucesso.");
                limparCampo();
                SwingUtilities.getWindowAncestor(view).dispose();
            }
        } catch (SQLException ex) {
         //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println(ex);
         JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }  
    }
    
    public void limparCampo(){
        view.getjTextField1().setText("");
    }
}
