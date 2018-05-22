package br.ufc.catalogocinemas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.ufc.catalogocinemas.model.Genero;
import br.ufc.catalogocinemas.service.CinemaService;
import br.ufc.catalogocinemas.utils.DatabaseUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaServiceTests {

	@Autowired
	private CinemaService service;
	
    @Autowired
    DatabaseUtils databaseUtils;

    @Test
    public void adicionarCinemaTest(){
        Genero genero = new Genero("Ação");

        Assert.assertNotNull(service.addGenero(genero));
    }

	
}
