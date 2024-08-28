package com.example.padelparatodos.service;

import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.entity.PartidoEntity;
import com.example.padelparatodos.model.Jugador;
import com.example.padelparatodos.repository.JugadorRepository;
import com.example.padelparatodos.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartidoService {
    private PartidoRepository partidoRepository;
    @Autowired
    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public void guardarPartido (PartidoEntity partidoEntity) {
        partidoRepository.save(partidoEntity);
    }

    public List<PartidoEntity> findByPlayerNameOrLastName(JugadorEntity jugador) {
        return partidoRepository.findByPlayer(jugador);
    }
}
