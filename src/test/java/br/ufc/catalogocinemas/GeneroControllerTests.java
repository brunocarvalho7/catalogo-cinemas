package br.ufc.catalogocinemas;

import br.ufc.catalogocinemas.controller.GeneroController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroControllerTests {

    @Autowired
    GeneroController controller;

    @Test
    public void adicionarGeneroCorretamenteTest(){

    }

    @Test
    public void erroAoAdicionarGeneroNuloTest(){

    }

    @Test
    public void erroAoAdicionarGeneroComDescricaoNulaTest(){

    }

    @Test
    public void erroAoAdicionarGeneroComDescricaoVaziaTest(){

    }

    @Test
    public void removerGeneroCorretamente(){

    }


}
