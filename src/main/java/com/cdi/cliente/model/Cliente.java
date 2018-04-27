package com.cdi.cliente.model;

import com.cdi.pessoa.model.Pessoa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {

    /* O 'id' está vindo da tabela pessoa pela anotação @Inheritance */
    private String nomeFantasia;
    
    public Cliente(){}

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
