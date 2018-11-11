/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Produto;
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
public class PProduto {

//    Connection cnn = util.Conexao.getConexao();
    public void incluir(Produto parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO produto (nome, descricao, custo, valorvenda, quantidade) "
                + " VALUES (?,?,?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
       Connection cnn = util.Conexao.getConnection();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getDescricao());
        prd.setDouble(3, parametro.getCusto());
        prd.setDouble(4, parametro.getValorVenda());
        prd.setInt(5, parametro.getQuantidade());

        prd.execute();
        cnn.close();
    }

    public void alterar(Produto parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE produto SET"
                    + " nome = ?,"
                    + " descricao = ?,"
                    + " custo = ?, "
                    + " valorvenda = ?,"
                    + " quantidade = ?"
                    + " WHERE identificador = ?";

            //Cria a conexao a partir dos métodos da fábrica de conexões
            Connection cnn = util.Conexao.getConnection();

            //cria o procedimento para a execução "contra" o BD
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Trocando os valores da ? por valores recebidos no método
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getDescricao());
            prd.setDouble(3, parametro.getCusto());
            prd.setDouble(4, parametro.getValorVenda());
            prd.setInt(5, parametro.getQuantidade());
            prd.setInt(6, parametro.getIdentificador());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PClientePF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM produto "
                + " WHERE id = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConnection();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public Produto consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, nome, descricao, custo, valorvenda, quantidade"
                + " FROM produto WHERE identificador = ?";

        Connection cnn = util.Conexao.getConnection();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Produto retorno = new Produto();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
            retorno.setDescricao(rs.getString("descricao"));
            retorno.setCusto(rs.getDouble("custo"));
            retorno.setValorVenda(rs.getDouble("valorvenda"));
            retorno.setQuantidade(rs.getInt("quantidade"));
        }
        return retorno;
    }

    public List<Produto> listar() throws SQLException {

        String sql = "SELECT * FROM produto";
        Connection cnn = util.Conexao.getConnection();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Produto> retorno = new ArrayList<>();

        while (rs.next()) {
            Produto produto = new Produto();

            produto.setIdentificador(rs.getInt("identificador"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setCusto(rs.getDouble("custo"));
            produto.setValorVenda(rs.getDouble("valorvenda"));
            produto.setQuantidade(rs.getInt("quantidade"));

            retorno.add(produto);
        }
        return retorno;
    }
}
