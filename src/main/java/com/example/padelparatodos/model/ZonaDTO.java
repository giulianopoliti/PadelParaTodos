package com.example.padelparatodos.model;

import com.example.padelparatodos.model.partido.PartidoDTO;
import com.example.padelparatodos.model.torneo.TorneoDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ZonaDTO {
    private static int nextId = 1;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private List<PartidoDTO> partidos;
    public ZonaDTO () {
        this.id = nextId++;
    }
}
