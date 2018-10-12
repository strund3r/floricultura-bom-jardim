/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.TipoCliente;
import java.sql.SQLException;
import java.util.List;
import persistencia.PTipoCliente;

/**
 *
 * @author luisf
 */
public class NTipoCliente {

    PTipoCliente persistencia;

    public NTipoCliente() {
        persistencia = new PTipoCliente();
    }

    public void salvar(TipoCliente parametro) throws SQLException, Exception {

        if (parametro.getDescricao().isEmpty()) {
            throw new Exception("Ë necesário informar a descrição do tipo de cliente!");
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

    public TipoCliente consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public TipoCliente consultarPorStringN(String parametro) throws SQLException {
        return persistencia.consultarPorString(parametro);
    }

    public List<TipoCliente> listar() throws SQLException {
        return persistencia.listar();
    }
}