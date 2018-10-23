/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author luisf
 */
public class ClientePJ extends Cliente {

    private String cnpj;
    private TipoCliente tipoCliente;

    public ClientePJ(String cnpj, TipoCliente tipoCliente, int identificador, String nome, String telefone, String endereco, String email) {
        super(identificador, nome, telefone, endereco, email);
        this.cnpj = cnpj;
        this.tipoCliente = tipoCliente;
    }
    
        public ClientePJ() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
}
