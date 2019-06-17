/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.TarefaDao;
import Dao.UsuarioDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.Tarefa;
import tela.InternoJfTelaTarefa;

/**
 *
 * @author Diana
 */
public class ControleTarefa {
     private final InternoJfTelaTarefa view;

    public ControleTarefa(InternoJfTelaTarefa view) {
        this.view = view;
    }

    public void TrocaTarefas(JPanel tela){
        view.getjLayeredPaneGereTarefa().removeAll();
        view.getjLayeredPaneGereTarefa().add(tela);
        view.getjLayeredPaneGereTarefa().repaint();
        view.getjLayeredPaneGereTarefa().revalidate();
    }
    
    public ArrayList<Tarefa> carregarListaTarefas() {
        ArrayList<Tarefa> listaTarefas = new ArrayList();
        try {
            Connection conexao = new conexao().conectarBanco();
            TarefaDao tarefaDao= new TarefaDao(conexao);
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            System.out.println(usuarioDao.getUserAtivo().getNome());
            listaTarefas = tarefaDao.carregarTarefas(usuarioDao);
            
        }catch (SQLException ex) {
            Logger.getLogger(InternoJfTelaTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTarefas;
    }
    
    public void exibirTarefas() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableTarefas().getModel();
        ArrayList<Tarefa> tarefas = carregarListaTarefas();
        tableModel.setRowCount(0);
        
        if(tarefas.size() > 0){
            Object dados[] = new Object[5];
            for(int i = 0; i < tarefas.size(); i++) {
                dados[0] = tarefas.get(i).getIdTarefa();
                dados[1] = tarefas.get(i).getData();
                dados[2] = tarefas.get(i).getNomeDisciplina();
                dados[3] = tarefas.get(i).getDescricao();
                dados[4]= tarefas.get(i).isStatus();
                tableModel.addRow(dados);
            }
        }
    }
    
    public void removerTarefa() throws ParseException {
        
        int linha = view.getjTableTarefas().getSelectedRow();
        int confirmar = JOptionPane.showConfirmDialog(view, "A remoção da tarefa "
                + "removerá também as subtarefas associadas. Deseja proceder?", "Remover Tarefa", JOptionPane.YES_NO_OPTION);
        if(confirmar == JOptionPane.YES_OPTION){
            try {
                if(linha >= 0){
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

    //Formata a data recebida SQL para uma string dd/MM/yyyy
    public String formatarData(Date data) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }
}