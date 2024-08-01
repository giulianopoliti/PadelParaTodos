package com.example.padelparatodos.model;

import com.example.padelparatodos.model.partido.Partido;
import com.example.padelparatodos.model.partido.PartidoDTO;
import com.example.padelparatodos.model.torneo.Torneo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Zona {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Torneo torneo;
    private HashMap <Integer, Pareja> jugadores = new HashMap<>();
    private List<Partido> partidos = new ArrayList<>();
    public Zona(Torneo torneo) {
        this.jugadores = new HashMap<>();
        this.torneo = torneo;
    }
    public Zona (){}
    public Partido crearPartido (Pareja pareja1, Pareja pareja2, int setsAJugar) {
        return new Partido(this.torneo,pareja1,pareja2, setsAJugar);
    }
    public void setearPartidos (List<Partido> partidosTerminados) {
        this.partidos = partidosTerminados;
    }

    public void setearPartido (PartidoDTO partidoDTO) {
        for (Partido partido : partidos) {
            if (partido.getPareja1().equals(partidoDTO.getPareja1()) &&
                    partido.getPareja2().equals(partidoDTO.getPareja2())) {
                partido.setResultado(partidoDTO);
            }
        }
    }
}
