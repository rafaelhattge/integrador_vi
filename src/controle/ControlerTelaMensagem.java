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

    public void salvaMensagem() throws SQLException {

        String mensagem = view.getjTextFrase().getText();
        Mensagem mens = new Mensagem(mensagem);

        try {
            Connection conexao = new conexao().conectarBanco();
            TelaMensagemDao mensagemDao = new TelaMensagemDao(conexao);
            mensagemDao.insertmMensagem(mens);
            JOptionPane.showMessageDialog(null, "Mensagem cadastrada com sucesso");

            view.dispose();
        } catch (SQLException ex) {
            //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível a conexão!");
        }
    }

}
