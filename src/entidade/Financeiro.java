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
public class Financeiro {

    private int identificador;
    private String dataVencimentoTitulo;
    private String nomeCliente;
    private String descricaoTitulo;
    private double valorTitulo;
    private int statusTitulo;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getStatusTitulo() {
        return statusTitulo;
    }

    public void setStatusTitulo(int statusTitulo) {
        this.statusTitulo = statusTitulo;
    }

    public String getDataVencimentoTitulo() {
        return dataVencimentoTitulo;
    }

    public void setDataVencimentoTitulo(String dataVencimentoTitulo) {
        this.dataVencimentoTitulo = dataVencimentoTitulo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricaoTitulo() {
        return descricaoTitulo;
    }

    public void setDescricaoTitulo(String descricaoTitulo) {
        this.descricaoTitulo = descricaoTitulo;
    }

    public double getValorTitulo() {
        return valorTitulo;
    }

    public void setValorTitulo(double valorTitulo) {
        this.valorTitulo = valorTitulo;
    }
}