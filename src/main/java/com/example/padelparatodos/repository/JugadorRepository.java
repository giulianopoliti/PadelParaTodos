package com.example.padelparatodos.repository;

import com.example.padelparatodos.entity.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository <JugadorEntity, Integer> {
    JugadorEntity findByNameAndLastName(String name, String lastName);
}
