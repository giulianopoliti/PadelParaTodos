package com.example.padelparatodos.repository;

import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.entity.PartidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PartidoRepository extends JpaRepository<PartidoEntity,Integer> {
    @Query("SELECT p FROM PartidoEntity p WHERE p.pareja1.jugador1 = :jugador OR p.pareja1.jugador2 = :jugador " +
            "OR p.pareja2.jugador1 = :jugador OR p.pareja2.jugador2 = :jugador")
    List<PartidoEntity> findByPlayer(@Param("jugador") JugadorEntity jugador);
}
