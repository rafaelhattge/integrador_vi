/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.DisciplinaDao;
import Dao.TarefaDao;
import Dao.UsuarioDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.Disciplina;
import modelo.Tarefa;
import modelo.Usuario;
import tela.InternoJfTelaTarefa;

/**
 *
 * @author Diana
 */
public class ControleTarefa {

    private final InternoJfTelaTarefa view;
    private static Usuario usuarioAtivo;

    public ControleTarefa(InternoJfTelaTarefa view) {
        this.view = view;
    }

    public ControleTarefa(InternoJfTelaTarefa view, Usuario usuarioAtivo) {
        this.view = view;
        this.usuarioAtivo = usuarioAtivo;
    }

    public void TrocaTarefas(JPanel tela) {
        view.getjLayeredPaneGereTarefa().removeAll();
        view.getjLayeredPaneGereTarefa().add(tela);
        view.getjLayeredPaneGereTarefa().repaint();
        view.getjLayeredPaneGereTarefa().revalidate();
        limparCampos();
    }

    public ArrayList<Tarefa> carregarListaTarefas() {
        ArrayList<Tarefa> listaTarefas = new ArrayList();
        try {
            Connection conexao = new conexao().conectarBanco();
            TarefaDao tarefaDao = new TarefaDao(conexao);
            listaTarefas = tarefaDao.carregarTarefas(usuarioAtivo);

        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTarefas;
    }

    public void exibirTarefas() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableTarefas().getModel();
        ArrayList<Tarefa> tarefas = carregarListaTarefas();
        tableModel.setRowCount(0);

        if (tarefas.size() > 0) {
            Object dados[] = new Object[5];
            for (int i = 0; i < tarefas.size(); i++) {
                dados[0] = tarefas.get(i).getIdTarefa();
                dados[1] = tarefas.get(i).getData();
                dados[2] = tarefas.get(i).getNomeDisciplina();
                dados[3] = tarefas.get(i).getDescricao();
                dados[4] = tarefas.get(i).isStatus();
                tableModel.addRow(dados);
            }
        }
    }

    public ArrayList<Disciplina> carregarListaTodasDisciplinas() {
        ArrayList<Disciplina> listaDisciplinas = new ArrayList();

        try {
            Connection conexao = new conexao().conectarBanco();
            DisciplinaDao disciplinaDao = new DisciplinaDao(conexao);
            listaDisciplinas = disciplinaDao.carregarTodasDisciplinas(usuarioAtivo);
            System.out.println(listaDisciplinas.size());
        } catch (SQLException e) {
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

        return listaDisciplinas;
    }

    public void exibirTodasDisciplinas() {
        ArrayList<Disciplina> listaDisciplinas = carregarListaTodasDisciplinas();

        view.getjComboBoxDisciplina().removeAllItems();
        if (listaDisciplinas.size() > 0) {
            for (Disciplina disciplina : listaDisciplinas) {
                view.getjComboBoxDisciplina().addItem(disciplina.getNome());
            }
        }
    }

    public void salvarTarefa() throws ParseException {
        Disciplina disciplina = carregarListaTodasDisciplinas().get(view.getjComboBoxDisciplina().getSelectedIndex());
        String nome = view.getjTextTarefaNome().getText();
        Date data = converterData(view.getjFormattedTextData().getText());
        Time hora = converterHora(view.getjFormattedTextHora().getText());
        String descricao = view.getjTextAreaDescricao().getText();
        Boolean status = view.getjRadioButtonConcluido().isSelected();
        int idDisciplina = disciplina.getIdDisciplina();
        String nomeDisciplina = disciplina.getNome();

        Tarefa tarefa = new Tarefa(nome, data, hora, descricao,
                status, idDisciplina, nomeDisciplina);

        try {
            if (nome.equals("")) {
                JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
            } else {
                Connection conexao = new conexao().conectarBanco();
                TarefaDao tarefaDao = new TarefaDao(conexao);
                tarefaDao.adicionarTarefa(tarefa);
                JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso.");
                limparCampos();
                exibirTarefas();
            }
        } catch (SQLException ex) {
            //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }
    }

    //Seta os campos da tela de edição de tarefa com os valores da linha selecionada na tabela
    public void carregarCamposTarefa() throws ParseException {
        /*
         */
        Tarefa tarefa = retornarTarefa();
        view.getjTextTarefaNome().setText(tarefa.getNome());
        view.getjFormattedTextData().setText(formatarData(tarefa.getData()));
        view.getjFormattedTextHora().setText(formatarHora(tarefa.getHora()));
        view.getjTextAreaDescricao().setText(tarefa.getDescricao());
        view.getjRadioButtonConcluido().setSelected(tarefa.isStatus());
    }

    public void editarTarefa() throws ParseException {
        //Disciplina disciplina = carregarListaTodasDisciplinas().get(view.getjComboBoxDisciplina().getSelectedIndex());
        String nome = view.getjTextTarefaNome().getText();
        Date data = converterData(view.getjFormattedTextData().getText());
        Time hora = converterHora(view.getjFormattedTextHora().getText());
        String descricao = view.getjTextAreaDescricao().getText();
        Boolean status = view.getjRadioButtonConcluido().isSelected();
        int idTarefa = retornarTarefa().getIdTarefa();
        //int idDisciplina = disciplina.getIdDisciplina();
        //String nomeDisciplina = disciplina.getNome();
        Tarefa tarefa = new Tarefa(idTarefa, nome, data, hora, descricao, status);
        try {
            Connection conexao = new conexao().conectarBanco();
            TarefaDao tarefaDao = new TarefaDao(conexao);
            tarefaDao.atualizarTarefa(tarefa);
            JOptionPane.showMessageDialog(null, "Tarefa atualizada.");
            limparCampos();
            exibirTarefas();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Conexão falhou.");
            while (ex != null) {
                String errorMessage = ex.getMessage();
                System.err.println("sql error message:" + errorMessage);
                String sqlState = ex.getSQLState();
                System.err.println("sql state:" + sqlState);
                int errorCode = ex.getErrorCode();
                System.err.println("error code:" + errorCode);
                ex = ex.getNextException();
            }
        }
    }

    public void removerTarefa() throws ParseException {

        int linha = view.getjTableTarefas().getSelectedRow();
        int confirmar = JOptionPane.showConfirmDialog(view, "A remoção da tarefa "
                + "removerá também as subtarefas associadas. Deseja proceder?", "Remover Tarefa", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                if (linha >= 0) {
                    int idTarefa = carregarListaTarefas().get(linha).getIdTarefa();
                    Connection conexao = new conexao().conectarBanco();
                    TarefaDao tarefaDao = new TarefaDao(conexao);
                    tarefaDao.deletarTarefa(idTarefa);
                    exibirTarefas();
                }

            } catch (SQLException ex) {
                Logger.getLogger(InternoJfTelaTarefa.class.getName()).log(Level.SEVERE, null, ex);
            }

            exibirTarefas();
        }
    }

    //converte uma string para data em formato SQL
    public Date converterData(String sData) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = format.parse(sData);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
    }

    public Time converterHora(String sHora) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        java.util.Date hora = format.parse(sHora);
        java.sql.Time sqlHora = new java.sql.Time(hora.getTime());

        return sqlHora;
    }

    //Formata a data recebida SQL para uma string dd/MM/yyyy
    public String formatarData(Date data) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }

    public String formatarHora(Time hora) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:HH");
        return simpleDateFormat.format(hora);
    }

    public void limparCampos() {
        view.getjTextTarefaNome().setText("");
        view.getjFormattedTextData().setText("");
        view.getjFormattedTextHora().setText("");
        view.getjTextAreaDescricao().setText("");
    }

    public Tarefa retornarTarefa() {
        return carregarListaTarefas().get(view.getjTableTarefas().getSelectedRow());
    }
}
