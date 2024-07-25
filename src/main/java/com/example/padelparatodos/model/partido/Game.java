package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Game {
    private Pareja pareja1;
    private Pareja pareja2;
    private int puntosPareja1;
    private int puntosPareja2;
    public Game (Pareja pareja1, Pareja pareja2) {
        this.puntosPareja1 = 0;
        this.puntosPareja2 = 0;
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
    }
    public void sumarPunto(Pareja pareja) {
        if (pareja.equals(pareja1)) {
            if (puntosPareja2 <= 2) {
                puntosPareja1++;
            } else puntosPareja2--;
        } else if (pareja.equals(pareja2)) {
            if (puntosPareja1 <= 2) {
                puntosPareja2++;
            } else puntosPareja1--;
        } else {
            System.out.println("Error en sumarPunto");
        }
    }
    public boolean gameIsWon (){
        if ((puntosPareja1 >= 4 && puntosPareja1 - puntosPareja2 >= 2) ||
                (puntosPareja2 >= 4 && puntosPareja2 - puntosPareja1 >= 2)) {
            return true;
        } else return false;
    }
    public Pareja whoWonGame () {
        if (puntosPareja1 >= 4 && puntosPareja1 - puntosPareja2 >= 2) {
            return this.getPareja1();
        } else return this.getPareja2();
    }
}
