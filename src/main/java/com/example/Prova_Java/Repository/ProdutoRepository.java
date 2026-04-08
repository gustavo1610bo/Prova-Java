package com.example.Prova_Java.Repository;

import com.example.Prova_Java.Models.ProdutoModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModels, Long> {
}
