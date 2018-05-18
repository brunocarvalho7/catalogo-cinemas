package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Genero;

import java.util.List;

public interface GeneroController {

    Genero buscarGeneroId(int id);

    Genero buscarGeneroNome(String nome);

    List<Genero> getAllGeneros();

    Genero atualizarGenero(Genero Genero);

    Genero addGenero(Genero Genero);

    Genero removerGenero(int id);

}
