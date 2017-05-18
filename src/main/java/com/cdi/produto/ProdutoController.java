package com.cdi.produto;

import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
public class ProdutoController {
    
    @Inject
    private ProdutoDao model;
    
    public void listar(){
        List<Produto> list = model.list();
        for (Produto produto : list) {
            System.out.println("Id: "+ produto.getId());
            System.out.println("Name: "+ produto.getName());
        }
    }
    
    public static void main(String[] args) {
        ProdutoController controller = new ProdutoController();
        controller.listar();
    }
}
