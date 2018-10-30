
package entidade;

/**
 *
 * @author luisf
 */
public class Pedido {

    private int id;
    private int id_cliente;
    private int id_produto;
    private double valor;

    public Pedido(int id, int id_cliente, int id_produto) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_produto = id_produto;
    }

    public Pedido() {
        
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
