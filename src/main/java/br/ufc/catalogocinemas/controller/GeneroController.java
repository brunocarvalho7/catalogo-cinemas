package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Genero;
import br.ufc.catalogocinemas.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    GeneroService sService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addGenero(Genero genero){
        ModelAndView model = new ModelAndView("genero");

        if(genero != null && genero.getDescricao() != null && genero.getDescricao().trim().isEmpty() == false){
            Genero generoResponse = sService.addGenero(genero);

            model.addObject("genero", generoResponse);
        }

        return model;
    }

    @RequestMapping(path = "/remover/{id}")
    public ModelAndView removerGenero(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("genero");

        if(id > 0){
            Genero generoResponse = sService.removerGenero(id);

            model.addObject("genero", generoResponse);
        }

        return model;
    }

    @RequestMapping(path = "/atualizar", method = RequestMethod.POST)
    public ModelAndView atualizarGenero(Genero genero){
        ModelAndView model = new ModelAndView("genero");

        if(genero != null && genero.getId() > 0){
            if(genero.getDescricao() != null && genero.getDescricao().trim().isEmpty() == false){
                Genero generoResponse = sService.atualizarGenero(genero);

                model.addObject("genero", generoResponse);
            }
        }

        return model;
    }

    @RequestMapping(path = "/")
    public ModelAndView getAllGeneros(){
        ModelAndView model = new ModelAndView("genero");

        model.addObject("generos", sService.getAllGeneros());

        return model;
    }

}
