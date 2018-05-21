package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Diretor;
import br.ufc.catalogocinemas.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/diretor")
public class DiretorController {

    @Autowired
    DiretorService sService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addDiretor(Diretor diretor){
        ModelAndView model = new ModelAndView("diretor");

        if(diretor != null && diretor.getNome() != null && diretor.getNome().trim().isEmpty() == false){
            Diretor diretorResponse = sService.adicionarDiretor(diretor);

            model.addObject("diretor", diretorResponse);
        }

        return model;
    }

    @RequestMapping(path = "/remover/{id}")
    public ModelAndView removerDiretor(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("diretor");

        if(id > 0){
            Diretor diretorResponse = sService.removerDiretor(id);

            model.addObject("diretor", diretorResponse);
        }

        return model;
    }

    @RequestMapping(path = "/atualizar", method = RequestMethod.POST)
    public ModelAndView atualizarDiretor(Diretor diretor){
        ModelAndView model = new ModelAndView("diretor");

        if(diretor != null && diretor.getId() > 0){
            if(diretor.getNome() != null && diretor.getNome().trim().isEmpty() == false){
                Diretor diretorResponse = sService.atualizarDiretor(diretor);

                model.addObject("diretor", diretorResponse);
            }
        }

        return model;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView getDiretor(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("diretor");

        if(id > 0){
            Diretor diretorResponse = sService.buscarDiretor(id);

            model.addObject("diretor", diretorResponse);
        }

        return model;
    }

    @RequestMapping(path = "/")
    public ModelAndView getAllDiretores(){
        ModelAndView model = new ModelAndView("diretor");

        model.addObject("diretores", sService.getAllDiretores());

        return model;
    }

}
