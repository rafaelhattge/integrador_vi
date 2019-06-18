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
import javax.swing.DefaultListModel;
import modelo.Tarefa;
import tela.InternoJfTelaRelatorio;

/**
 *
 * @author Rafael
 */
public class ControleTelaRelatorio {

    private final InternoJfTelaRelatorio view;

    public ControleTelaRelatorio(InternoJfTelaRelatorio view) {
        this.view = view;
        try {
            listarDatas();
        } catch (SQLException ex) {
            Logger.getLogger(ControleTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarDatas() throws SQLException {
        Connection conexao = new conexao().conectarBanco();
        TarefaDao tarefaDao = new TarefaDao(conexao);
        UsuarioDao usuarioAtivo = new UsuarioDao(conexao);
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
    }

    /*Este método será executado no código personalizado da jListData da Tela de Relatórios, 
    através de de um List Selection Listener
     */
    public void selecionarTarefasPorData() throws SQLException {
        ArrayList<Tarefa> tarefas = new ArrayList();
        Connection conexao = new conexao().conectarBanco();
        TarefaDao tarefaDao = new TarefaDao(conexao);
        UsuarioDao usuarioAtivo = new UsuarioDao(conexao);
        ArrayList<Date> datas = tarefaDao.carregarDatasTarefas(usuarioAtivo);
        int index = view.getjListData().getSelectedIndex();
        tarefas = tarefaDao.carregarTarefasPorData(usuarioAtivo, datas.get(index));
        DefaultListModel model = new DefaultListModel();
        for (Tarefa tarefa : tarefas) {
            model.addElement(tarefa.getHora() + " - " + tarefa.getNome());
        }
        view.getjListTarefa().setModel(model);
    }

    //Formata a data recebida SQL para uma string dd/MM/yyyy
    public String formatarData(Date data) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }
}
