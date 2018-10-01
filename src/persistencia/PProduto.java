/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Produto;
import java.util.ArrayList;

/**
 *
 * @author luisf
 */
public class PProduto {

    ArrayList<Produto> produtos = new ArrayList();

    public void adicionarProduto(Produto produto) {

        if (!buscarProduto(produto.getCodigo())) {
            produtos.add(produto);
        } else {
            //produto já cadastrado
            System.out.println("produto já cadastrado"); //apenas teste temporário
        }
    }

    public boolean buscarProduto(String codigo) {

        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public void atualizarProduto(Produto produto) {

    }

    public boolean excluirProduto(Produto produto) {

        if (buscarProduto(produto.getCodigo())) {
            produtos.remove(produto);
            return true;
        }
        //produto não localizado
        System.out.println("produto não localizado"); //apenas teste temporário
        return false;
    }

}
