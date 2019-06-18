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
            Usuario userAutenticar = new Usuario(usuario, senha);
            //conexao

            Connection conexao = new conexao().conectarBanco();
            UsuarioDao userDao = new UsuarioDao(conexao);

            //verificar se existe no banco
            boolean autenticar = userDao.autenticarUsuario(userAutenticar);
            if (autenticar) {
                Usuario usuarioAtivo = userDao.usuarioAtivo(userAutenticar);

                TelaPrincipal tela = new TelaPrincipal();
                tela.getjLabelUsarioLogado().setText(userAutenticar.getNome());
                userDao.setUserAtivo(usuarioAtivo);
                //System.out.println(usuarioAtivo.getNome());

                tela.getContentPane().setBackground(new Color(69, 69, 71));
                //   tela.setResizable(false);
                //   tela.setLocationRelativeTo(null);
                // tela.pack();
                tela.setVisible(true);

                /*
                Aparentemente o carregamento das informações do banco de dados
                que se conectam com os componentes das telas internas só funciona se
                for realizado neste ponto.
                 */
                //Criar um construtor para a telaPrincipal que receba o UsuarioAtivo
                ControleTelaDisciplina controleTelaDisciplina = new ControleTelaDisciplina(tela.getTelaDisicplina(), tela.getTelaDisicplina().getDialog());
                controleTelaDisciplina.exibirCursos();
                controleTelaDisciplina.exibirDisciplinas();
                ControleTarefa controleTarefa = new ControleTarefa(tela.getTelaTarefas());
                controleTarefa.exibirTarefas();

                view.dispose();
                //Exibe mensagem inicial
                TelaMensagem mensagem = new TelaMensagem(tela, true);
                mensagem.setVisible(true);

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
