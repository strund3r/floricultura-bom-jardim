/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.TipoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisf
 */
public class PTipoCliente {

    Connection cnn = util.Conexao.getConexao();

    public void incluir(TipoCliente parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " tipocliente (descricao) "
                + " VALUES (?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getDescricao());

        prd.execute();
        cnn.close();
    }

    public void alterar(TipoCliente parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE tipocliente SET"
                    + " descricao = ?,"
                    + " WHERE identificador = ?";

            //Cria a conexao a partir dos métodos da fábrica de conexões
            Connection cnn = util.Conexao.getConexao();

            //cria o procedimento para a execução "contra" o BD
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Trocando os valores da ? por valores recebidos no método
            prd.setString(1, parametro.getDescricao());
            prd.setInt(2, parametro.getIdentificador());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM tipocliente "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public TipoCliente consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, descricao"
                + " FROM tipocliente WHERE identificador = ?;";

//        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        TipoCliente retorno = new TipoCliente();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setDescricao(rs.getString("descricao"));
        }

        return retorno;
    }

    public List<TipoCliente> listar() throws SQLException {

        String sql = "SELECT * FROM tipocliente";

        Connection cnn = util.Conexao.getConexao();

        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        List<TipoCliente> retorno = new ArrayList<>();

        while (rs.next()) {
            TipoCliente tipo = new TipoCliente();

            tipo.setIdentificador(rs.getInt("identificador"));
            tipo.setDescricao(rs.getString("descricao"));

            retorno.add(tipo);
        }
        return retorno;
    }

    public TipoCliente consultarPorString(String parametro) throws SQLException {

        String sql = "SELECT identificador, descricao"
                + " FROM tipocliente WHERE identificador = ?;";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, parametro);

        ResultSet rs = prd.executeQuery();

        TipoCliente retorno = new TipoCliente();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setDescricao(rs.getString("descricao"));
        }

        return retorno;
    }

}
