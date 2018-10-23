/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Financeiro;
import java.sql.SQLException;
import java.util.List;
import persistencia.PFinanceiro;

/**
 *
 * @author leticiasilva
 */
public class NFinanceiro {

    PFinanceiro persistencia;

    public NFinanceiro() {
        persistencia = new PFinanceiro();
    }

    public void salvar(Financeiro parametro) throws SQLException, Exception {

        if (parametro.getNomeCliente().isEmpty()) {
            throw new Exception("É necessário informar o nome.");
        }
        if (parametro.getValorTitulo() <= 0) {
            throw new Exception("É necessário informar o valor do titulo.");
        }
        if (parametro.getDescricaoTitulo().isEmpty()) {
            throw new Exception("É necessário informar a descrição.");
        }
        if (parametro.getDataVencimentoTitulo().isEmpty()) {
            throw new Exception("É necessário informar o vencimento.");
        }
        if (parametro.getStatusTitulo() == 0){
            throw new Exception("É necessário informar o status.");
        }

        if (parametro.getIdentificador() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }

    public Financeiro consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Financeiro> listar() throws SQLException {
        return persistencia.listar();
    }

}
