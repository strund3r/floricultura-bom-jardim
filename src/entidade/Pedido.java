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
public class Pedido {

    private int identificador;
    private int id_cliente;
    private int quantidade;
    private int id_produto;

    public Pedido(int identificador, int id_cliente, int quantidade, int id_produto) {
        this.identificador = identificador;
        this.id_cliente = id_cliente;
        this.quantidade = quantidade;
        this.id_produto = id_produto;
    }

    public Pedido() {
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
}
