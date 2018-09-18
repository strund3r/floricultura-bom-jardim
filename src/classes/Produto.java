/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author luisf
 */
public class Produto {

    private String nome;
    private String codigo;
    private String descricao;
    private double custo;
    private double valorVenda;
    private double valorLucro;
    private int quantidade;

    public Produto(String nome, String codigo, String descricao, double custo, double valorVenda, double valorLucro, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.custo = custo;
        this.valorVenda = valorVenda;
        this.valorLucro = valorLucro;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public double getValorLucro() {
        return valorLucro;
    }

    public void setValorLucro(double valorLucro) {
        this.valorLucro = valorLucro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
