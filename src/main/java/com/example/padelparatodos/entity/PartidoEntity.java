package com.example.padelparatodos.entity;

import com.example.padelparatodos.model.Pareja;
import com.example.padelparatodos.model.torneo.Torneo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PartidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Pareja pareja1;
    private Pareja pareja2;

    private TorneoEntity torneoEntity;
}
