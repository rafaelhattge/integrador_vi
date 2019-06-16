/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.CursoDao;
import Dao.DisciplinaDao;
import Dao.UsuarioDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Disciplina;
import tela.InternoJfTelaDisciplina;
import tela.PanelAdicionarCurso;

/**
 *
 * @author Rafael
 */
public class ControleTelaDisciplina {
    
    private ArrayList<Curso> cursos;
    private final InternoJfTelaDisciplina view;
    private final PanelAdicionarCurso dialog;

    public ControleTelaDisciplina(InternoJfTelaDisciplina view, PanelAdicionarCurso dialog) {
        this.view = view;
        this.dialog = dialog;
        cursos = new ArrayList<Curso>();
    }
    
    //Carrega a lista de cursos do CursoDao e retorna um ArrayList
    public ArrayList<Curso> carregarListaCursos() {
        try {
            Connection conexao = new conexao().conectarBanco();
            CursoDao cursoDao = new CursoDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            ArrayList<Curso> listaCursos = cursoDao.carregarCursos(usuarioDao);
            
            return listaCursos;

        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //Exibe a lista de cursos na jComboBox
    public void exibirCursos(){
        ArrayList<Curso> listaCursos = carregarListaCursos();
        
        view.getjComboBoxCurso().removeAllItems();
            
        for(Curso curso : listaCursos) {
            view.getjComboBoxCurso().addItem(curso.getNome());
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
                exibirDisciplinas();
                SwingUtilities.getWindowAncestor(dialog).dispose();
            }
        } catch (SQLException ex) {
         //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println(ex);
         JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }  
    }
    
    
    public void removerCurso() {
        int idCurso;
        this.setCursos(carregarListaCursos());
        System.out.println(cursos.get(view.getjComboBoxCurso().getSelectedIndex()).getNome());
        idCurso = cursos.get(view.getjComboBoxCurso().getSelectedIndex()).getId();
        cursos.remove(view.getjComboBoxCurso().getSelectedIndex());
        
        try {
            Connection conexao = new conexao().conectarBanco();
            CursoDao cursoDao = new CursoDao(conexao);
            cursoDao.deletarUsuario(idCurso);
            
        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        exibirCursos();
        exibirDisciplinas();
    }
    
    //Carrega a lista de disciplinas do DisciplinaDao e retorna um ArrayList
    public ArrayList<Disciplina> carregarListaDisciplinas() {
        
        try {
            this.setCursos(carregarListaCursos());
            int idCurso = cursos.get(view.getjComboBoxCurso().getSelectedIndex()).getId();
            Connection conexao = new conexao().conectarBanco();
            DisciplinaDao disciplinaDao = new DisciplinaDao(conexao);
            ArrayList<Disciplina> listaDisciplinas = disciplinaDao.carregarDisciplinas(idCurso);

            return listaDisciplinas;

        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //Exibe a lista de disciplinas na jTable
    public void exibirDisciplinas(){
        carregarListaDisciplinas();
        
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableDisciplinas().getModel();
        ArrayList<Disciplina> disciplinas = carregarListaDisciplinas();
        tableModel.setRowCount(0);


            if(disciplinas.size() > 0){
                Object dados[] = new Object[10];
                for(int i = 0; i < disciplinas.size(); i++) {
                    dados[0] = disciplinas.get(i).getNome();
                    dados[1] = disciplinas.get(i).getDataInicio();
                    dados[2] = disciplinas.get(i).getDataTermino();
                    dados[3] = disciplinas.get(i).isDomingo();
                    dados[4] = disciplinas.get(i).isSegunda();
                    dados[5] = disciplinas.get(i).isTerca();
                    dados[6] = disciplinas.get(i).isQuarta();
                    dados[7] = disciplinas.get(i).isQuinta();
                    dados[8] = disciplinas.get(i).isSexta();
                dados[9] = disciplinas.get(i).isSabado();
                tableModel.addRow(dados);
            }
        } 
    }
    
    public void limparCampo(){
        dialog.getjTextField1().setText("");
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
}
