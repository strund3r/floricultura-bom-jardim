/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Pedido;
import java.sql.SQLException;
import java.util.List;
import persistencia.PPedido;

/**
 *
 * @author luisf
 */
public class NPedido {

    PPedido persistencia;

    public NPedido() {
        this.persistencia = new PPedido();
    }

    public void salvar(Pedido parametro) throws SQLException, Exception {
        if (parametro.getId_produto() == 0) {
            throw new Exception("Ë necessário informar o produto!");
        }
        if (parametro.getId_cliente() == 0) {
            throw new Exception("Ë necessário informar um cliente!");
        }
//        if (parametro.getQuantidade() == 0) {
//            throw new Exception("Ë necessário informar a quantidade!");
//        }
        if (parametro.getID() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }

    public Pedido consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Pedido> listar() throws SQLException {
        return persistencia.listar();
    }
}
