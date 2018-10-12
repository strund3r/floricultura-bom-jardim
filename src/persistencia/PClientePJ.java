/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ClientePJ;
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
public class PClientePJ {

    Connection cnn = util.Conexao.getConexao();

    public void incluir(ClientePJ parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " clientePJ (nome, cnpj, telefone, endereco, email, id_cliente) "
                + " VALUES (?,?,?,?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getCnpj());
        prd.setString(3, parametro.getTelefone());
        prd.setString(4, parametro.getEndereco());
        prd.setString(5, parametro.getEmail());
        prd.setObject(6, parametro.getTipoCliente().getIdentificador());

        prd.execute();
        cnn.close();
    }

    public void alterar(ClientePJ parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE clientePJ SET"
                    + " nome = ?,"
                    + " cnpj = ?, "
                    + " telefone = ?, "
                    + " endereco = ?, "
                    + " email = ?"
                    + " identificador = ?"
                    + " WHERE identificador = ?";

            //Cria a conexao a partir dos métodos da fábrica de conexões
            Connection cnn = util.Conexao.getConexao();

            //cria o procedimento para a execução "contra" o BD
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Trocando os valores da ? por valores recebidos no método
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getCnpj());
            prd.setString(3, parametro.getTelefone());
            prd.setString(4, parametro.getEndereco());
            prd.setString(5, parametro.getEmail());
            prd.setObject(6, parametro.getTipoCliente().getIdentificador());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PClientePF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM clientePJ "
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

    public ClientePJ consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, nome, endereco, telefone, id_tipoClientePJ"
                + " FROM clientePJ WHERE identificador = ?;";

//        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        ClientePJ retorno = new ClientePJ();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setTipoCliente(new PTipoCliente().consultar(rs.getInt("id_cliente")));
        }
        return retorno;
    }

    public List<ClientePJ> listar() throws SQLException {

        String sql = "SELECT * FROM clientePJ";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<ClientePJ> retorno = new ArrayList<>();

        while (rs.next()) {
            ClientePJ clientePJ = new ClientePJ();

            clientePJ.setIdentificador(rs.getInt("identificador"));
            clientePJ.setNome(rs.getString("nome"));
            clientePJ.setEndereco(rs.getString("endereco"));
            clientePJ.setTelefone(rs.getString("telefone"));
            TipoCliente tpcliente = new TipoCliente();
            tpcliente.setIdentificador(rs.getInt("id_tipoClientePJ"));
            clientePJ.setTipoCliente(tpcliente);

            retorno.add(clientePJ);
        }
        return retorno;
    }
}
