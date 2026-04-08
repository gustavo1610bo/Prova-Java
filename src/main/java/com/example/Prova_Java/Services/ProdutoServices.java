package com.example.Prova_Java.Services;

import com.example.Prova_Java.Models.ProdutoModels;
import com.example.Prova_Java.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository produtorepository;

    public ProdutoModels adicionar(ProdutoModels produtoModels){
        return produtorepository.save(produtoModels);
    }

    public List<ProdutoModels>buscaTudo(){
        return produtorepository.findAll();
    }

    public ProdutoModels buscaId(Long id){
        return produtorepository.findById(id).orElse(null);
    }

    public ProdutoModels atualizar(Long id, ProdutoModels produtoModels){
        ProdutoModels atualizado = produtorepository.findById(id).orElse(null);
        atualizado.setNome(produtoModels.getNome());
        atualizado.setDescricao(produtoModels.getDescricao());
        atualizado.setPreco(produtoModels.getPreco());
        atualizado.setStatus(produtoModels.getStatus());
        return produtorepository.save(atualizado);
    }

    public void deletar(Long id){
        produtorepository.deleteById(id);
    }
}
