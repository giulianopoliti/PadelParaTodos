package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.Pareja;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Set {
    private Pareja pareja1;
    private Pareja pareja2;
    private int gamesPareja1;
    private int gamesPareja2;
    private Game gameEnCurso;

    public Set (Pareja pareja1, Pareja pareja2) {
        this.gamesPareja1 = 0;
        this.gamesPareja2 = 0;
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.gameEnCurso = new Game(this.pareja1,this.pareja2);
    }
    public boolean isSetWon() {
        if ((gamesPareja1 >= 6 && gamesPareja1 - gamesPareja2 >= 2) ||
                (gamesPareja2 >= 6 && gamesPareja2 - gamesPareja1 >= 2)) {
            return true;
        } else if (gamesPareja1 == 7 || gamesPareja2 == 7) {
            return true;
        } else return false;
    }
    public Pareja whoWonSet() {
        if ((gamesPareja1 >= 6 && gamesPareja1 - gamesPareja2 >= 2) || gamesPareja1 == 7){
            return this.getPareja1();
        } else if ((gamesPareja2 >= 6 && gamesPareja2 - gamesPareja1 >= 2) || gamesPareja2 == 7) {
            return this.getPareja2();
        } else {
            throw new RuntimeException("Hay algun error en whoWonSet");
        }
    }
    public void sumarGame (Pareja pareja) {
        Game nuevoGame = new Game(this.pareja1, this.pareja2);
        this.setGameEnCurso(nuevoGame);
        if (pareja.equals(pareja1)) {
            gamesPareja1++;
        } else if (pareja.equals(pareja2)) {
            gamesPareja2++;
        } else {
            System.out.println("Error en sumarGame");
        }
    }
    public void sumarPunto (Pareja pareja) {
        this.gameEnCurso.sumarPunto(pareja);
        if (this.gameEnCurso.gameIsWon()) {
            sumarGame(this.gameEnCurso.whoWonGame());
        }
    }

}
