package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Sala;

import java.util.List;

public interface SalaController {

    Sala cadastrarGET(Sala sala);

    Sala cadastrarPOST(Sala sala);

    Sala addSala(Sala sala);

    Sala removerSala(int id);

    Sala atualizarSala(Sala sala);

    Sala buscarSalaId(int id);

    List<Sala> buscarSalasPorCidade(String cidade);

    List<Sala> buscarTodasAsSalas();

    Sala buscarSalaNome(String nome);

}
