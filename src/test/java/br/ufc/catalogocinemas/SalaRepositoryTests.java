package br.ufc.catalogocinemas;

import br.ufc.catalogocinemas.enums.TipoSala;
import br.ufc.catalogocinemas.model.Sala;
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
public class SalaRepositoryTests {

    @Autowired
    SalaRepository repository;

    Sala salaTest;

    @Before
    public void setUp(){
        salaTest = new Sala("Sala 03", TipoSala.SALA_3D, null, 800);
    }

    @Test
    public void salvarSalaCorretamenteTest(){
        Sala salaResponse = repository.save(salaTest);

        Assert.assertNotNull(salaResponse);
    }

}
