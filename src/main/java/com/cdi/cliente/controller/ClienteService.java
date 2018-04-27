package com.cdi.cliente.controller;

import com.cdi.cliente.dao.ClienteDAO;
import com.cdi.cliente.model.Cliente;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
public class ClienteService {
    
    @Inject
    private ClienteDAO cDAO;
    
    private ClienteService(){}
    
    public void salvar(Cliente c){
        if(c.getId() == 0){
            cDAO.adicionarCliente(c);
        } else {
            cDAO.atualizarCliente(c);
        }
    }

    public void deletar(Cliente c){
        cDAO.deletarCliente(c);
    }
    
    public Cliente getCliente(int id){
        return cDAO.getCliente(id);
    }
    
    public List<Cliente> list(){
        return cDAO.listarCliente();
    }
}
