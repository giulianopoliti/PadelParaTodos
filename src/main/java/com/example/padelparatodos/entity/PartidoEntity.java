package com.example.padelparatodos.entity;

import com.example.padelparatodos.model.Pareja;
import com.example.padelparatodos.model.torneo.Torneo;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Partido")
public class PartidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pareja1_id")
    private ParejaEntity pareja1;

    @ManyToOne
    @JoinColumn(name = "pareja2_id")
    private ParejaEntity pareja2;

    @ManyToOne
    @JoinColumn
    private ParejaEntity ganador;

    @ManyToOne
    @JoinColumn(name = "torneo_Id")
    private TorneoEntity torneoEntity;

    @ElementCollection
    private List<Integer> resultados;

    // Getters y Setters
}
