package br.ufc.catalogocinemas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ator extends Pessoa {

    //@ManyToMany(mappedBy = "atores", fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes;

    public Ator() {
    }

    public Ator(String nome, String sobre) {
        super(nome, sobre);
        this.filmes = new ArrayList<>();
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public boolean addFilme(Filme filme){
        this.getFilmes().add(filme);
        return filme.adicionarAtor(this);
    }

    public boolean removerFilme(Filme filme){
        this.getFilmes().remove(filme);
        return filme.removerAtor(this);
    }

    @Override
    public String toString() {
        String aux = "";
      /*  for(Filme f:this.filmes){
            aux += f.getId()+" - "+f.getNome();
        }*/

        return "{{ "+super.toString() + aux+" }}";
    }
}
