/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.UsuarioDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import tela.InternoJfTelaConfGeral;

/**
 *
 * @author Diana
 */
public class ControlerTelaConfigGeral {

    private final InternoJfTelaConfGeral view;
private Connection conecta;
 private UsuarioDao userDao;
    public ControlerTelaConfigGeral(InternoJfTelaConfGeral view)  {
        this.view = view;
       // mostrarTableUsuario();
    }
    public ArrayList<Usuario> carregarListaUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        
          Connection conexao;
        try {
            conexao = new conexao().conectarBanco();
            userDao = new UsuarioDao(conexao);
            listaUsuarios = userDao.selecionarTodoUser();
            System.out.println(listaUsuarios.get(1).getNome());
           // conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlerTelaConfigGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return listaUsuarios;
    }
     public void mostrarTableUsuario() throws SQLException {
        DefaultTableModel modelUsuario = (DefaultTableModel) view.getjTableUsuario().getModel();
           ArrayList<Usuario> listaUsuario =  carregarListaUsuarios();
        if (modelUsuario.getRowCount() > 0) {
            modelUsuario.setRowCount(0);
        }
        Object rowData[] = new Object[7];
        
       
        for (int i = 0; i < listaUsuario.size(); i++) {
            rowData[0] = listaUsuario.get(i).getId();
            rowData[1] = listaUsuario.get(i).getNome();
            rowData[2] = listaUsuario.get(i).getEmail();
            rowData[3] = listaUsuario.get(i).getUsuario();
            rowData[4] = listaUsuario.get(i).getSenha();
            rowData[5] = listaUsuario.get(i).getTipo();
            rowData[6] = listaUsuario.get(i).getMensagem();
            modelUsuario.addRow(rowData);
        }
//jTabbedPane1.setSelectedIndex(dic.getIndex());

    }
}
