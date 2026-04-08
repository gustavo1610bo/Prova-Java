package com.example.Prova_Java.Controller;


import com.example.Prova_Java.Models.ProdutoModels;
import com.example.Prova_Java.Services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServices produtoServices;

    @PostMapping
    public ResponseEntity<ProdutoModels> adiciona(@RequestBody ProdutoModels produtoModels){
        ProdutoModels produto = produtoServices.adicionar(produtoModels);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModels>>buscaTudo(){
        List<ProdutoModels> request = produtoServices.buscaTudo();
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModels>buscaId(@PathVariable Long id){
        ProdutoModels produto = produtoServices.buscaId(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModels>atualiza(@PathVariable Long id, @RequestBody ProdutoModels produtoModels){
        ProdutoModels atualizado = produtoServices.atualizar(id, produtoModels);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoModels>deletar(@PathVariable Long id){
        produtoServices.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
