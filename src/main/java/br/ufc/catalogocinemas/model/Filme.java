package br.ufc.catalogocinemas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   // private String nome;

    public Filme() {
    }

    //Todo: Remover isso
    public Filme(int id){
        this.id = id;
       // this.nome = nome;
    }

    //Todo: Remover isso
    public int getId(){
        return id;
    }

    /*public String getNome(){
        return nome;
    }*/
}
