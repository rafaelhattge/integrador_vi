/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Dao.TelaMensagemDao;
import Dao.UsuarioDao;
import Dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Mensagem;
import modelo.Usuario;
import tela.InternoJfTelaConfGeral;

/**
 *
 * @author Diana
 */
public class ControlerTelaConfigGeral {

    private final InternoJfTelaConfGeral view;
    private int idUsuario = 0;
    private int idMensagem = 0;

    public ControlerTelaConfigGeral(InternoJfTelaConfGeral view) {
        this.view = view;

    }

    ///buscar lista de usuarios do banco
    public void carregarListaUsuarios() {

        try {
            Connection conexao = new conexao().conectarBanco();
            UsuarioDao userDao = new UsuarioDao(conexao);
            ArrayList<Usuario> listaUsuarios = userDao.selecionarTodoUser();
            this.idUsuario = listaUsuarios.get(listaUsuarios.size() - 1).getId();

            mostrarTableUsuario(listaUsuarios);
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlerTelaConfigGeral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////Montar a tabela
    private void mostrarTableUsuario(ArrayList<Usuario> lista) throws SQLException {
        DefaultTableModel modelUsuario = (DefaultTableModel) view.getjTableUsuario().getModel();
        modelUsuario.setRowCount(0);
        for (Usuario usuario : lista) {
            modelUsuario.addRow(new Object[]{
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getUsuario(),
                usuario.getSenha(),
                usuario.getTipo(),
                usuario.getMensagem()
            });
        }

    }
///passar dados para os campos

    public void controleEventoTabelaUser() {
        if (view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 6).equals("sim")) {
            view.getjRadioButtonReceMensagem().setSelected(true);
        } else if (view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 6).equals("não")) {
            view.getjRadioButtonNReceMensage().setSelected(true);
        }
        if (view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 5).equals("Administrador")) {
            view.getjComboBoxTipoUser().setSelectedIndex(0);
        } else if (view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 5).equals("Estudante")) {
            view.getjComboBoxTipoUser().setSelectedIndex(1);
        }

        view.getjTextCodigouser().setText(Integer.toString((int) view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 0)));

        view.getjTextNome().setText(((String) view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 1)));
        view.getjTextEmail().setText(((String) view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 2)));
        view.getjTextUser().setText(((String) view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 3)));
        view.getjPasswordSenha().setText(((String) view.getjTableUsuario().getValueAt(view.getjTableUsuario().getSelectedRow(), 4)));

    }

    //buscar por tipo ou nome de usuarios
    public void buscaInformaçoesUsuarios() {

        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) view.getjTableUsuario().getModel();
        sorter = new TableRowSorter<TableModel>(model);
        view.getjTableUsuario().setRowSorter(sorter);

        String text = view.getjTextFieldPesquisarUsuario().getText();

        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            if (view.getjRadioButtonNome().isSelected()) {

                sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + text.toUpperCase(), 1));

            } else if (view.getjRadioButtonBuscaCodigo().isSelected()) {
                sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + text.toUpperCase(), 0));
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 5));
            }
//      
        }
    }
/////////////ATIVAR E DESATIVAR CAMPOS

    private void controleCampos(boolean b) {
        view.getjTextNome().setEditable(b);
        view.getjTextEmail().setEditable(b);
        view.getjTextUser().setEditable(b);
        view.getjPasswordSenha().setEditable(b);
        view.getjRadioButtonReceMensagem().setEnabled(b);
        view.getjRadioButtonNReceMensage().setEnabled(b);
        view.getjComboBoxTipoUser().setEnabled(b);
        view.getjTextNome().requestFocus(b);
    }
    //////LIMPAR CAMPOS

    private void limparCampos() {
        view.getjComboBoxTipoUser().setSelectedIndex(1);

        view.getjRadioButtonReceMensagem().setSelected(true);
        view.getjTextNome().setText("");
        view.getjTextEmail().setText("");
        view.getjTextUser().setText("");
        view.getjPasswordSenha().setText("");
        view.getjTextCodigouser().setText("");
        view.getjTextNome().requestFocus(true);
    }

    ///////////////////NOVO USUARIO//////////////////////////
    public void novoUsuario() {
        if (view.getjButtonNovoUsuario().getText().equals("Novo")) {
            carregarListaUsuarios();
            limparCampos();
            view.getjTextCodigouser().setText(Integer.toString(idUsuario + 1));
            controleCampos(true);
            view.getjButtonNovoUsuario().setText("Salvar");
            view.getjButtonEditarUsuario().setText("Cancela");
        } else if (view.getjButtonNovoUsuario().getText().equals("Salvar")) {
            ////VERIFICAR SE TODOS CAMPOS ESTÃO PREENCHIDOS
            if (view.getjTextNome().getText().equals("")
                    || view.getjTextEmail().getText().equals("")
                    || view.getjTextUser().getText().equals("")
                    || view.getjPasswordSenha().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos campos são obrigátorios");
            } else {
                int id = Integer.parseInt(view.getjTextCodigouser().getText());
                String nome = view.getjTextNome().getText();
                String email = view.getjTextEmail().getText();
                String usuar = view.getjTextUser().getText();
                String senh = view.getjPasswordSenha().getText();
                String tip = (String) view.getjComboBoxTipoUser().getSelectedItem();
                String mensa = mensageSelecionada();
                Usuario usuarioU = new Usuario(id, nome, email, usuar, senh, tip, mensa);

                try {
                    Connection conecta = new conexao().conectarBanco();

                    UsuarioDao userDao = new UsuarioDao(conecta);

                    int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja Salvar o usuário:\n" + usuarioU.getNome(), "Confirmar Salvar Usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resposta == JOptionPane.OK_OPTION) {
                        userDao.InserirUsuario(usuarioU);
                        JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso");
                        view.getjTableUsuario().clearSelection();
                        carregarListaUsuarios();
                        controleCampos(false);
                        view.getjButtonNovoUsuario().setText("Novo");
                        view.getjButtonEditarUsuario().setText("Editar");
                    }
                    view.getjTableUsuario().clearSelection();
                    carregarListaUsuarios();
                    limparCampos();
                    controleCampos(false);
                    view.getjButtonNovoUsuario().setText("Novo");
                    view.getjButtonEditarUsuario().setText("Editar");

                } catch (SQLException ex) {
                    //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível a Salvar usuario\n" + nome);
                }
            }
        } else {
            view.getjTableUsuario().clearSelection();
            carregarListaUsuarios();
            limparCampos();
            controleCampos(false);
            view.getjButtonEditarUsuario().setText("Editar");
            view.getjButtonNovoUsuario().setText("Novo");
        }
    }

    ////////////////////////////////DELETAR USUARIO
    public void DeleTarUsuario() {
        if (view.getjTextCodigouser().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escolha um usuário para Excluir");
        } else {
            int id = Integer.parseInt(view.getjTextCodigouser().getText());
            String nome = view.getjTextNome().getText();
            String email = view.getjTextEmail().getText();
            String usuar = view.getjTextUser().getText();
            String senh = view.getjPasswordSenha().getText();
            String tip = (String) view.getjComboBoxTipoUser().getSelectedItem();
            String mensa = mensageSelecionada();
            Usuario usuarioU = new Usuario(id, nome, email, usuar, senh, tip, mensa);

            try {
                Connection conecta = new conexao().conectarBanco();
                //   System.out.println("Conectou");
                UsuarioDao userDao = new UsuarioDao(conecta);
                int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir a conta do usuário?\n"
                        + usuarioU.getNome(), "Confirmar Excluir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resposta == JOptionPane.OK_OPTION) {
                    userDao.deletarUsuario(usuarioU);
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
                    view.getjTableUsuario().clearSelection();
                    carregarListaUsuarios();
                    limparCampos();
                } else {
                    view.getjTableUsuario().clearSelection();
                    limparCampos();
                }

            } catch (SQLException ex) {
                //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não foi possível deletar o usuario\n" + nome);
            }
        }
    }
    //////EDITAR USUARIO

    public void AlterarUsuario() {
        if (view.getjButtonEditarUsuario().getText().equals("Editar")) {
            if (view.getjTextNome().getText().isEmpty()
                    || view.getjTextEmail().getText().isEmpty()
                    || view.getjTextUser().getText().isEmpty()
                    || view.getjPasswordSenha().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um usuário para Editar");
            } else {
                controleCampos(true);
                view.getjButtonEditarUsuario().setText("Salvar");
                view.getjButtonNovoUsuario().setText("Cancelar");
            }
        } else if (view.getjButtonEditarUsuario().getText().equals("Salvar")) {
            ////VERIFICAR SE TODOS CAMPOS ESTÃO PREENCHIDOS
            if (view.getjTextNome().getText().isEmpty()
                    || view.getjTextEmail().getText().isEmpty()
                    || view.getjTextUser().getText().isEmpty()
                    || view.getjPasswordSenha().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos campos são obrigátorios");

            } else {
                int id = Integer.parseInt(view.getjTextCodigouser().getText());
                String nome = view.getjTextNome().getText();
                String email = view.getjTextEmail().getText();
                String usuar = view.getjTextUser().getText();
                String senh = view.getjPasswordSenha().getText();
                String tip = (String) view.getjComboBoxTipoUser().getSelectedItem();
                String mensa = mensageSelecionada();
                Usuario usuarioU = new Usuario(id, nome, email, usuar, senh, tip, mensa);

                try {
                    Connection conecta = new conexao().conectarBanco();

                    UsuarioDao userDao = new UsuarioDao(conecta);

                    int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja Alterar o usuário:\n" + usuarioU.getId(), "Confirmar Salvar Usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resposta == JOptionPane.OK_OPTION) {
                        userDao.UpdateUsuario(usuarioU);
                        JOptionPane.showMessageDialog(null, "Usuário Alterado com sucesso");
                        view.getjTableUsuario().clearSelection();
                        carregarListaUsuarios();
                        limparCampos();
                        controleCampos(false);
                        view.getjButtonNovoUsuario().setText("Novo");
                        view.getjButtonEditarUsuario().setText("Editar");
                    } else {
                        view.getjTableUsuario().clearSelection();
                        carregarListaUsuarios();
                        limparCampos();
                        controleCampos(false);
                        view.getjButtonNovoUsuario().setText("Novo");
                        view.getjButtonEditarUsuario().setText("Editar");
                    }
                } catch (SQLException ex) {
                    //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível a Salvar usuario\n" + nome);
                }
            }
        } else {///SE O BOTÃO FOR CANCELAR
            view.getjTableUsuario().clearSelection();
            carregarListaUsuarios();
            limparCampos();
            controleCampos(false);
            view.getjButtonEditarUsuario().setText("Editar");
            view.getjButtonNovoUsuario().setText("Novo");
        }
    }

    public String mensageSelecionada() {
        String mensagem = "";
        if (view.getjRadioButtonReceMensagem().isSelected()) {
            mensagem = "sim";
        } else {
            mensagem = "não";
        }
        return mensagem;
    }

/////////////////////////APARTIR DAQUI DADOS MENSAGENS
    public void carregarListaMensagem() {

        try {
            Connection conexao = new conexao().conectarBanco();
            TelaMensagemDao mensaDao = new TelaMensagemDao(conexao);
            ArrayList<Mensagem> listaMensagem = mensaDao.selecionarTodasMensagem();
            this.idMensagem = listaMensagem.get(listaMensagem.size() - 1).getId();

            mostrarTableMensagem(listaMensagem);
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlerTelaConfigGeral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////Montar a tabela
    private void mostrarTableMensagem(ArrayList<Mensagem> lista) throws SQLException {
        DefaultTableModel modelMensagem = (DefaultTableModel) view.getjTableMensagem().getModel();
        modelMensagem.setRowCount(0);
        for (Mensagem mensa : lista) {
            modelMensagem.addRow(new Object[]{
                mensa.getId(),
                mensa.getMensagem()
            });
        }

    }

    public void controleEventoTabelaMensagem() {

        view.getjTextAreaFrase().setWrapStyleWord(true);
        view.getjTextAreaFrase().setLineWrap(true);
        view.getjTextCodiFrase().setText(Integer.toString((int) view.getjTableMensagem().getValueAt(view.getjTableMensagem().getSelectedRow(), 0)));

        view.getjTextAreaFrase().setText((String) view.getjTableMensagem().getValueAt(view.getjTableMensagem().getSelectedRow(), 1));

    }
       private void limparCamposMesagem() {
   

        view.getjTextCodiFrase().setText("");
        view.getjTextAreaFrase().setText("");
        
    }
       public void buscaInformaçoesMensagem() {

        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) view.getjTableMensagem().getModel();
        sorter = new TableRowSorter<TableModel>(model);
        view.getjTableMensagem().setRowSorter(sorter);

        String text = view.getjTextFieldPesquisarMensagem().getText();

        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            if (view.getjRadioButtoCodigoFrase().isSelected()) {

                sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + text.toUpperCase(), 0));

            } else  {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text.toUpperCase(), 1));
            }
//      
        }}
       
       ////////////ATIVAR E DESATIVAR CAMPOS Mensagem

    private void controleCamposMensagem(boolean b) {
        view.getjTextAreaFrase().setEditable(b);
       
        view.getjTextAreaFrase().requestFocus(b);
    }
       //////////NOVA FRASE
    public void novamensagem() {
        if (view.getjButtonNovoMensa().getText().equals("NOVO")) {
            carregarListaMensagem();
            limparCamposMesagem();
            view.getjTextCodiFrase().setText(Integer.toString(idMensagem + 1));
            controleCamposMensagem(true);
            view.getjButtonNovoMensa().setText("SALVAR");
            view.getjButtonEditarMensage().setText("CANCELA");
            
        } else if (view.getjButtonNovoMensa().getText().equals("SALVAR")) {
            ////VERIFICAR SE TODOS CAMPOS ESTÃO PREENCHIDOS
            if (view.getjTextAreaFrase().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos campos são obrigátorios");
            } else {
                int id = Integer.parseInt(view.getjTextCodiFrase().getText());
                String mensagem = view.getjTextAreaFrase().getText();
               
                
                Mensagem mensag = new Mensagem(id, mensagem);

                try {
                    Connection conecta = new conexao().conectarBanco();

                    TelaMensagemDao mensagemDao = new TelaMensagemDao(conecta);

                    int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja Salvar Frase?", "Confirmar Salvar Frase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resposta == JOptionPane.OK_OPTION) {
                        mensagemDao.insertmMensagem(mensag);
                        JOptionPane.showMessageDialog(null, "Frase Salva com sucesso");
                        view.getjTableMensagem().clearSelection();
                        carregarListaMensagem();
                        controleCamposMensagem(false);
                        view.getjButtonNovoMensa().setText("NOVO");
                        view.getjButtonEditarMensage().setText("EDITAR");
                    }
                    view.getjTableMensagem().clearSelection();
                    carregarListaMensagem();
                    limparCamposMesagem();
                    controleCamposMensagem(false);
                    view.getjButtonNovoMensa().setText("NOVO");
                        view.getjButtonEditarMensage().setText("EDITAR");

                } catch (SQLException ex) {
                    //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível  Salvar a frase " );
                }
            }
        } else {
            view.getjTableMensagem().clearSelection();
            carregarListaMensagem();
            limparCamposMesagem();
            controleCamposMensagem(false);
          view.getjButtonNovoMensa().setText("NOVO");
                        view.getjButtonEditarMensage().setText("EDITAR");
        }
    }
/////////////////////////DELETAR MENSAGEM
    public void DeleTarMensagem() {
        if (view.getjTextCodiFrase().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escolha uma frase para Excluir");
        } else {
            int id = Integer.parseInt(view.getjTextCodiFrase().getText());
            String mensagem = view.getjTextAreaFrase().getText();
         
            Mensagem men = new Mensagem(id, mensagem);

            try {
                Connection conecta = new conexao().conectarBanco();
                //   System.out.println("Conectou");
                TelaMensagemDao mensDao = new TelaMensagemDao(conecta);
                int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir a Frase?\n"
                        + men.getId(), "Confirmar Excluir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resposta == JOptionPane.OK_OPTION) {
                    mensDao.deletarMensagem(men);
                    JOptionPane.showMessageDialog(null, "Frase excluído com sucesso.");
                    view.getjTableMensagem().clearSelection();
                    carregarListaMensagem();
                    limparCamposMesagem();
                } else {
                    view.getjTableMensagem().clearSelection();
                    limparCamposMesagem();
                }

            } catch (SQLException ex) {
                //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não foi possível deletar a Frase\n" + id);
            }
        }
    }
    
    ////ALTERAR FRASE
    
    public void AlterarFrase() {
        if (view.getjButtonEditarMensage().getText().equals("EDITAR")) {
            if (view.getjTextCodiFrase().getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Selecione uma Frase para Editar");
            } else {
                controleCamposMensagem(true);
                view.getjButtonEditarMensage().setText("SALVAR");
                view.getjButtonNovoMensa().setText("CANCELAR");
            }
        } else if (view.getjButtonEditarMensage().getText().equals("SALVAR")) {
            ////VERIFICAR SE TODOS CAMPOS ESTÃO PREENCHIDOS
            if (view.getjTextAreaFrase().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos campos são obrigátorios");

            } else {
                int id = Integer.parseInt(view.getjTextCodiFrase().getText());
                String mensagem = view.getjTextAreaFrase().getText();
           
                 Mensagem men = new Mensagem(id, mensagem);

         
               
              

                try {
                     Connection conecta = new conexao().conectarBanco();
                //   System.out.println("Conectou");
                TelaMensagemDao mensDao = new TelaMensagemDao(conecta);
                                  

                    int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja Alterar o Frase:\n" + men.getId(), "Confirmar Salvar Usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resposta == JOptionPane.OK_OPTION) {
                        mensDao.UpdateMensagem(men);
                        JOptionPane.showMessageDialog(null, "Frase Alterada com sucesso");
                        view.getjTableMensagem().clearSelection();
                        carregarListaMensagem();
                        limparCamposMesagem();
                        controleCamposMensagem(false);
                        view.getjButtonNovoMensa().setText("NOVO");
                        view.getjButtonEditarMensage().setText("EDITAR");
                    } else {
                        view.getjTableMensagem().clearSelection();
                        carregarListaMensagem();
                        limparCamposMesagem();
                        controleCamposMensagem(false);
                        view.getjButtonNovoMensa().setText("NOVO");
                        view.getjButtonEditarMensage().setText("EDITAR");
                    }
                } catch (SQLException ex) {
                    //  Logger.getLogger(TelaRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível a Salvar FRASE\n" + id);
                }
            }
        } else {///SE O BOTÃO FOR CANCELAR
            view.getjTableMensagem().clearSelection();
            carregarListaMensagem();
            limparCamposMesagem();
            controleCamposMensagem(false);
            view.getjButtonEditarMensage().setText("EDITAR");
            view.getjButtonNovoMensa().setText("NOVO");
        }
    }
}