package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Filme;

import java.util.List;

public interface FilmeController {

    Filme buscarFilmeId(int id);

    Filme buscarFilmeNome(String nome);

    List<Filme> buscarTodosOsFilmes();

    List<Filme> buscarFilmePorGenero(int idGenero);

    Filme atualizarFilme(Filme filme);

    Filme addFilme(Filme filme);

    Filme removerFilme(int id);

}
