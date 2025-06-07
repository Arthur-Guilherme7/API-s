package com.example.APIescola.Repository;

import com.example.APIescola.Model.AlunosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {

}
