/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Cliente;
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
public class PCliente {


    Connection cnn = util.Conexao.getConexao();

    public void incluir(Cliente parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " associado (nome, cpf, telefone, endereco, email, id_cliente) "
                + " VALUES (?,?,?,?,?, ?)";

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
        prd.setObject(6, parametro.getCliente().getIdentificador());

        prd.execute();
        cnn.close();
    }

    public void alterar(Cliente parametro) throws SQLException {

        try {
            //Cria a instrução sql para a inserção de registros
            String sql = "UPDATE associado SET"
                    + " nome = ?,"
                    + " cpf = ?, "
                    + " telefone = ?, "
                    + " endereco = ?, "
                    + " email"
                    + "identificador"
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
            prd.setObject(6, parametro.getCliente().getIdentificador());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM cliente "
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
    
    public Cliente consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, nome, endereco, telefone, id_tipoassociado"
                + " FROM associado WHERE identificador = ?;";

//        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Cliente retorno = new Cliente();

        if (rs.next()) {
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setCliente(new PCliente().consultar(rs.getInt("id_cliente")));
        }
        return retorno;
    }
    
    public List<Cliente> listar() throws SQLException {

        String sql = "SELECT * FROM associado";

        Connection cnn = util.Conexao.getConexao();

        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        List<Cliente> retorno = new ArrayList<>();

        while (rs.next()) {
            Cliente associado = new Cliente();

            associado.setIdentificador(rs.getInt("identificador"));
            associado.setNome(rs.getString("nome"));
            associado.setEndereco(rs.getString("endereco"));
            associado.setTelefone(rs.getString("telefone"));
            Cliente tpa = new Cliente();
            tpa.setIdentificador(rs.getInt("id_tipoassociado"));
            associado.setCliente(tpa);
            
            retorno.add(associado);
        }
        return retorno;
    }
}


