package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Cinema;
import br.ufc.catalogocinemas.model.Sala;

import java.util.List;

public interface CinemaController {
    //TODO Confirmar API

    Cinema addCinema(Cinema cinema);

    Cinema removerCinema(int id);

    Cinema atualizarCinema(Cinema cinema);

    Cinema buscarCinema(int id);

    List<Cinema> buscarTodosCinemas();

    boolean vincularSala(Sala sala);

    boolean desvincularSala(int id);

}
