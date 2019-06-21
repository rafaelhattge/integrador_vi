package controle;

import Dao.UsuarioDao;
import Dao.conexao;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import modelo.Usuario;
import tela.TelaLogin;
import tela.TelaMensagem;
import tela.TelaPrincipal;
import tela.TelaRegistro;

/**
 *
 * @author Diana
 */
public class ControlerTelaLogin {

    private final TelaLogin view;

    public ControlerTelaLogin(TelaLogin view) {
        this.view = view;
    }

    public void autenticarUsuario() throws SQLException, ParseException {
        //buscar usuario da view
        String usuario = view.getjTextUser().getText();
        String senha = view.getjPasswordSenha().getText();
        if (usuario.isEmpty() || senha.isEmpty()) {
            view.getJlblMessagem().setText("Todos campos são obrigatórios!");
            view.getjTextUser().requestFocus();

        } else {
            Usuario userAutenticar = new Usuario(usuario, senha);//Novo Usuario Para verificacao
            //conexao

            Connection conexao = new conexao().conectarBanco();//Abrir conexao com o banco
            UsuarioDao userDao = new UsuarioDao(conexao);//Abrir usuario DAO

            //verificar se existe no banco
            boolean autenticar = userDao.autenticarUsuario(userAutenticar);//verificar se usuario existe e retornar um boolean
            if (autenticar) {
                Usuario usuarioAtivo = userDao.retornarUsuarioUnico(usuario, senha);//usuario para demais telas
             //   userDao.setUserAtivo(usuarioAtivo);
                TelaPrincipal tela = new TelaPrincipal(usuarioAtivo);
              // ControlerTelaPrincipal controleTelaPrincipal = new ControlerTelaPrincipal(tela, usuarioAtivo);?
              if(usuarioAtivo.getTipo().equals("Estudante")){
                  tela.getjButtonConfigAdmin().setEnabled(false);
              }else{
                 tela.getjButtonConfigAdmin().setEnabled(true); 
              }
                tela.getjLabelUsarioLogado().setText(usuarioAtivo.getNome());
                tela.getjLabelTipoUser().setText(usuarioAtivo.getTipo());
                //System.out.println(usuarioAtivo.getNome());

                tela.getContentPane().setBackground(new Color(69, 69, 71));
                //   tela.setResizable(false);
                //   tela.setLocationRelativeTo(null);
                // tela.pack();
                tela.setVisible(true);
conexao.close();
                /*
                Aparentemente o carregamento das informações do banco de dados
                que se conectam com os componentes das telas internas só funciona se
                for realizado neste ponto.
                 */
                //Criar um construtor para a telaPrincipal que receba o UsuarioAtivo
                

                view.dispose();
                //Exibe mensagem inicial
                if(usuarioAtivo.getMensagem().equals("sim")){
                TelaMensagem mensagem = new TelaMensagem(tela, true);
                mensagem.setVisible(true);
                }
            } else {
                view.getJlblMessagem().setText("Usuário ou senha inválidos!");
                view.getjTextUser().requestFocus();
                view.getjTextUser().setText("");
                view.getjPasswordSenha().setText("");
            }
        }
    }

    public void limparTelaLogin() {
        view.getJlblMessagem().setText("");
        view.getjTextUser().setText("");
        view.getjTextUser().setText("");
        view.getjPasswordSenha().setText("");
    }

    public void chamarTelaCadastro() {
        TelaRegistro registro = new TelaRegistro();
        registro.setVisible(true);

        view.dispose();
    }
}
