package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidoDTO {
    private Pareja pareja1;
    private Pareja pareja2;
    private int setsPareja1;
    private int setsPareja2;

    public PartidoDTO(Pareja pareja1, Pareja pareja2, int setsPareja1, int setsPareja2) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.setsPareja1 = setsPareja1;
        this.setsPareja2 = setsPareja2;
    }
}
