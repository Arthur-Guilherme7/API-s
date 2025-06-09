package com.example.rh_tech.Repository;

import com.example.rh_tech.Model.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Long> {
}
