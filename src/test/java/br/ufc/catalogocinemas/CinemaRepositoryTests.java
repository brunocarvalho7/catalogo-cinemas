package br.ufc.catalogocinemas;

import br.ufc.catalogocinemas.model.Cinema;
import br.ufc.catalogocinemas.model.Sala;
import br.ufc.catalogocinemas.repository.CinemaRepository;
import br.ufc.catalogocinemas.repository.SalaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaRepositoryTests {

    @Autowired
    CinemaRepository repository;

    @Autowired
    SalaRepository salaRepository;

    Cinema cinemaTest;

    @Before
    public void setUp(){
        cinemaTest = new Cinema("Pinheiro Fortaleza", "Algum lugar de fortaleza", "Fortaleza");
    }

    @Test
    public void salvarCinemaCorretamenteTest(){
        Cinema cinemaResponse = repository.save(cinemaTest);

        Assert.assertNotNull(cinemaResponse);
    }

    @Test
    public void vincularSalaComSucessoTest(){
        Sala sala = salaRepository.findOne(1);
        Cinema cinema = repository.findOne(1);

        cinema.vincularSala(sala);
        Cinema cinemaResponse = repository.save(cinema);
        Sala salaResponse = salaRepository.save(sala);

        Assert.assertNotNull(cinemaResponse);
        Assert.assertNotNull(salaResponse);
    }

    @Test
    public void desvincularSalaComSucessoTest(){
        Sala sala = salaRepository.findOne(1);
        Cinema cinema = repository.findOne(1);

        cinema.desvincularSala(sala);
        Cinema cinemaResponse = repository.save(cinema);
        Sala salaResponse = salaRepository.save(sala);

        Assert.assertNotNull(cinemaResponse);
        Assert.assertNotNull(salaResponse);
    }
}
