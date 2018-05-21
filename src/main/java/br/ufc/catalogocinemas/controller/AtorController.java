package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Ator;
import br.ufc.catalogocinemas.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    AtorService sService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addAtor(Ator ator){
        ModelAndView model = new ModelAndView("ator");

        if(ator != null && ator.getNome() != null && ator.getNome().trim().isEmpty() == false){
            Ator atorResponse = sService.adicionarAtor(ator);

            model.addObject("ator", atorResponse);
        }

        return model;
    }

    @RequestMapping(path = "/remover/{id}")
    public ModelAndView removerAtor(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("ator");

        if(id > 0){
            Ator atorResponse = sService.removerAtor(id);

            model.addObject("ator", atorResponse);
        }

        return model;
    }

    @RequestMapping(path = "/atualizar", method = RequestMethod.POST)
    public ModelAndView atualizarAtor(Ator ator){
        ModelAndView model = new ModelAndView("ator");

        if(ator != null && ator.getId() > 0){
            if(ator.getNome() != null && ator.getNome().trim().isEmpty() == false){
                Ator atorResponse = sService.atualizarAtor(ator);

                model.addObject("ator", atorResponse);
            }
        }

        return model;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView getAtor(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("ator");

        if(id > 0){
            Ator atorResponse = sService.buscarAtor(id);

            model.addObject("ator", atorResponse);
        }

        return model;
    }

    @RequestMapping(path = "/")
    public ModelAndView getAllAtores(){
        ModelAndView model = new ModelAndView("ator");

        model.addObject("atores", sService.getAllAtores());

        return model;
    }
}
