package br.ufc.catalogocinemas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.ufc.catalogocinemas.controller.CinemaController;
import br.ufc.catalogocinemas.model.Cinema;
import br.ufc.catalogocinemas.model.Genero;
import br.ufc.catalogocinemas.utils.DatabaseUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaControllerTests {
	
	@Autowired
	private CinemaController controller;
	
	@Autowired
	DatabaseUtils databaseutils;
	
	@Test
    public void adicionarCinemaCorretamenteTest(){
        Cinema cinema = new Cinema("Pinheiro Fortaleza", "Algum lugar de fortaleza", "Fortaleza");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNotNull(cinemaResponse);
    }

    @Test
    public void erroAoAdicionarCinemaNuloTest(){
        Cinema cinema = null;

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }

    @Test
    public void erroAoAdicionarCinemaComNomeNuloTest(){
        Cinema cinema = new Cinema(null, "Avenida da Universidade", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    public void erroAoAdicionarCinemaComCidadeNulaTest(){
        Cinema cinema = new Cinema("Cinema Pinheiro", "Avenida da Universidade", null);

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    public void erroAoAdicionarCinemaComEnderecoNuloTest(){
        Cinema cinema = new Cinema("Cinema Pinheiro", null, "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    public void erroAoAdicionarCinemaComNomeEEnderecoNulosTest(){
        Cinema cinema = new Cinema(null, null, "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    public void erroAoAdicionarCinemaComNomeECidadeNulosTest(){
        Cinema cinema = new Cinema(null, "Avenida da Universidade", null);

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    public void erroAoAdicionarCinemaComEnderecoECidadeNulosTest(){
        Cinema cinema = new Cinema("Cinema Pinheiro", null, null);

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    public void erroAoAdicionarCinemaComEnderecoEnderecoECidadeNulosTest(){
        Cinema cinema = new Cinema(null, null, null);

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }

    @Test
    public void erroAoAdicionarCinemaComNomeVazioTest(){
    	Cinema cinema = new Cinema("", "Avenida da Universidade", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComEnderecoVazioTest(){
    	Cinema cinema = new Cinema("Cinema Pinheiro", "", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComCidadeVaziaTest(){
    	Cinema cinema = new Cinema("Cinema Pinheiro", "Avenida da Universidade", "");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComNomeEEnderecoVaziosTest(){
    	Cinema cinema = new Cinema("", "", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComNomeECidadeVaziosTest(){
    	Cinema cinema = new Cinema("", "Avenida da Universidade", "");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComEnderecoECidadeVaziosTest(){
    	Cinema cinema = new Cinema("Cinema Pinheiro", "", "");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComNomeEnderecoECidadeVaziosTest(){
    	Cinema cinema = new Cinema("", "", "");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComNomeSoComEspacosTest(){
        Cinema cinema = new Cinema("  ", "Avenida da Universidade", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("genero");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarFilmeComNomeSoComEspacosTest(){
        Cinema cinema = new Cinema("  ", "Avenida da Universidade", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("genero");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComCidadeSoComEspacosTest(){
        Cinema cinema = new Cinema("Cinema Pinheiro", "Avenida da Universidade", "  ");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("genero");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComNomeEEnderecoSoComEspacosTest(){
        Cinema cinema = new Cinema("  ", "  ", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("genero");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComNomeECidadeSoComEspacosTest(){
        Cinema cinema = new Cinema("  ", "Avenida da Universidade", "  ");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("genero");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAdicionarCinemaComNomeEnderecoECidadeSoComEspacosTest(){
        Cinema cinema = new Cinema("  ", "  ", "  ");

        Cinema cinemaResponse = (Cinema) controller.addCinema(cinema).getModel().get("genero");

        Assert.assertNull(cinemaResponse);
    }
    
    
    @Test
    public void removerCinemaCorretamente(){
        Cinema cinema = new Cinema("Pinheiro Fortaleza", "Algum lugar de fortaleza", "Fortaleza");

        controller.addCinema(cinema);

        Cinema cinemaResponse = (Cinema) controller.removerCinema(cinema.getId()).getModel().get("cinemas");

        Assert.assertNotNull(cinemaResponse);
    }

    @Test
    public void ErroAoRemoverCinemaNaoCadastrado(){
        Cinema cinemaResponse = (Cinema) controller.removerCinema(9999).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }

    @Test
    public void erroAoRemoverCinemaComIdNegativo(){
        Cinema cinemaResponse = (Cinema) controller.removerCinema(-50).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }

    @Test
    public void atualizarCinemaCorretamenteTest(){
        Cinema cinema = new Cinema("Pinheiro Fortaleza", "Algum lugar de fortaleza", "Fortaleza");

        controller.addCinema(cinema);

        cinema.setNome("UCI Iguatemi");
        cinema.setEndereco("Avenida 2");
        cinema.setCidade("Quixadá");
        
        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNotNull(cinemaResponse);
    }

    @Test
    public void erroAoAtualizarCinemaNuloTest(){
        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(null).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }

    @Test
    public void erroAoAtualizarCinemaComNomeNuloTest(){
        Cinema cinema = new Cinema(null, "Avenida da Universidade", "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAtualizarCinemaComEnderecoNuloTest(){
        Cinema cinema = new Cinema("Cinema Pinheiro", null, "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAtualizarCinemaComCidadeNulaTest(){
        Cinema cinema = new Cinema("Cinema Pinheiro", "Avenida da Universidade", null);

        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAtualizarCinemaComNomeEEnderecoNulosTest(){
        Cinema cinema = new Cinema(null, null, "Quixadá");

        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAtualizarCinemaComNomeECidadeNulosTest(){
        Cinema cinema = new Cinema(null, "Avenida da Universidade", null);

        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAtualizarCinemaComEnderecoECidadeNulosTest(){
        Cinema cinema = new Cinema("Cinema Pinheiro", null, null);

        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }
    
    @Test
    public void erroAoAtualizarCinemaComNomeEnderecoECidadeNulosTest(){
        Cinema cinema = new Cinema(null, null, null);

        Cinema cinemaResponse = (Cinema) controller.atualizarCinema(cinema).getModel().get("cinema");

        Assert.assertNull(cinemaResponse);
    }

    @Test
    public void erroAoAtualizarGeneroComDescricaoVaziaTest(){
        Genero genero = new Genero("");

        Genero generoResponse = (Genero) controller.atualizarGenero(genero).getModel().get("genero");

        Assert.assertNull(generoResponse);
    }
    @Test
    public void erroAoAtualizarGeneroComDescricaoSoComEspacosTest(){
        Genero genero = new Genero("  ");

        Genero generoResponse = (Genero) controller.atualizarGenero(genero).getModel().get("genero");

        Assert.assertNull(generoResponse);
    }

    @Test
    public void erroAoAtualizarGeneroComIdNaoCadastradoTest(){
        Genero genero = new Genero("  ");

        genero.setId(90);

        Genero generoResponse = (Genero) controller.atualizarGenero(genero).getModel().get("genero");

        Assert.assertNull(generoResponse);
    }

    @Test
    public void erroAoAtualizarGeneroComIdNegativoTest(){
        Genero genero = new Genero("Ação");
        genero.setId(-500);

        Genero generoResponse = (Genero) controller.atualizarGenero(genero).getModel().get("genero");

        Assert.assertNull(generoResponse);
    }

    @Test
    public void buscarTodosOsGeneros(){
        databaseUtils.deleteAllGeneros();

        controller.addGenero(new Genero("Ação"));
        controller.addGenero(new Genero("Drama"));
        controller.addGenero(new Genero("Comédia"));

        List<Genero> generos = (List<Genero>) controller.getAllGeneros().getModel().get("generos");

        Assert.assertEquals(3, generos.size());
    }

    @Test
    public void erroAoBuscarTodosOsGeneros(){
        databaseUtils.deleteAllGeneros();

        controller.addGenero(new Genero("Ação"));
        controller.addGenero(new Genero("Drama"));
        controller.addGenero(new Genero("Comédia"));

        List<Genero> generos = (List<Genero>) controller.getAllGeneros().getModel().get("generos");

        Assert.assertNotEquals(4, generos.size());
    }
	
}
