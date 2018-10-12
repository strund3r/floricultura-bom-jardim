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
public class ClientePF extends Cliente {
    
    private String cpf;
    private TipoCliente tipoCliente;

    public ClientePF(String cpf, TipoCliente tipoCliente, int identificador, String nome, String telefone, String endereco, String email) {
        super(identificador, nome, telefone, endereco, email);
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
    }

    public ClientePF() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
    
}
