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
public class Produto {

    private int identificador;
    private String nome;
    private String descricao;
    private double custo;
    private double valorVenda;
    private int quantidade;
    private TipoProduto tipoProduto;

    public Produto(int identificador, String nome, String descricao, double custo, double valorVenda, int quantidade, TipoProduto tipoProduto) {
        this.identificador = identificador;
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
        this.tipoProduto = tipoProduto;
    }
    
    public Produto() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
