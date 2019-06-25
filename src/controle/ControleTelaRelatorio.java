/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.SubtarefaDao;
import Dao.TarefaDao;
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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Subtarefa;
import modelo.Tarefa;
import modelo.Usuario;
import tela.InternoJfTelaRelatorio;
import tela.dialog.PanelAdicionarSubtarefa;

/**
 *
 * @author Rafael
 */
public class ControleTelaRelatorio {

    private final InternoJfTelaRelatorio view;
    private final PanelAdicionarSubtarefa panelSubtarefa;
    private static Usuario usuarioAtivo;
    private static ArrayList<Tarefa> tarefas;

    public ControleTelaRelatorio(InternoJfTelaRelatorio view, PanelAdicionarSubtarefa panelSubtarefa) {
        this.view = view;
        this.panelSubtarefa = panelSubtarefa;
    }

    public ControleTelaRelatorio(InternoJfTelaRelatorio view, Usuario usuarioAtivo, PanelAdicionarSubtarefa panelSubtarefa) {
        this.view = view;
        this.usuarioAtivo = usuarioAtivo;
        this.panelSubtarefa = panelSubtarefa;
        try {
            exibirInformacoes();
        } catch (SQLException ex) {
            Logger.getLogger(ControleTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarDatas() throws SQLException {
        Connection conexao = new conexao().conectarBanco();
        TarefaDao tarefaDao = new TarefaDao(conexao);
        ArrayList<Date> datas = tarefaDao.carregarDatasTarefas(usuarioAtivo);
        DefaultListModel model = new DefaultListModel();
        for (Date data : datas) {
            try {
                model.addElement(formatarData(data));
            } catch (ParseException ex) {
                Logger.getLogger(ControleTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        view.getjListData().setModel(model);

        conexao.close();
    }

    /*Este método será executado no código personalizado da jListData da Tela de Relatórios, 
    através de de um List Selection Listener
     */
    public void selecionarTarefasPorData() throws SQLException {
        tarefas = new ArrayList();
        Connection conexao = new conexao().conectarBanco();
        TarefaDao tarefaDao = new TarefaDao(conexao);
        ArrayList<Date> datas = tarefaDao.carregarDatasTarefas(usuarioAtivo);
        int index = view.getjListData().getSelectedIndex();
        tarefas = tarefaDao.carregarTarefasPorData(usuarioAtivo, datas.get(index));
        DefaultListModel model = new DefaultListModel();
        for (Tarefa tarefa : tarefas) {
            try {
                model.addElement(formatarHora(tarefa.getHora()) + " - " + tarefa.getNome());
            } catch (ParseException ex) {
                Logger.getLogger(ControleTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        view.getjListTarefa().setModel(model);
        conexao.close();
    }

    public void salvarSubtarefa() throws SQLException {

        int idTarefa = tarefas.get(view.getjListTarefa().getSelectedIndex()).getIdTarefa();
        String nome = panelSubtarefa.getjTextField1().getText();
        Subtarefa subtarefa = new Subtarefa(nome, false, idTarefa);

        try {
            if (nome.equals("")) {
                JOptionPane.showMessageDialog(null, "O nome não pode estar em branco.");
            } else {
                Connection conexao = new conexao().conectarBanco();
                SubtarefaDao subtarefaDao = new SubtarefaDao(conexao);
                subtarefaDao.adicionarSubtarefa(subtarefa);
                exibirSubtarefas();
                SwingUtilities.getWindowAncestor(panelSubtarefa).dispose();
            }
        } catch (SQLException ex) {
            //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão.");
        }
    }

    public void editarStatusSubtarefa(int idSubtarefa, boolean status) throws ParseException {
        Subtarefa subtarefa = new Subtarefa(idSubtarefa, status);
        try {
            Connection conexao = new conexao().conectarBanco();
            SubtarefaDao subtarefaDao = new SubtarefaDao(conexao);
            subtarefaDao.atualizarStatusSubtarefa(subtarefa);
            exibirSubtarefas();
        } catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerSubtarefa() {
        int linha = view.getjTableExercicios().getSelectedRow();
        if (linha >= 0) {
            int idSubtarefa = (int) view.getjTableExercicios().getValueAt(linha, 0);
            Connection conexao;
            try {
                conexao = new conexao().conectarBanco();
                SubtarefaDao subtarefaDao = new SubtarefaDao(conexao);
                subtarefaDao.deletarSubtarefa(idSubtarefa);
                exibirSubtarefas();
            } catch (SQLException ex) {
                Logger.getLogger(ControleTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Subtarefa> carregarSubtarefas(int idTarefa) {
        ArrayList<Subtarefa> subtarefas = new ArrayList();
        Connection conexao;
        try {
            conexao = new conexao().conectarBanco();
            SubtarefaDao subtarefaDao = new SubtarefaDao(conexao);
            subtarefas = subtarefaDao.carregarSubtarefas(idTarefa);
        } catch (SQLException ex) {
            Logger.getLogger(ControleTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subtarefas;
    }

    //1 - idSubtarefa 2 - status 3- nomeSubtarefa 4 - idTarefa 5 - nomeTarefa
    public void exibirSubtarefas() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableExercicios().getModel();
        ArrayList<Subtarefa> subtarefas;
        view.getjProgressBar().setValue(100);
        int idTarefa = tarefas.get(view.getjListTarefa().getSelectedIndex()).getIdTarefa();
        int concluidas = 0;
        subtarefas = carregarSubtarefas(idTarefa);
        view.getjLabelDisciplinaNome().setText(tarefas.get(view.getjListTarefa().getSelectedIndex()).getNomeDisciplina());
        view.getjTextAreaDescricao().setText(tarefas.get(view.getjListTarefa().getSelectedIndex()).getDescricao());
        tableModel.setRowCount(0);

        if (subtarefas.size() > 0) {
            Object dados[] = new Object[5];
            for (int i = 0; i < subtarefas.size(); i++) {
                dados[0] = subtarefas.get(i).getIdSubtarefa();
                dados[1] = subtarefas.get(i).isStatus();
                dados[2] = riscar(subtarefas.get(i).getNome(), subtarefas.get(i).isStatus());
                dados[3] = subtarefas.get(i).getIdTarefa();
                dados[4] = subtarefas.get(i).getNomeTarefa();
                tableModel.addRow(dados);
                if (subtarefas.get(i).isStatus()) {
                    concluidas++;
                }
            }
            if (subtarefas.size() > 0) {
                view.getjProgressBar().setValue(concluidas * 100 / subtarefas.size());
            }
        } else {
            tableModel.setRowCount(0);
        }
    }

    public void exibirInformacoes() throws SQLException {
        view.getjListData().setModel(new DefaultListModel());
        view.getjListTarefa().setModel(new DefaultListModel());
        view.getjLabelDisciplinaNome().setText("");
        view.getjTextAreaDescricao().setText("");
        listarDatas();
        if(view.getjListData().getModel().getSize() > 0){
            System.out.println(view.getjListData().getModel().getSize());
            view.getjListData().setSelectedIndex(0);
            selecionarTarefasPorData();
            if(view.getjListTarefa().getModel().getSize() > 0){
                view.getjListTarefa().setSelectedIndex(0);
                exibirSubtarefas();
            }
        }
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

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public String riscar(String nome, boolean status) {
        if (status) {
            return "<html><strike>" + nome + "</html></strike>";
        }
        return nome;
    }
}
