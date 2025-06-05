package com.example.bancoImagens.Repository;

import com.example.bancoImagens.Model.ImagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<ImagemModel, Long> {
}
