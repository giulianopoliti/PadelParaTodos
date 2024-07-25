package com.example.padelparatodos.entity;

import com.example.padelparatodos.model.Pareja;
import com.example.padelparatodos.model.torneo.Torneo;
import jakarta.persistence.*;

@Entity
public class PartidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "pareja_Id")
    private ParejaEntity pareja1;
    @ManyToOne
    @JoinColumn(name = "pareja_Id")
    private ParejaEntity pareja2;
    @ManyToOne
    @JoinColumn(name = "pareja_Id")
    private ParejaEntity ganador;
    @ManyToOne
    @JoinColumn(name = "torneo_Id")
    private TorneoEntity torneoEntity;

}
