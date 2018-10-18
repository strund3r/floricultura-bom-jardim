/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ClientePF;
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
 * @author leticiasilva
 */
public class PClientePF {

    Connection cnn = util.Conexao.getConexao();

    public void incluir(ClientePF parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " clientepf (nome, cpf, telefone, endereco, email) "
                + " VALUES (?,?,?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getCpf());
        prd.setString(3, parametro.getTelefone());
        prd.setString(4, parametro.getEndereco());
        prd.setString(5, parametro.getEmail());
//        prd.setObject(6, parametro.getTipoCliente().getIdentificador());

        prd.execute();
        cnn.close();
    }

    public void alterar(ClientePF parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE clientepf SET"
                    + " nome = ?,"
                    + " cpf = ?, "
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
            prd.setString(2, parametro.getCpf());
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
        String sql = "DELETE FROM clientepf "
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

    public ClientePF consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, nome, cpf, endereco, telefone, email"
                + " FROM clientePF WHERE identificador = ?;";

//        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        ClientePF retorno = new ClientePF();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setEmail(rs.getString("email"));
//            retorno.setTipoCliente(new PTipoCliente().consultar(rs.getInt("id_tipoClientePF")));
        }
        return retorno;
    }

    public List<ClientePF> listar() throws SQLException {

        String sql = "SELECT * FROM clientepf";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<ClientePF> retorno = new ArrayList<>();

        while (rs.next()) {
            ClientePF clientePF = new ClientePF();

            clientePF.setIdentificador(rs.getInt("identificador"));
            clientePF.setNome(rs.getString("nome"));
            clientePF.setCpf(rs.getString("cpf"));
            clientePF.setEndereco(rs.getString("endereco"));
            clientePF.setTelefone(rs.getString("telefone"));
            clientePF.setEmail(rs.getString("email"));
            TipoCliente tpcliente = new TipoCliente();
            tpcliente.setIdentificador(rs.getInt("identificador"));
            clientePF.setTipoCliente(tpcliente);

            retorno.add(clientePF);
        }
        return retorno;
    }
}
