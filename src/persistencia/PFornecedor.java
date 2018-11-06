package persistencia;

import entidade.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PFornecedor {
    
    Connection cnn = util.Conexao.getConexao();
    
    public void incluir(Fornecedor parametro) throws SQLException {

        //Cria a intrução sql para a inserção de registros 
        String sql = "INSERT INTO fornecedor (nome, endereco, telefone, cnpj, email) VALUES (?,?,?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //trocando os valores da ? por valores recebidos no método
        
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getEndereco());
        prd.setString(3, parametro.getTelefone());
        prd.setString(4, parametro.getCnpj());
        prd.setString(5, parametro.getEmail());
        
        prd.execute();
        cnn.close();

    }

    public void alterar(Fornecedor parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE fornecedor SET"
                + " nome = ?,"
                + " endereco = ?,"
                + " telefone = ?,"
                + " cnpj = ?"                
                + " email = ?"                
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getEndereco());
        prd.setString(3, parametro.getTelefone());
        prd.setString(4, parametro.getCnpj());
        prd.setString(5, parametro.getEmail());;

        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM fornecedor "
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

    public Fornecedor consultar(int parametro) throws SQLException {

        String sql = "SELECT identificador, nome, endereco, telefone, cnpj, email"
                + "FROM fornecedor WHERE identificador = ?";

//        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Fornecedor retorno = new Fornecedor();

        if (rs.next()) {

            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setCnpj(rs.getString("cnpj"));
            retorno.setCnpj(rs.getString("email"));

        }

        return retorno;
    }

    public List<Fornecedor> listar() throws SQLException {

        String sql = "SELECT * FROM fornecedor";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Fornecedor> retorno = new ArrayList<>();

        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setIdentificador(rs.getInt("identificador"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setEndereco(rs.getString("endereco"));
            fornecedor.setTelefone(rs.getString("telefone"));
            fornecedor.setCnpj(rs.getString("cnpj"));
            fornecedor.setCnpj(rs.getString("email"));
            
            retorno.add(fornecedor);
        }
        return retorno;
    }
}
