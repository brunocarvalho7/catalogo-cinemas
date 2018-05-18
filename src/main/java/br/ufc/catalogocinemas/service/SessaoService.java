package br.ufc.catalogocinemas.service;

import br.ufc.catalogocinemas.model.Sessao;
import br.ufc.catalogocinemas.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository repository;

    public List<Sessao> todas(){
       return repository.findAll();
    }

    public List<Sessao> todasPorData(LocalDate dataInicio, LocalDate dataFim){
        return repository.findByDataInicioGreaterThanEqualAndDataFimLessThanEqual(dataInicio, dataFim);
    }

    public List<Sessao> todosPorFilme(int id){
        return repository.findByFilme_id(id);
    }

    public Sessao getSessaoPorId(int id){
        return repository.findOne(Integer.valueOf(id));
    }

    public Sessao atualizarSessao(Sessao sessao){
        return repository.save(sessao);
    }

    public Sessao addSessao(Sessao sessao){

        return repository.save(sessao);
    }

    public Sessao removerSessao(int id){
        Sessao s = this.getSessaoPorId(id);

        if(s != null){
            repository.delete(Integer.valueOf(id));
            return s;
        }

        return null;
    }

    public List<Sessao> getSessoesPorSala(int id){
        return repository.findBySala_id(id);
    }

}
