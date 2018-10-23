/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import entidade.Financeiro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author leticiasilva
 */
public class PFinanceiro {
    
    public void incluir(Financeiro parametro) throws SQLException {

        //Cria a intrução sql para a inserção de registros 
        String sql = "INSERT INTO titulo (datavencimentotitulo, descricaotitulo, identificador, nomecliente, statustitulo, valortitulo) VALUES (?,?,?,?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //trocando os valores da ? por valores recebidos no método
        //prd.setDate(1, Date.valueOf(parametro.getDataVencimentoTitulo()));
        prd.setDate(1, Date.valueOf("2000-01-01"));
        prd.setString(2, parametro.getDescricaoTitulo());
        prd.setInt(3, parametro.getIdentificador());
        prd.setString(4, parametro.getNomeCliente());
        prd.setInt(5, parametro.getStatusTitulo());
        prd.setDouble(6, parametro.getValorTitulo());
        
        
        prd.execute();
        cnn.close();
        
    }
    
    public void alterar(Financeiro parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE titulo SET"
                + " datavencimentotitulo = ?,"
                + " descricaotitulo = ?,"
                + " identificador = ?,"
                + " nomecliente = ?,"
                + " statustitulo = ?,"
                + " valortitulo = ?"
                
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getDataVencimentoTitulo());
        prd.setString(2, parametro.getDescricaoTitulo());
        prd.setInt(3, parametro.getIdentificador());
        prd.setString(4, parametro.getNomeCliente());
        prd.setInt(5, parametro.getStatusTitulo());
        prd.setDouble(6, parametro.getValorTitulo());
        
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
            
            retorno.setDataVencimentoTitulo(rs.getString("datavencimentotitulo"));
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
        
        Statement st = cnn.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery(sql);
        List<Financeiro> retorno = new ArrayList<Financeiro>();
        
        while (rs.next()) {
            Financeiro titulo = new Financeiro();
            
            titulo.setDataVencimentoTitulo(rs.getString("datavencimentotitulo"));
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

