package com.example.padelparatodos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Pareja")
@Getter
@Setter
public class ParejaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "jugador1_id")
    private JugadorEntity jugador1;
    @ManyToOne
    @JoinColumn(name = "jugador2_id")
    private JugadorEntity jugador2;
}
