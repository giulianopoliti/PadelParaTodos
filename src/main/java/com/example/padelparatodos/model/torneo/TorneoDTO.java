package com.example.padelparatodos.model.torneo;

import com.example.padelparatodos.model.Pareja;

import java.util.HashMap;

public class TorneoDTO {
    private HashMap<Integer, Pareja> parejas;
    private Integer idCategoria;

    // Getters and setters
    public HashMap<Integer, Pareja> getParejas() {
        return parejas;
    }

    public void setParejas(HashMap<Integer, Pareja> parejas) {
        this.parejas = parejas;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
