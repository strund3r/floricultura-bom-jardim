/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Pedido;
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
public class PPedido {

//    Connection cnn = util.Conexao.getConexao();
    public void incluir(Pedido parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " pedido (id_cliente, id_produto, valor) "
                + " VALUES (?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
//        Connection cnn = util.Conexao.getConexao();
        Connection cnn = util.Conexao.getInstance().getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro.getId_cliente());
        prd.setInt(2, parametro.getId_produto());
        prd.setDouble(3, parametro.getValor());

        prd.execute();
        cnn.close();
    }

    public void alterar(Pedido parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE pedido SET"
                    + " id_cliente = ?,"
                    + " id_produto = ?, "
                    + " valor = ? "
                    + " WHERE identificador = ?";

            //Cria a conexao a partir dos métodos da fábrica de conexões
//            Connection cnn = util.Conexao.getConexao();
            Connection cnn = util.Conexao.getInstance().getConexao();

            //cria o procedimento para a execução "contra" o BD
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Trocando os valores da ? por valores recebidos no método
            prd.setInt(1, parametro.getId_cliente());
            prd.setInt(2, parametro.getId_produto());
            prd.setInt(3, parametro.getID());
            prd.setDouble(4, parametro.getValor());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PClientePF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM pedido "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
//        Connection cnn = util.Conexao.getConexao();
        Connection cnn = util.Conexao.getInstance().getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public Pedido consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, id_cliente, id_produto, valor"
                + " FROM pedido WHERE identificador = ?";

        Connection cnn = util.Conexao.getInstance().getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Pedido retorno = new Pedido();

        if (rs.next()) {
            retorno.setID(rs.getInt("identificador"));
            retorno.setId_cliente(rs.getInt("id_cliente"));
            retorno.setId_produto(rs.getInt("id_produto"));
            retorno.setValor(rs.getDouble("valor"));
        }
        return retorno;
    }

    public List<Pedido> listar() throws SQLException {

        String sql = "SELECT * FROM pedido";
//        Connection cnn = util.Conexao.getConexao();
        Connection cnn = util.Conexao.getInstance().getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Pedido> retorno = new ArrayList<>();

        while (rs.next()) {
            Pedido pedido = new Pedido();

            pedido.setID(rs.getInt("identificador"));
            pedido.setId_cliente(rs.getInt("id_cliente"));
            pedido.setId_produto(rs.getInt("id_produto"));
            pedido.setValor(rs.getDouble("valor"));

            retorno.add(pedido);
        }
        return retorno;
    }
}
