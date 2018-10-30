/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leticiasilva
 */
public class Conexao {
    private static Connection conexao;

    private static Connection conectar() {

        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/flor", "postgres", "123456");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger("Driver JDBC não encontrado! Verifique as bibliotecas"
                    + " da aplicação.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger("Caminho, banco de dados, usuário ou senha incorretos. Verifique!");
        }

        return null;
    }

    public static Connection getConexao() {

        try {
            while (conexao == null || conexao.isClosed()) {
                conexao = Conexao.conectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexao;
    }
    
}
