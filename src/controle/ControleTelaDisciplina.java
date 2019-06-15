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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.Curso;
import tela.InternoJfTelaDisciplina;
import tela.PanelAdicionarCurso;

/**
 *
 * @author Rafael
 */
public class ControleTelaDisciplina {
    
    private final InternoJfTelaDisciplina view;
    private final PanelAdicionarCurso dialog;

    public ControleTelaDisciplina(InternoJfTelaDisciplina view, PanelAdicionarCurso dialog) {
        this.view = view;
        this.dialog = dialog;
    }
    
    
    public void exibirCursos(){
        try {
            Connection conexao = new conexao().conectarBanco();
            CursoDao cursoDao = new CursoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            cursoDao.carregarCursos(usuarioDao);

            ArrayList<String> cursos = cursoDao.carregarCursos(usuarioDao);
            
            view.getjComboBoxCurso().removeAllItems();
            
            for(String curso : cursos) {
                System.out.println(curso);
                view.getjComboBoxCurso().addItem(curso);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvarCurso(){
        String nome = dialog.getjTextField1().getText();
        Curso curso = new Curso(nome);
        
        try {
            if(nome.equals("")){
                JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
            } else {
                Connection conexao = new conexao().conectarBanco();
                CursoDao cursoDao = new CursoDao(conexao);
                UsuarioDao usuarioAtivo = new UsuarioDao(conexao);
                cursoDao.adicionarCurso(curso, usuarioAtivo);
                System.out.println(usuarioAtivo.getUserAtivo().getNome());
                JOptionPane.showMessageDialog(null, "Curso adicionado com sucesso.");
                limparCampo();
                exibirCursos();
                SwingUtilities.getWindowAncestor(dialog).dispose();
            }
        } catch (SQLException ex) {
         //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println(ex);
         JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }  
    }
    
    public void limparCampo(){
        dialog.getjTextField1().setText("");
    }
    
}
