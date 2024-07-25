package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.categorias.Categoria;
import com.example.padelparatodos.model.Pareja;
import com.example.padelparatodos.model.torneo.Torneo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Partido {
    private int setsAJugar;
    private LocalDate date;
    private PartidoState partidoState;
    private Torneo torneo;
    private Pareja pareja1;
    private Pareja pareja2;
    @Getter
    private HashMap<Pareja, Integer> resultado;
    private Set setEnCurso;

    public Partido(Torneo torneo, Pareja pareja1, Pareja pareja2, int setsAJugar) {
        this.torneo = torneo;
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.partidoState = new PartidoSinIniciar(this);
        this.date = LocalDate.now();
        this.setsAJugar = (int) Math.ceil(setsAJugar / 2.0);
    }
    public void changeState (PartidoState partidoState) {
        this.partidoState = partidoState;
    }
    public PartidoState getState (){
        return this.partidoState;
    }

    public void iniciarPartido (){
        this.partidoState = new PartidoEnCurso(this);
    }
    public void finalizarPartido (){
        this.partidoState = new PartidoFinalizado(this);
    }
    public HashMap<Pareja, Integer> iniciarSet () {
        Set setEnCurso = new Set(this.getPareja1(), this.getPareja2());
        this.setSetEnCurso(setEnCurso);
        HashMap<Pareja, Integer> resultado = new HashMap<>();
        resultado.put(this.pareja1, setEnCurso.getGamesPareja1());
        resultado.put(this.pareja1, setEnCurso.getGamesPareja2());
        return resultado;
    }
    public void sumarPunto (Pareja pareja) {
        this.setEnCurso.sumarPunto(pareja);
        if (this.setEnCurso.isSetWon()) {
            setEnCurso.sumarPunto(pareja);
            resultado.put(this.pareja1, setEnCurso.getGamesPareja1());
            resultado.put(this.pareja2, setEnCurso.getGamesPareja2());
        }
    }
    public boolean isPartidoWon (){
        if (this.resultado.get(this.pareja1) == setsAJugar ||
                this.resultado.get(this.pareja2) == setsAJugar) {
            return true;
        } else return false;
    }
    public Pareja whoWonPartido () {
        if (this.resultado.get(this.pareja1) == setsAJugar) {
            return this.getPareja1();
        } else return this.getPareja2();
    }
    public void setResultado (PartidoDTO partidoDTO) {
        this.resultado.put(partidoDTO.getPareja1(), partidoDTO.getSetsPareja1());
        this.resultado.put(partidoDTO.getPareja2(), partidoDTO.getSetsPareja2());
    }
}
