package com.example.padelparatodos.entity;

import jakarta.persistence.*;
@Entity
public class ParejaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "jugador_Id")
    private JugadorEntity jugadorEntity1;
    @ManyToOne
    @JoinColumn(name = "jugador_Id")
    private JugadorEntity jugadorEntity2;
}
