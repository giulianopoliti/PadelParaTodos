package com.example.padelparatodos.model;

import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.model.Jugador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pareja {
    private Jugador jugador1;
    private Jugador jugador2;

    public Pareja(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    public ParejaDTO toDTO () {
        ParejaDTO parejaDTO = new ParejaDTO(this.getJugador1().jugadorToDTO(), this.getJugador2().jugadorToDTO());
        return parejaDTO;
    }
}
