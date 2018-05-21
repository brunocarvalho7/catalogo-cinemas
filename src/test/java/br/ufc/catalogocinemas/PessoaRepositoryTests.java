package br.ufc.catalogocinemas;

import br.ufc.catalogocinemas.model.Ator;
import br.ufc.catalogocinemas.repository.AtorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaRepositoryTests {

    @Autowired
    AtorRepository repository;

    @Test
    public void adicionarComSucessoTest(){
        Ator ator = new Ator("Leonardo DiCaprio", "Teste qualquer");

        Ator atorResponse = repository.save(ator);

        Assert.assertNotNull(atorResponse);
    }

    @Test
    public void atualizarComSucessoTest(){
        Ator ator = new Ator("Leonardo DiCaprio", "Teste qualquer");

        Ator atorResponse = repository.save(ator);

        atorResponse.setSobre("Ator muito bom");

        Assert.assertNotNull(repository.save(atorResponse));
    }

    @Test
    public void removerComSucessoTest(){
        Ator ator = new Ator("Leonardo DiCapriaaao", "Teste qualquer");

        Ator atorResponse = repository.save(ator);

        System.out.println(atorResponse.getId());

        repository.delete(atorResponse.getId());

        System.out.println(atorResponse.getId());

        Assert.assertNull(repository.findOne(atorResponse.getId()));
    }

    @Test
    public void buscarComSucessoTest(){
        System.out.println(repository);

     //   repository.findOne(18);

       // System.out.println(ator);

        Assert.assertNotNull(repository.findOne(18));
    }

}
