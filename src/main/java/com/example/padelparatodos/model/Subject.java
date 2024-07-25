package com.example.padelparatodos.model;

import com.example.padelparatodos.model.categorias.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
