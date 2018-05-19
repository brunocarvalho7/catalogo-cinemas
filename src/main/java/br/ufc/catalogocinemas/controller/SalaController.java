package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Sala;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface SalaController {
    ModelAndView addSala(Sala sala);

    ModelAndView removerSala(int id);

    ModelAndView atualizarSala(Sala sala);

    ModelAndView buscarSalaId(int id);

    //TODO: RETIRAR ESSE MÉTODO E FAZER TUDO VIA JOIN NO SERVICE DE SALA
    List<Sala> buscarSalasPorCidade(String cidade);

    List<Sala> buscarTodasAsSalas();

    ModelAndView buscarSalaNome(String nome);

}
