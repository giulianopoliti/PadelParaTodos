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
    private List<Pareja> jugadores;
    private List<Partido> partidos = new ArrayList<>();
    private int sizeOfMatchs;
    public Zona(int sizeOfMatchs) {
        this.jugadores = new ArrayList<>();
        this.sizeOfMatchs = sizeOfMatchs;
    }
    public Partido crearPartido (Pareja pareja1, Pareja pareja2, int setsAJugar) {
        return new Partido(pareja1,pareja2, setsAJugar);
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
    public void createMatchs () {
        if (this.jugadores.size() == 3) {
            Partido partido1 = new Partido(this.jugadores.get(0), this.jugadores.get(2), this.sizeOfMatchs);
            Partido partido2 = new Partido(this.jugadores.get(0), this.jugadores.get(1), this.sizeOfMatchs);
            Partido partido3 = new Partido(this.jugadores.get(1), this.jugadores.get(2), this.sizeOfMatchs);
            this.partidos.add(partido1);
            this.partidos.add(partido2);
            this.partidos.add(partido3);
        }
        if (this.jugadores.size() == 4) {
            Partido partido1 = new Partido(this.jugadores.get(0), this.jugadores.get(2), this.sizeOfMatchs);
            Partido partido2 = new Partido(this.jugadores.get(1), this.jugadores.get(3), this.sizeOfMatchs);
            Partido partido3 = new Partido(this.jugadores.get(0), this.jugadores.get(1), this.sizeOfMatchs);
            Partido partido4 = new Partido(this.jugadores.get(2), this.jugadores.get(3), this.sizeOfMatchs);
            Partido partido5 = new Partido(this.jugadores.get(0), this.jugadores.get(3), this.sizeOfMatchs);
            Partido partido6 = new Partido(this.jugadores.get(1), this.jugadores.get(2), this.sizeOfMatchs);
            this.partidos.add(partido1);
            this.partidos.add(partido2);
            this.partidos.add(partido3);
            this.partidos.add(partido4);
            this.partidos.add(partido5);
            this.partidos.add(partido6);
        }
    }
}
