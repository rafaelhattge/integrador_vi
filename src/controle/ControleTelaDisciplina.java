/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.CursoDao;
import Dao.DisciplinaDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Usuario;
import tela.InternoJfTelaDisciplina;
import tela.dialog.PanelAdicionarCurso;
import tela.dialog.PanelAdicionarDisciplina;
import tela.dialog.PanelAtualizarCurso;
import tela.dialog.PanelAtualizarDisciplina;

/**
 *
 * @author Rafael
 */
public class ControleTelaDisciplina {
    
    private ArrayList<Curso> cursos;
    private final InternoJfTelaDisciplina view;
    private PanelAdicionarCurso panelAdicCurso;
    private PanelAtualizarCurso panelAtuaCurso;
    private PanelAdicionarDisciplina panelAdicDisciplina;
    private PanelAtualizarDisciplina panelAtuaDisciplina;
    private static Usuario usuarioAtivo;
    private static boolean editarCurso;

    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAtualizarDisciplina panelAtuaDisciplina) {
        this.view = view;
        this.panelAtuaDisciplina = panelAtuaDisciplina;
    }

    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAdicionarDisciplina panelAdicDisciplina) {
        this.view = view;
        this.panelAdicDisciplina = panelAdicDisciplina;
    }

    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAdicionarCurso panelAdicCurso) {
        this.view = view;
        this.panelAdicCurso = panelAdicCurso;
    }

    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAtualizarCurso panelAtuaCurso) {
        this.view = view;
        this.panelAtuaCurso = panelAtuaCurso;
    }

    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAdicionarCurso panelAdicCurso, PanelAtualizarCurso panelAtuaCurso) {
        this.view = view;
        this.panelAdicCurso = panelAdicCurso;
        this.panelAtuaCurso = panelAtuaCurso;
    }
    
    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAdicionarCurso panelAdicCurso, Usuario usuarioAtivo) {
        this.view = view;
        this.panelAdicCurso = panelAdicCurso;
        this.usuarioAtivo = usuarioAtivo;
        cursos = new ArrayList<Curso>();
    }
    
    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAtualizarCurso panelAtuaCurso, Usuario usuarioAtivo) {
        this.view = view;
        this.panelAtuaCurso = panelAtuaCurso;
        this.usuarioAtivo = usuarioAtivo;
        cursos = new ArrayList<Curso>();
    }
    
    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAdicionarDisciplina panelAdicDisciplina, Usuario usuarioAtivo) {
        this.view = view;
        this.panelAdicDisciplina = panelAdicDisciplina;
        this.usuarioAtivo = usuarioAtivo;
        cursos = new ArrayList<Curso>();
    }
    
    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAtualizarDisciplina panelAtuaDisciplina, Usuario usuarioAtivo) {
        this.view = view;
        this.panelAtuaDisciplina = panelAtuaDisciplina;
        this.usuarioAtivo = usuarioAtivo;
        cursos = new ArrayList<Curso>();
    }
    
    public ControleTelaDisciplina(InternoJfTelaDisciplina view, 
            PanelAdicionarCurso dialog, PanelAtualizarCurso panel, Usuario usuarioAtivo) {
        this.view = view;
        this.panelAdicCurso = dialog;
        this.panelAtuaCurso = panel;
        this.usuarioAtivo = usuarioAtivo;
        cursos = new ArrayList<Curso>();
    }
    
    //Carrega a lista de cursos do CursoDao e retorna um ArrayList
    public ArrayList<Curso> carregarListaCursos() {
        ArrayList<Curso> listaCursos = new ArrayList();
        try {
            Connection conexao = new conexao().conectarBanco();
            CursoDao cursoDao = new CursoDao(conexao);
            listaCursos = cursoDao.carregarCursos(usuarioAtivo);
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCursos;
    }
    
    //Exibe a lista de cursos na jComboBox
    public void exibirCursos(){
        
        ArrayList<Curso> listaCursos = carregarListaCursos();
        
        view.getjComboBoxCurso().removeAllItems();
        if(listaCursos.size() > 0){
            for(Curso curso : listaCursos) {
                view.getjComboBoxCurso().addItem(curso.getNome());
            }   
        }    
    }
    
    public void salvarCurso() throws ParseException{
        String nome = panelAdicCurso.getjTextField1().getText();
        Curso curso = new Curso(nome);
        
        try {
            if(nome.equals("")){
                JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
            } else {
                Connection conexao = new conexao().conectarBanco();
                CursoDao cursoDao = new CursoDao(conexao);

                cursoDao.adicionarCurso(curso, usuarioAtivo);
                JOptionPane.showMessageDialog(null, "Curso adicionado com sucesso.");
                limparjTextFieldAdicionar();
                exibirCursos();
                exibirDisciplinas();
                SwingUtilities.getWindowAncestor(panelAdicCurso).dispose();
            }
        } catch (SQLException ex) {
         //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println(ex);
         JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }  
    }
    
    public void editarCurso() throws ParseException{
        Curso curso = carregarListaCursos().get(view.getjComboBoxCurso().getSelectedIndex());
        try {
            if(panelAtuaCurso.getjTextFieldAtualizar().getText().equals("")){
                JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
            } else {
                
                Connection conexao = new conexao().conectarBanco();
                CursoDao cursoDao = new CursoDao(conexao);
                int id = curso.getId();
                String nome = panelAtuaCurso.getjTextFieldAtualizar().getText();
                cursoDao.atualizarCurso(curso, id, nome);
                JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso.");
                limparjTextFieldAtualizar();
                exibirCursos();
                exibirDisciplinas();
                SwingUtilities.getWindowAncestor(panelAtuaCurso).dispose();
            }
        } catch (SQLException ex) {
         System.out.println(ex);
         JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }
        
    }
    
    
    public void removerCurso() throws ParseException {
        if(view.getjComboBoxCurso().getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(view, "Não há itens para serem removidos.");
        } else {
            int confirmar = JOptionPane.showConfirmDialog(view, "A remoção do curso "
                    + "removerá também as disciplinas, tarefas\n e subtarefas deste curso. Deseja proceder?", "Remover Curso", JOptionPane.YES_NO_OPTION);
            if(confirmar == JOptionPane.YES_OPTION){
                int idCurso;
                this.setCursos(carregarListaCursos());
                if(cursos.size() > 0) {
                idCurso = cursos.get(view.getjComboBoxCurso().getSelectedIndex()).getId();
                cursos.remove(view.getjComboBoxCurso().getSelectedIndex());

                try {
                    Connection conexao = new conexao().conectarBanco();
                    CursoDao cursoDao = new CursoDao(conexao);
                    cursoDao.deletarCurso(idCurso);

                } catch (SQLException ex) {
                    Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
                }

                exibirCursos();
                exibirDisciplinas();
                }
            }
        }
    }
    
    //Carrega a lista de disciplinas do DisciplinaDao e retorna um ArrayList
    public ArrayList<Disciplina> carregarListaDisciplinas() {
        ArrayList<Disciplina> listaDisciplinas = new ArrayList();
        this.setCursos(carregarListaCursos());
        if(cursos.size() > 0){
        try {
            int idCurso = cursos.get(view.getjComboBoxCurso().getSelectedIndex()).getId();
            Connection conexao = new conexao().conectarBanco();
            DisciplinaDao disciplinaDao = new DisciplinaDao(conexao);
            listaDisciplinas = disciplinaDao.carregarDisciplinas(idCurso);

            } catch (SQLException ex) {
                Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaDisciplinas;
    }
    
    //Exibe a lista de disciplinas na jTable
    public void exibirDisciplinas() throws ParseException{
        //carregarListaDisciplinas();
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableDisciplinas().getModel();
        ArrayList<Disciplina> disciplinas = carregarListaDisciplinas();
        
        tableModel.setRowCount(0);

            if(disciplinas.size() > 0){
                Object dados[] = new Object[10];
                for(int i = 0; i < disciplinas.size(); i++) {
                    dados[0] = disciplinas.get(i).getNome();
                    dados[1] = formatarData(disciplinas.get(i).getDataInicio());
                    dados[2] = formatarData(disciplinas.get(i).getDataTermino());
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
    
    
    public void salvarDisciplina() throws ParseException{
        Curso curso = carregarListaCursos().get(view.getjComboBoxCurso().getSelectedIndex());
        String nome = panelAdicDisciplina.getjTextFieldNome().getText();
        Date dataInicio  = converterData(panelAdicDisciplina.getjTextFieldInicio().getText());
        Date dataTermino  = converterData(panelAdicDisciplina.getjTextFieldTermino().getText());
        Boolean dom = panelAdicDisciplina.getjCheckBoxDom().isSelected();
        Boolean seg = panelAdicDisciplina.getjCheckBoxSeg().isSelected();
        Boolean ter = panelAdicDisciplina.getjCheckBoxTer().isSelected();
        Boolean qua = panelAdicDisciplina.getjCheckBoxQua().isSelected();
        Boolean qui = panelAdicDisciplina.getjCheckBoxQui().isSelected();
        Boolean sex = panelAdicDisciplina.getjCheckBoxSex().isSelected();
        Boolean sab = panelAdicDisciplina.getjCheckBoxSab().isSelected();
        int idCurso = curso.getId();

        Disciplina disciplina = new Disciplina(nome, dataInicio, dataTermino, dom,
                seg, ter, qua, qui, sex, sab, idCurso);
        
        try {
            if(nome.equals("")){
                JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
            }else if(dataInicio.after(dataTermino)){
                JOptionPane.showMessageDialog(null, "A data de término precisa ser posterior à data de incício.");
            } else {
                Connection conexao = new conexao().conectarBanco();
                DisciplinaDao disciplinaDao = new DisciplinaDao(conexao);
                disciplinaDao.adicionarDisciplina(disciplina);
                JOptionPane.showMessageDialog(null, "Disciplina adicionada com sucesso.");
                exibirDisciplinas();
                SwingUtilities.getWindowAncestor(panelAdicDisciplina).dispose();
                conexao.close();
            }
        } catch (SQLException ex) {
         //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println(ex);
         JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }
    }
    
    public void editarDisciplina() throws ParseException {
        int linha = view.getjTableDisciplinas().getSelectedRow();

        String nome = panelAtuaDisciplina.getjTextFieldNome().getText();
        Date dataInicio  = converterData(panelAtuaDisciplina.getjTextFieldInicio().getText());
        Date dataTermino  = converterData(panelAtuaDisciplina.getjTextFieldTermino().getText());
        Boolean dom = panelAtuaDisciplina.getjCheckBoxDom().isSelected();
        Boolean seg = panelAtuaDisciplina.getjCheckBoxSeg().isSelected();
        Boolean ter = panelAtuaDisciplina.getjCheckBoxTer().isSelected();
        Boolean qua = panelAtuaDisciplina.getjCheckBoxQua().isSelected();
        Boolean qui = panelAtuaDisciplina.getjCheckBoxQui().isSelected();
        Boolean sex = panelAtuaDisciplina.getjCheckBoxSex().isSelected();
        Boolean sab = panelAtuaDisciplina.getjCheckBoxSab().isSelected();

        Disciplina disciplina = new Disciplina(nome, dataInicio, dataTermino, dom,
                seg, ter, qua, qui, sex, sab);
        try {
            if(linha >= 0){
                int idDisciplina = carregarListaDisciplinas().get(linha).getIdDisciplina();
                 if(nome.equals("")){
                    JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
                } else {
                    Connection conexao = new conexao().conectarBanco();
                    DisciplinaDao disciplinaDao = new DisciplinaDao(conexao);
                    disciplinaDao.atualizarDisciplina(disciplina, idDisciplina);
                    JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso.");
                    exibirDisciplinas();
                }
            }     
        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removerDisciplina() throws ParseException {
        
        int linha = view.getjTableDisciplinas().getSelectedRow();
        int confirmar = JOptionPane.showConfirmDialog(view, "A remoção da disciplina "
                + "removerá também as tarefas\n e subtarefas desta disciplina. Deseja proceder?", "Remover Disciplina", JOptionPane.YES_NO_OPTION);
        if(confirmar == JOptionPane.YES_OPTION){
            try {
                if(linha >= 0){
                int idDisciplina = carregarListaDisciplinas().get(linha).getIdDisciplina();
                Connection conexao = new conexao().conectarBanco();
                DisciplinaDao disciplinaDao = new DisciplinaDao(conexao);
                disciplinaDao.deletarDisciplina(idDisciplina);
                exibirDisciplinas();
            }

            } catch (SQLException ex) {
                Logger.getLogger(InternoJfTelaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
            }

            exibirDisciplinas();
        }
    }
    
    //converte uma string para data em formato SQL
    public Date converterData(String sData) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = format.parse(sData);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());  

        return sqlDate;
    }

    //Formata a data recebida SQL para uma string dd/MM/yyyy
    public String formatarData(Date data) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }
    
    //Passa o nome do curso para ser usado no jTextField do Jpanel que atualiza o nome
    public String retornarNomeCurso(){
        return carregarListaCursos().get(view.getjComboBoxCurso().getSelectedIndex()).getNome();
    }
    
    //Retorna os atributos da disciplina para serem usados nos jTextFields do JPanel que atualiza estes campos
    public Disciplina retornarDisciplina() {
        return carregarListaDisciplinas().get(view.getjTableDisciplinas().getSelectedRow());
    }

    public void limparjTextFieldAdicionar(){
        panelAdicCurso.getjTextField1().setText("");
    }
    
    public void limparjTextFieldAtualizar(){
        panelAtuaCurso.getjTextFieldAtualizar().setText("");
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public boolean isEditarCurso() {
        return editarCurso;
    }

    public void setEditarCurso(boolean editarCurso) {
        this.editarCurso = editarCurso;
    }
}
