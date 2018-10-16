/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ClientePF;
import java.sql.SQLException;
import java.util.List;
import persistencia.PClientePF;

/**
 *
 * @author leticiasilva
 */
public class NClientePF {

    PClientePF persistencia;

    public NClientePF() {
        this.persistencia = new PClientePF();
    }

    public void salvar(ClientePF parametro) throws SQLException, Exception {

//        NTipoAssociado ntp = new NTipoAssociado();
//
//        TipoAssociado tp = new TipoAssociado();
//        //instancia novo objeto do tipo associado
//        Associado associado = new Associado();
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
            throw new Exception("Ë necessário informar o tipo do cliente(PF ou PJ)!");
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

    public ClientePF consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<ClientePF> listar() throws SQLException {
        return persistencia.listar();
    }
}
