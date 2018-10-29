
package entidade;

import java.sql.Date;

public class Financeiro {

    private int identificador;
    private Date dataVencimentoTitulo;
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

    public Date getDataVencimentoTitulo() {
        return dataVencimentoTitulo;
    }

    public void setDataVencimentoTitulo(Date dataVencimentoTitulo) {
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