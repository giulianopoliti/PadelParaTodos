package com.example.padelparatodos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JugadorDTO {
    private String name;
    private String lastName;
    private int idCategoria;

    public JugadorDTO(String name, String lastName, int idCategoria) {
        this.name = name;
        this.lastName = lastName;
        this.idCategoria = idCategoria;
    }
}
