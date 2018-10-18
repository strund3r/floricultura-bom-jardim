/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.TipoProduto;
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
public class PTipoProduto {
    
     Connection cnn = util.Conexao.getConexao();

    public void incluir(TipoProduto parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " tipoproduto (nome) "
                + " VALUES (?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getNome());

        prd.execute();
        cnn.close();
    }

    public void alterar(TipoProduto parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE tipoproduto SET"
                    + " nome = ?,"
                    + " WHERE identificador = ?";

            //Cria a conexao a partir dos métodos da fábrica de conexões
            Connection cnn = util.Conexao.getConexao();

            //cria o procedimento para a execução "contra" o BD
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Trocando os valores da ? por valores recebidos no método
            prd.setString(1, parametro.getNome());
            prd.setInt(2, parametro.getIdentificador());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM tipoproduto "
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

    public TipoProduto consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, nome"
                + " FROM tipoproduto WHERE identificador = ?;";

//        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        TipoProduto retorno = new TipoProduto();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
        }

        return retorno;
    }

    public List<TipoProduto> listar() throws SQLException {

        String sql = "SELECT * FROM tipoproduto";

        Connection cnn = util.Conexao.getConexao();

        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        List<TipoProduto> retorno = new ArrayList<>();

        while (rs.next()) {
            TipoProduto tipo = new TipoProduto();

            tipo.setIdentificador(rs.getInt("identificador"));
            tipo.setNome(rs.getString("nome"));

            retorno.add(tipo);
        }
        return retorno;
    }

    public TipoProduto consultarPorString(String parametro) throws SQLException {

        String sql = "SELECT identificador, nome"
                + " FROM tipoproduto WHERE identificador = ?;";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, parametro);

        ResultSet rs = prd.executeQuery();

        TipoProduto retorno = new TipoProduto();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
        }

        return retorno;
    }
    
}
