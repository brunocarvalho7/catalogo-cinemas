package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.model.Filme;
import br.ufc.catalogocinemas.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService sService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addFilme(Filme filme) {
        ModelAndView model = new ModelAndView("filme");

        if(filme != null && filme.getNome() != null && filme.getNome().trim().isEmpty() == false){
            Filme filmeResponse = sService.addFilme(filme);

            model.addObject("filme", filmeResponse);
        }

        return model;
    }

    @RequestMapping(path = "/remover/{id}")
    public ModelAndView removerFilme(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("filme");

        if(id > 0){
            Filme filmeResponse = sService.removerFilme(id);

            model.addObject("filme", filmeResponse);
        }

        return model;
    }

    @RequestMapping(path = "/atualizar", method = RequestMethod.POST)
    public ModelAndView atualizarFilme(Filme filme) {
        ModelAndView model = new ModelAndView("filme");

        if(filme != null && filme.getId() > 0){
            if(filme.getNome() != null && filme.getNome().trim().isEmpty() == false){
                Filme filmeResponse = sService.atualizarFilme(filme);

                model.addObject("filme", filmeResponse);
            }
        }

        return model;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView buscarFilmeId(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("filme");

        if(id > 0){
            Filme filmeResponse = sService.buscarFilmeId(id);

            model.addObject("filme", filmeResponse);
        }

        return model;
    }

    @RequestMapping(path = "/porNome")
    public ModelAndView buscarFilmeNome(@RequestParam("nome") String nome) {
        ModelAndView model = new ModelAndView("filme");

        if(nome != null && nome.trim().isEmpty() == false){
            List<Filme> filmesResponse = sService.buscarFilmeNome(nome);

            model.addObject("filmes", filmesResponse);
        }

        return model;
    }

}
