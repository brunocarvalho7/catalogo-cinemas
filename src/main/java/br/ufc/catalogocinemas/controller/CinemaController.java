package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Cinema;
import br.ufc.catalogocinemas.model.Sala;
import br.ufc.catalogocinemas.service.CinemaService;
import br.ufc.catalogocinemas.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService sService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addCinema(Cinema cinema) {
        ModelAndView model = new ModelAndView("cinema");

        if(cinema != null && cinema.getNome() != null && cinema.getNome().trim().isEmpty() == false){
            if(cinema.getEndereco() != null && cinema.getEndereco().trim().isEmpty() == false){
                if(cinema.getCidade() != null && cinema.getEndereco().trim().isEmpty() == false){
                    Cinema cinemaResponse = sService.addCinema(cinema);

                    model.addObject("cinema", cinemaResponse);
                }
            }
        }
        return model;
    }

    @RequestMapping(path = "/remover/{id}")
    public ModelAndView removerCinema(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("cinema");

        if(id > 0){
            Cinema cinemaResponse = sService.removerCinema(id);

            model.addObject("cinema", cinemaResponse);
        }

        return model;
    }

    @RequestMapping(path = "/atualizar", method = RequestMethod.POST)
    public ModelAndView atualizarCinema(Cinema cinema) {
        ModelAndView model = new ModelAndView("cinema");

        if(cinema != null && cinema.getNome() != null && cinema.getNome().trim().isEmpty() == false){
            if(cinema.getEndereco() != null && cinema.getEndereco().trim().isEmpty() == false){
                if(cinema.getCidade() != null && cinema.getEndereco().trim().isEmpty() == false){
                    Cinema cinemaResponse = sService.atualizarCinema(cinema);

                    model.addObject("cinema", cinemaResponse);
                }
            }
        }
        return model;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView buscarCinema(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("cinema");

        if(id > 0){
            Cinema cinemaResponse = sService.buscarCinema(id);

            model.addObject("cinema", cinemaResponse);
        }

        return model;
    }

    public ModelAndView buscarTodosOsCinemas() {
        ModelAndView model = new ModelAndView("cinema");

        model.addObject("cinemas", sService.buscarTodosOsCinemas());

        return model;
    }

    @RequestMapping(path = "/vincular")
    public ModelAndView vincularSala(@RequestParam("sala") int idSala, @RequestParam("cinema") int idCinema) {
        ModelAndView model = new ModelAndView("cinema");

        if(idSala > 0 && idCinema > 0){
            if(sService.vincularSala(idSala, idCinema)){
                model.addObject("msg", Constantes.MSG_SUCESSO_VINCULAR_SALA_CINEMA);
            }else{
                model.addObject("msg", Constantes.MSG_ERRO_VINCULAR_SALA_CINEMA);
            }
        }else{
            model.addObject("msg", Constantes.MSG_ERRO_VINCULAR_SALA_CINEMA);
        }

        return model;
    }

    @RequestMapping(path = "/desvincular")
    public ModelAndView desvincularSala(@RequestParam("sala") int idSala, @RequestParam("cinema") int idCinema) {
        ModelAndView model = new ModelAndView("cinema");

        if(idSala > 0 && idCinema > 0){
            if(sService.desvincularSala(idSala, idCinema)){
                model.addObject("msg", Constantes.MSG_SUCESSO_DESVINCULAR_SALA_CINEMA);
            }else{
                model.addObject("msg", Constantes.MSG_ERRO_DESVINCULAR_SALA_CINEMA);
            }
        }else{
            model.addObject("msg", Constantes.MSG_ERRO_DESVINCULAR_SALA_CINEMA);
        }

        return model;
    }

}
