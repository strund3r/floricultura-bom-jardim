package persistencia;

import entidade.Financeiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PFinanceiro {

    public void incluir(Financeiro parametro) throws SQLException {

        //Cria a intrução sql para a inserção de registros 
        String sql = "INSERT INTO titulo (datavencimentotitulo, descricaotitulo, nomecliente, statustitulo, valortitulo) VALUES (?,?,?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //trocando os valores da ? por valores recebidos no método
        
        prd.setDate(1, parametro.getDataVencimentoTitulo());
        prd.setString(2, parametro.getDescricaoTitulo());
        prd.setString(3, parametro.getNomeCliente());
        prd.setInt(4, parametro.getStatusTitulo());
        prd.setDouble(5, parametro.getValorTitulo());
        

        prd.execute();
        cnn.close();

    }

    public void alterar(Financeiro parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE titulo SET"
                + " datavencimentotitulo = ?,"
                + " descricaotitulo = ?,"
                + " nomecliente = ?,"
                + " statustitulo = ?,"
                + " valortitulo = ?"
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setDate(1, parametro.getDataVencimentoTitulo());
        prd.setString(2, parametro.getDescricaoTitulo());
        prd.setString(3, parametro.getNomeCliente());
        prd.setInt(4, parametro.getStatusTitulo());
        prd.setDouble(5, parametro.getValorTitulo());
        prd.setInt(6, parametro.getIdentificador());

        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM titulo "
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

    public Financeiro consultar(int parametro) throws SQLException {

        String sql = "SELECT datavencimentotitulo, descricaotitulo, identificador, nomecliente, statustitulo, valortitulo FROM titulo WHERE identificador = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Financeiro retorno = new Financeiro();

        if (rs.next()) {

            retorno.setDataVencimentoTitulo(rs.getDate("datavencimentotitulo"));
            retorno.setDescricaoTitulo(rs.getString("descricaotitulo"));
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setNomeCliente(rs.getString("nomecliente"));
            retorno.setStatusTitulo(rs.getInt("statustitulo"));
            retorno.setValorTitulo(rs.getDouble("valortitulo"));

        }

        return retorno;
    }

    public List<Financeiro> listar() throws SQLException {

        String sql = "SELECT * FROM titulo";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Financeiro> retorno = new ArrayList<>();

        while (rs.next()) {
            Financeiro titulo = new Financeiro();

            titulo.setDataVencimentoTitulo(rs.getDate("datavencimentotitulo"));
            titulo.setDescricaoTitulo(rs.getString("descricaotitulo"));
            titulo.setIdentificador(rs.getInt("identificador"));
            titulo.setNomeCliente(rs.getString("nomecliente"));
            titulo.setStatusTitulo(rs.getInt("statustitulo"));
            titulo.setValorTitulo(rs.getDouble("valortitulo"));

            retorno.add(titulo);
        }
        return retorno;
    }

}
