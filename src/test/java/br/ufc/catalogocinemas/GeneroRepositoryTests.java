package br.ufc.catalogocinemas;

import br.ufc.catalogocinemas.model.Genero;
import br.ufc.catalogocinemas.repository.GeneroRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroRepositoryTests {

    @Autowired
    GeneroRepository repository;

    @Test
    public void adicionarGeneroTest(){
        Genero genero = new Genero("Ação");

        Assert.assertNotNull(repository.save(genero));
    }

}
