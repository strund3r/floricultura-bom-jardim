/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ClientePJ;
import java.sql.SQLException;
import java.util.List;
import persistencia.PClientePJ;

/**
 *
 * @author luisf
 */
public class NClientePJ {

    PClientePJ persistencia;

    public NClientePJ() {
        this.persistencia = new PClientePJ();
    }

    public void salvar(ClientePJ parametro) throws SQLException, Exception {
        if (parametro.getNome().isEmpty()) {
            throw new Exception("Ë necessário informar o nome!");
        }
        if (parametro.getEndereco().isEmpty()) {
            throw new Exception("Ë necessário informar um endereço!");
        }
        if (parametro.getTelefone().isEmpty()) {
            throw new Exception("Ë necessário informar um telefone!");
        }
        if (parametro.getTipoCliente() == null) {
            throw new Exception("Ë necessário informar o tipo do cliente(PJ ou PJ)!");
        }
        if (parametro.getID()== 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }

    public ClientePJ consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<ClientePJ> listar() throws SQLException {
        return persistencia.listar();
    }
}
