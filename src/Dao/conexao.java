/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diana
 */
public class conexao {
    public Connection conectarBanco() throws SQLException{
      Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoIntegrador","postgres","postgres");
       
        return conexao;
        
    }
}
