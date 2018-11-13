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

    public ClientePF(String cpf, int id, String nome, String telefone, String endereco, String email) {
        super(id, nome, telefone, endereco, email);
        this.cpf = cpf;
    }

    public ClientePF() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
        
    
}
