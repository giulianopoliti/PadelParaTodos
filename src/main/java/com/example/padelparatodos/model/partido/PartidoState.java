package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;

import java.util.HashMap;
import java.util.List;

public abstract class PartidoState {
    Partido partido;
    PartidoState(Partido partido) {
        this.partido = partido;
    }
    public abstract String planificarMesa(String mesa);
    public abstract String iniciar();
    public abstract HashMap<Pareja, List<Integer>> finalizar();
}