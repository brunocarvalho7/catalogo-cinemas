package br.ufc.catalogocinemas.repository;

import br.ufc.catalogocinemas.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{

    /*    Listar todas as sessões cuja o seu inicio seja maior ou igual a dataInicio(parâmetro da função)
      e que o fim seja menor igual a dataFim(parâmetro da função)
*/
    List<Sessao> findByDataInicioGreaterThanEqualAndDataFimLessThanEqual(LocalDate dataInicio, LocalDate dataFim);

    List<Sessao> findByFilme_id(int idFilme);

    List<Sessao> findBySala_id(int idSala);


}
