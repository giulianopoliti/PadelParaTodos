package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;

import java.util.HashMap;
import java.util.List;

public class PartidoEnCurso extends PartidoState {
    PartidoEnCurso(Partido partido) {
        super(partido);
    }

    @Override
    public String planificarMesa(String mesa) {
        return null;
    }

    @Override
    public String iniciar() {
        return null;
    }
    @Override
    public HashMap<Pareja, List<Integer>> finalizar() {
        return null;
    }

    public void sumar(){}

}
