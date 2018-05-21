package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Sala;
import br.ufc.catalogocinemas.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sala")
public class SalaController {

    @Autowired
    private SalaService sService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addSala(Sala sala) {
        ModelAndView model = new ModelAndView("sala");

        if(sala != null && sala.getTipo() != null && sala.getCapacidade() > 0){
            Sala salaResponse = sService.addSala(sala);

            model.addObject("sala", salaResponse);
        }

        return model;
    }

    @RequestMapping(path = "/remover/{id}")
    public ModelAndView removerSala(int id) {
        ModelAndView model = new ModelAndView("sala");

        if(id > 0){
            Sala salaResponse = sService.removerSala(id);

            model.addObject("sala", salaResponse);
        }

        return model;
    }

    @RequestMapping(path = "/atualizar", method = RequestMethod.POST)
    public ModelAndView atualizarSala(Sala sala) {
        ModelAndView model = new ModelAndView("sala");

        if(sala != null && sala.getId() > 0){
            if(sala.getCapacidade() > 0){
                Sala salaResponse = sService.atualizarSala(sala);

                model.addObject("sala", salaResponse);
            }
        }

        return model;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView buscarSalaId(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("sala");

        if(id > 0){
            Sala salaResponse = sService.buscarSala(id);

            model.addObject("sala", salaResponse);
        }

        return model;
    }

    public ModelAndView buscarTodasAsSalas() {
        ModelAndView model = new ModelAndView("sala");

        model.addObject("salas", sService.buscarTodasAsSalas());

        return model;
    }

    public ModelAndView buscarSalaNome(String nome) {
        ModelAndView model = new ModelAndView("sala");

        if(nome != null && nome.trim().isEmpty() == false){
            model.addObject("sala", sService.buscarSalaNome(nome));
        }

        return model;
    }

}
