/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.TelaMensagemDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Mensagem;
import tela.TelaMensagem;

/**
 *
 * @author Diana
 */
public class ControlerTelaMensagem {

    private TelaMensagem view;

    public ControlerTelaMensagem(TelaMensagem view) {
        this.view = view;
        view.setLocationRelativeTo(null);
        //  view.getContentPane().setBackground(getBackground());
        view.setOpacity(0.8f);
        view.getjLabelBarra().setOpaque(true);
    }
}
