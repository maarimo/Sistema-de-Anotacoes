package com.learning.sistemaAnotacoes.repositories;

import com.learning.sistemaAnotacoes.entities.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
    List<Anotacao> findByFavoritaTrue();
}
