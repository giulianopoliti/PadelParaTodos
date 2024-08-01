package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PartidoDTO {
    private Pareja pareja1;
    private Pareja pareja2;
    private List<Integer> setsPareja1;
    private List<Integer> setsPareja2;

    public PartidoDTO(Pareja pareja1, Pareja pareja2, int setsPareja1, int setsPareja2) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.setsPareja1 = new ArrayList<>();
        this.setsPareja2 = new ArrayList<>();
    }
}
