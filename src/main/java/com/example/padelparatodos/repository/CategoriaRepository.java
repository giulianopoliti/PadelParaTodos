package com.example.padelparatodos.repository;

import com.example.padelparatodos.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    @Query("SELECT c FROM CategoriaEntity c WHERE :puntos BETWEEN c.rangoInferior AND c.rangoSuperior")
    Optional<CategoriaEntity> findByPuntosInRange(@Param("puntos") int puntos);
}
