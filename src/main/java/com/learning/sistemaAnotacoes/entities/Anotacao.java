package com.learning.sistemaAnotacoes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "anotacoes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo é obrigatorio!")
    private String titulo;

    @NotBlank(message = "O conteudo é obrigatorio!")
    private String conteudo;

    private Boolean favorita = false;
    private LocalDateTime dataCriacao;

    @PrePersist //preenche data automaticamente na criação
    public void prePersist(){
        this.dataCriacao = LocalDateTime.now();
    }

}
