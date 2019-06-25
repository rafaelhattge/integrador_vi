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
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Mensagem;
import tela.TelaMensagem;

/**
 *
 * @author Diana
 */
public class ControlerTelaMensagem {

    private Random aleatorio;
    private TelaMensagem view;

    public ControlerTelaMensagem(TelaMensagem view) throws SQLException {
        this.view = view;
        view.setLocationRelativeTo(null);
        //  view.getContentPane().setBackground(getBackground());
        view.setOpacity(0.8f);
        view.getjLabelBarra().setOpaque(true);

    }

    public void carregarListaMensagem() {

        try {
            Connection conexao = new conexao().conectarBanco();
            TelaMensagemDao mensaDao = new TelaMensagemDao(conexao);
            ArrayList<Mensagem> listaMensagem = mensaDao.selecionarTodasMensagem();
            //   System.out.println(listaMensagem.get(new Random().nextInt(listaMensagem.size()-1)).getMensagem());

            view.getjTextFrase().setText(listaMensagem.get(new Random().nextInt(listaMensagem.size() - 1)).getMensagem());

            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlerTelaConfigGeral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
