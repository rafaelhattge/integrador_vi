/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Mensagem;

/**
 *
 * @author Diana
 */
public class TelaMensagemDao {
    //so pode criar dao se passar conexao
    private final Connection conexao;

    public TelaMensagemDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void insertmMensagem(Mensagem mensagem) throws SQLException{
            String sql = "insert into mensagem (mensagem)values(?);";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, mensagem.getMensagem());
        statement.execute();
        conexao.close();
    }
    public String VerficarMostrarMensagem(){
       // Usuario usuario = 
        
        
  
        return null;
    }
}
