package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;
import com.example.padelparatodos.model.ParejaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PartidoDTO {
    private ParejaDTO pareja1;
    private ParejaDTO pareja2;
    private List<Integer> setsPareja1;
    private List<Integer> setsPareja2;
    private PartidoEnum partidoState;
    public PartidoDTO(ParejaDTO pareja1, ParejaDTO pareja2, int setsPareja1, int setsPareja2, PartidoEnum partidoState) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.setsPareja1 = new ArrayList<>();
        this.setsPareja2 = new ArrayList<>();
        this.partidoState = partidoState;
    }
    public PartidoDTO(ParejaDTO pareja1, ParejaDTO pareja2, int setsPareja1, int setsPareja2) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.setsPareja1 = new ArrayList<>();
        this.setsPareja2 = new ArrayList<>();
    }
    public PartidoDTO(ParejaDTO pareja1, ParejaDTO pareja2) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
    }

}
