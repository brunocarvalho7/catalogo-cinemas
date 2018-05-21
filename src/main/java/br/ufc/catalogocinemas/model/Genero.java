package br.ufc.catalogocinemas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotNull
    public String descricao;

    public Genero(){

    }

    public Genero(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genero genero = (Genero) o;

        return id == genero.id;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
