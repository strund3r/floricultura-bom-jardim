package negocio;

import entidade.Fornecedor;
import java.sql.SQLException;
import java.util.List;
import persistencia.PFornecedor;

public class NFornecedor {

    PFornecedor persistencia;

    public NFornecedor() {
        persistencia = new PFornecedor();
    }

    public void salvar(Fornecedor parametro) throws SQLException, Exception {

        if (parametro.getNome().isEmpty()) {
            throw new Exception("É necessário informar o nome.");
        }
        if (parametro.getCnpj().isEmpty()) {
            throw new Exception("É necessário informar o CNPJ.");
        }
        if (parametro.getEndereco().isEmpty()) {
            throw new Exception("É necessário informar o endereço.");
        }
        if (parametro.getTelefone().isEmpty()) {
            throw new Exception("É necessário informar a telefone.");
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

    public Fornecedor consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Fornecedor> listar() throws SQLException {
        return persistencia.listar();
    }

}
