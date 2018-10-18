/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.TipoProduto;
import java.sql.SQLException;
import java.util.List;
import persistencia.PTipoProduto;

/**
 *
 * @author luisf
 */
public class NTipoProduto {
     PTipoProduto persistencia;

    public NTipoProduto() {
        persistencia = new PTipoProduto();
    }

    public void salvar(TipoProduto parametro) throws SQLException, Exception {

        if (parametro.getNome().isEmpty()) {
            throw new Exception("Ë necesário informar a descrição do tipo de produto!");
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

    public TipoProduto consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public TipoProduto consultarPorStringN(String parametro) throws SQLException {
        return persistencia.consultarPorString(parametro);
    }

    public List<TipoProduto> listar() throws SQLException {
        return persistencia.listar();
    }
}
