package br.ufc.catalogocinemas.controller;

import br.ufc.catalogocinemas.mocks.Mocks;
import br.ufc.catalogocinemas.model.Filme;
import br.ufc.catalogocinemas.model.Sala;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PrincipalController {

    public String index(){
        return "index";
    }

    @RequestMapping(path = "/add")
    public ModelAndView addSessao() {
        ModelAndView model = new ModelAndView("adicionar-sessao");
        List<Filme> filmes = Mocks.getFilmeControllerMock().buscarTodosOsFilmes();
        List<Sala> salas= Mocks.getSalaControllerMock().buscarTodasAsSalas();
        model.addObject("salas", salas);
        model.addObject("filmes", filmes);
        return model;
    }
}
