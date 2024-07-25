package com.example.padelparatodos.model;

import com.example.padelparatodos.model.partido.Partido;
import com.example.padelparatodos.model.partido.PartidoDTO;
import com.example.padelparatodos.model.torneo.Torneo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Zona {
    private Torneo torneo;
    private HashMap <Integer, Pareja> jugadores = new HashMap<>();
    private List<PartidoDTO> partidos = new ArrayList<>();
    public Zona(Torneo torneo) {
        this.jugadores = new HashMap<>();
        this.torneo = torneo;
    }
    public Zona (){}
    public Partido crearPartido (Pareja pareja1, Pareja pareja2, int setsAJugar) {
        return new Partido(this.torneo,pareja1,pareja2, setsAJugar);
    }
    public void setearPartidos (List<PartidoDTO> partidosTerminados) {
        this.partidos = partidosTerminados;
    }
    /*public void sumarPunto (Partido partido, Pareja pareja) {
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).equals(partido)) {
                partidos.get(i).sumarPunto(pareja);
                return;
            }
        }
    }*/
    public void setearPartido (PartidoDTO partidoDTO) {
        for (PartidoDTO partido : partidos) {
            if (partido.getPareja1().equals(partidoDTO.getPareja1()) &&
                    partido.getPareja2().equals(partidoDTO.getPareja2())) {
                //
                //partidos.put(entry.getKey(), )
            }
        }
    }
}
