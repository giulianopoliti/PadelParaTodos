package com.example.padelparatodos.model;

import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.model.Jugador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pareja {
    private JugadorEntity jugador1;
    private JugadorEntity jugador2;

    public Pareja(JugadorEntity jugador1, JugadorEntity jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
}
