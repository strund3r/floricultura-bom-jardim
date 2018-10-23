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
public class TipoProduto {

    private int id;
    private String nome;

    public TipoProduto(int id, String descricao) {
        this.id = id;
        this.nome = descricao;
    }

    public TipoProduto() {
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }

}
