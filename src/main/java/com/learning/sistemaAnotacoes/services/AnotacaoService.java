package com.learning.sistemaAnotacoes.services;

import com.learning.sistemaAnotacoes.entities.Anotacao;
import com.learning.sistemaAnotacoes.exceptions.ResourceNotFoundException;
import com.learning.sistemaAnotacoes.repositories.AnotacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotacaoService {
    private final AnotacaoRepository repo;

    public AnotacaoService(AnotacaoRepository repo) {this.repo = repo;}

    public List<Anotacao> listar(){
        return repo.findAll();
    }

    public Anotacao buscarPorId(Long id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Anotação não encontrada: " + id));
    }

    public Anotacao criar(Anotacao anotacao){
        return repo.save(anotacao);
    }

    public Anotacao atualizar(Long id, Anotacao anotacao){
        Anotacao existente = buscarPorId(id);

        existente.setTitulo(anotacao.getTitulo());
        existente.setConteudo(anotacao.getConteudo());
        existente.setFavorita(anotacao.getFavorita());

        return repo.save(existente);
    }

    public void deletar(Long id){
        if(!repo.existsById(id)){
            throw new ResourceNotFoundException("Anotação não encontrada: " + id);
        }
        repo.deleteById(id);
    }

    public List<Anotacao> listarFavoritas(){
        return repo.findByFavoritaTrue();
    }
}
