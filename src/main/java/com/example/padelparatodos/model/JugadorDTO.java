package com.example.padelparatodos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JugadorDTO {
    private int id;
    private String name;
    private String lastName;

    public JugadorDTO(int id,String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
