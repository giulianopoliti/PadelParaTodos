package com.example.padelparatodos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jugador")
public class JugadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private int score;
    private int age;

    @ManyToOne
    @JoinColumn(name = "categoria_Id")
    private CategoriaEntity categoriaEntity;
}
