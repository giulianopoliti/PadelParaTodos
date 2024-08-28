package com.example.padelparatodos.model;

import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.model.categorias.Categoria;
import com.example.padelparatodos.model.categorias.Observer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Jugador implements Subject{
    private int id;
    private String name;
    private String lastName;
    private int age;
    private int score;
    private Categoria categoria;
    private List<Observer> observers;


    /*public void modificarPuntos (int num) {
        this.score += num;
        if (this.score > categoria.getRangoSuperior()) {
            System.out.println("El jugador" + this.name + " " + this.lastName + "ha cambiado de categoria");
            notifyObservers();
        }
    }*/

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }
    public JugadorDTO jugadorToDTO () {
        JugadorDTO jugadorDTO = new JugadorDTO(this.getId(), this.getLastName(), this.getName());
        return jugadorDTO;
    }
}
