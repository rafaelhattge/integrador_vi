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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import modelo.Subtarefa;
import modelo.Tarefa;
import modelo.Usuario;
import tela.InternoJfTelaRelatorio;

/**
 *
 * @author Rafael
 */
public class ControleTelaRelatorio {

    private final InternoJfTelaRelatorio view;
    private static Usuario usuarioAtivo;
    private ArrayList<Tarefa> tarefas;

    
    public ControleTelaRelatorio(InternoJfTelaRelatorio view) {
        this.view = view;
    }
    
    
    public ControleTelaRelatorio(InternoJfTelaRelatorio view, Usuario usuarioAtivo) {
        this.view = view;
        this.usuarioAtivo = usuarioAtivo;
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
            model.addElement(tarefa.getHora() + " - " + tarefa.getNome());
        }
        view.getjListTarefa().setModel(model);
        conexao.close();
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
        int idTarefa = tarefas.get(view.getjListTarefa().getSelectedIndex()).getIdTarefa();
        int concluidas = 0;
        subtarefas = carregarSubtarefas(idTarefa);
        tableModel.setRowCount(0);
   
        if(subtarefas.size() > 0) {
            Object dados[] = new Object[5];
            for (int i = 0; i < subtarefas.size(); i++) {
                dados[0] = subtarefas.get(i).getIdSubtarefa();
                dados[1] = subtarefas.get(i).isStatus();
                dados[2] = subtarefas.get(i).getNome();
                dados[3] = subtarefas.get(i).getIdTarefa();
                dados[4] = subtarefas.get(i).getNomeTarefa();
                tableModel.addRow(dados);
                if(subtarefas.get(i).isStatus()){
                    concluidas++;
                }
            }
            if(concluidas > 0){
                view.getjProgressBar().setValue(concluidas * 100 / subtarefas.size());
            }
        }  
        
    }
    
    public void exibirInformacoes() throws SQLException{
        listarDatas();
        if(view.getjListData().getModel().getSize() > 0){
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
}
