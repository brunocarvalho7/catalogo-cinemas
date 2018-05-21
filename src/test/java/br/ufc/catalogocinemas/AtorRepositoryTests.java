package br.ufc.catalogocinemas;

import br.ufc.catalogocinemas.model.Ator;
import br.ufc.catalogocinemas.model.Filme;
import br.ufc.catalogocinemas.repository.AtorRepository;
import br.ufc.catalogocinemas.repository.FilmeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional()
@Rollback(value = false)
public class AtorRepositoryTests {

    @Autowired
    private AtorRepository atorRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Test
    public void adicionarAtor(){
        Filme filme = new Filme("Filme qualquer 45", "Sinpose qualquer", 150, null);

        Ator ator = new Ator("Bruno Sobrinho445", "Qualquer coisa");

        ator.addFilme(filme);

        Filme filmeResponse = filmeRepository.save(filme);

        Ator atorResponse = atorRepository.save(ator);

        Assert.assertNotNull(atorResponse);
    }

    @Test
    public void vincularAtor(){
        Filme filme = filmeRepository.findOne(15);
        Ator ator = atorRepository.findOne(24);

        ator.addFilme(filme);

        Ator atorResponse = atorRepository.save(ator);
        Assert.assertNotNull(atorResponse);
    }

    @Test
    public void desvincularAtor(){
        Filme filme = filmeRepository.findOne(15);
        Ator ator = atorRepository.findOne(24);

        ator.removerFilme(filme);

        Ator atorResponse = atorRepository.save(ator);
        Assert.assertNotNull(atorResponse);
    }
}
