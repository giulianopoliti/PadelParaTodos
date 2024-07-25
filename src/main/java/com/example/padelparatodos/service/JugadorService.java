package com.example.padelparatodos.service;

import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JugadorService {
    private JugadorRepository jugadorRepository;
    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public void guardarJugador (JugadorEntity jugadorEntity) {
        jugadorRepository.save(jugadorEntity);
    }
    public Optional<JugadorEntity> buscarJugador (JugadorEntity jugadorEntity) {
        return jugadorRepository.findById(jugadorEntity.getId());
    }
    public JugadorEntity findByNameAndLastName (String name, String lastName) {
        return jugadorRepository.findByNameAndLastName(name, lastName);
    }
}
