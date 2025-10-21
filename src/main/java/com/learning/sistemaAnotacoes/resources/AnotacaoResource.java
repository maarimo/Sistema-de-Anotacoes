package com.learning.sistemaAnotacoes.resources;

import com.learning.sistemaAnotacoes.entities.Anotacao;
import com.learning.sistemaAnotacoes.services.AnotacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/anotacoes")
public class AnotacaoResource {

    private final AnotacaoService service;

    public AnotacaoResource(AnotacaoService service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<Anotacao>> listar(){
        List<Anotacao> list = service.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anotacao> buscar(@PathVariable Long id){
        Anotacao a = service.buscarPorId(id);
        return ResponseEntity.ok(a);
    }

    @PostMapping
    public ResponseEntity<Anotacao> criar(@Valid @RequestBody Anotacao anotacao){
        Anotacao criada = service.criar(anotacao);
        URI uri =URI.create("/anotacoes/" + criada.getId());
        return ResponseEntity.created(uri).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anotacao> atualizar(@PathVariable Long id, @Valid @RequestBody Anotacao anotacao){
        Anotacao atualiazada = service.atualizar(id, anotacao);
        return ResponseEntity.ok(atualiazada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/favoritas")
    public ResponseEntity<List<Anotacao>> listarFavoritas(){
        List<Anotacao> list = service.listarFavoritas();
        return ResponseEntity.ok(list);
    }
}
