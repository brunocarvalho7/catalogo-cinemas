package br.ufc.catalogocinemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoCinemasApplication {

	public static void main(String[] args) {
		/*
		1º-> EXECUTAR A APLICAÇÃO E O BANCO DE DADOS SERÁ CRIADO AUTOMATICAMENTE
		2º -> EXECUTAR o teste que está na classe InsertsNoBancoDeDados, e isso criará as chaves primarias necessárias
		 */

		SpringApplication.run(CatalogoCinemasApplication.class, args);
	}
}
