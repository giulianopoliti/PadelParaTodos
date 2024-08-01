package com.example.padelparatodos.model.partido;

import com.example.padelparatodos.model.ParejaDTO;
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
    private List<Integer> setsPareja1;
    private List<Integer> setsPareja2;
    private Set setEnCurso;
    private Pareja ganador;

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
        List<Integer> setsPareja1 = new ArrayList<>();
        List<Integer> setsPareja2 = new ArrayList<>();
        HashMap<Pareja, List<Integer>> resultado = new HashMap<>();
        resultado.put(this.pareja1, setsPareja1);
        resultado.put(this.pareja2, setsPareja2);
        this.partidoState = new PartidoEnCurso(this);
    }
    public void iniciarSet () {
        setsPareja1.add(0);
        setsPareja2.add(0);
    }
    public void finalizarPartido (){
        this.partidoState = new PartidoFinalizado(this);
    }

    public void sumarPunto (Pareja pareja) {
        this.setEnCurso.sumarPunto(pareja);
        if (this.setEnCurso.isSetWon()) {
            iniciarSet();
        }
    }
    public boolean isPartidoWon (){ // REVEER
        int count1 = 0;
        int count2 = 0;
        if ((setsPareja1.size() == setsAJugar || setsPareja2.size() == setsAJugar) &&
                setEnCurso.isSetWon()) {
            return true;
        } else return false;

    }
    public Pareja whoWonPartido () {
        if (isPartidoWon()) {
            if (setsPareja1.get(setsAJugar) == 7 ||
                    (setsPareja1.get(setsAJugar) == 6 && setsPareja2.get(setsAJugar) <= 4)) {
                return this.pareja1;
            } else return this.pareja2;
        } throw new RuntimeException("Ninguno gano el partido");
    }
    public void setResultado (PartidoDTO partidoDTO) {
        this.setsPareja1 = partidoDTO.getSetsPareja1();
        this.setsPareja2 = partidoDTO.getSetsPareja2();
        if (whoWonPartido().equals(this.pareja1)) {
            this.ganador = this.pareja1;
        } else this.ganador = this.pareja2;
        finalizarPartido();
    }
}
