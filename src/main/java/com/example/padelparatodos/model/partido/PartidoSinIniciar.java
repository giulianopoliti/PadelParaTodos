package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;

import java.util.HashMap;
import java.util.List;

public class PartidoSinIniciar extends PartidoState{

    public PartidoSinIniciar(Partido partido) {
        super(partido);
    }

    @Override
    public String planificarMesa(String mesa) {
        return "El partido es en mesa "+ mesa;
    }

    @Override
    public String iniciar() {
        return "Iniciando...";
    }

    @Override
    public HashMap<Pareja, List<Integer>> finalizar() {
        return null;
    }
}
