/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Produto;
import java.sql.SQLException;
import java.util.List;
import persistencia.PProduto;

/**
 *
 * @author leticiasilva
 */
public class NProduto {
    
     PProduto persistencia;

    public NProduto() {
        this.persistencia = new PProduto();
    }

    public void salvar(Produto parametro) throws SQLException, Exception {

//        NTipoAssociado ntp = new NTipoAssociado();
//
//        TipoAssociado tp = new TipoAssociado();
//        //instancia novo objeto do tipo associado
//        Associado associado = new Associado();
        if (parametro.getNome().isEmpty()) {
            throw new Exception("Ë necessário informar o nome do produto!");
        }
        if (parametro.getCusto() <= 0 ){
            throw new Exception("Ë necessário informar o preço de custo!");
        }
        if (parametro.getValorVenda()<= 0 ){
            throw new Exception("Ë necessário informar um preço de venda!");
        }
        if (parametro.getTipoProduto()== null) {
            throw new Exception("Ë necessário informar o tipo do produto!");
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

    public Produto consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Produto> listar() throws SQLException {
        return persistencia.listar();
    }
    
}
