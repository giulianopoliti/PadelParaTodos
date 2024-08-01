package com.example.padelparatodos.model.torneo;

import com.example.padelparatodos.entity.CategoriaEntity;
import com.example.padelparatodos.model.Zona;
import com.example.padelparatodos.model.Pareja;
import com.example.padelparatodos.model.partido.Partido;
import com.example.padelparatodos.model.partido.PartidoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Torneo {

    private HashMap<Integer, Pareja> jugadores;
    private CategoriaEntity categoriaEntity;
    private List<Zona> zonas;

    public Torneo(HashMap<Integer, Pareja> jugadores, CategoriaEntity categoriaEntity, List<Zona> zonas) {
        this.jugadores = jugadores;
        this.categoriaEntity = categoriaEntity;
        this.zonas = zonas != null ? zonas : new ArrayList<>();
    }
    public Torneo(){}
    public List<Zona> crearZonas () {
        int size = this.jugadores.size();
        int zonasDe4 = size / 4;
        int parejasRestantes = size % 4;
        if (parejasRestantes == 1) {
            zonasDe4 -= 2;
            parejasRestantes += 8;
        } else if (parejasRestantes == 2) {
            zonasDe4--;
            parejasRestantes += 4;
        }
        int countParejas = 0;
        int countZonas = 0;
        int zonasDe3 = parejasRestantes / 3;
        // primero recorremos las zonas de 3, para que los que tienen mejor ranking, tengan solamente 2 partidos.
        for (int i = 0; i < zonasDe3; i++) {
            // Aca creamos la cantidad necesaria de zonas de 3
            Zona zona = new Zona(this);
            //Aca rellenamos las zonas de 3
            HashMap<Integer, Pareja> tempZona = new HashMap<>();
            for (int j = 0 ;j < 3; j++) {
                System.out.println(jugadores.get(countParejas));
                tempZona.put(countParejas,jugadores.get(countParejas));
                countParejas++;
            }
            zona.setJugadores(tempZona);
            this.zonas.add(zona);
            countZonas++;
        }
        for (int i = 0; i <= zonasDe4; i++) {
            // Aca creamos la cantidad necesaria de zonas de 4
            Zona zona = new Zona(this);
            //Aca rellenamos las zonas de 4
            HashMap<Integer, Pareja> tempZona = new HashMap<>();
            for (int j = 0 ; j < 4; j++) {
                tempZona.put(countParejas,jugadores.get(countParejas));
                countParejas++;
            }
            zona.setJugadores(tempZona);
            this.zonas.add(zona);
            countZonas++;
        }
        return this.zonas;
    }
    public void setearPartidoZona (PartidoDTO partidoDTO) {
        for (int i = 0; i < zonas.size(); i++) {

        }
    }
    /*public void sumarPunto (Zona zona, Partido partido, Pareja pareja){
        for (int i = 0; i < zonas.size() ; i++) {
            if (zonas.get(i).equals(zona)) {
                for (int j = 0; i < zonas.get(i).getPartidos().size(); j++) {
                    if (zonas.get(i).getPartidos().get(j).equals(partido)) {
                        zonas.get(i).getPartidos().get(j).sumarPunto(pareja);
                        return;
                    }
                }
            }
        }
    }*/
}
