package com.example.padelparatodos.model;

import com.example.padelparatodos.model.JugadorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ParejaDTO {
    JugadorDTO jugadorDTO1;
    JugadorDTO jugadorDTO2;

    public ParejaDTO(JugadorDTO jugadorDTO1, JugadorDTO jugadorDTO2) {
        this.jugadorDTO1 = jugadorDTO1;
        this.jugadorDTO2 = jugadorDTO2;
    }
}
