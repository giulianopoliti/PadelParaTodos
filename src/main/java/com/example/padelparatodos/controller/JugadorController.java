package com.example.padelparatodos.controller;

import com.example.padelparatodos.entity.CategoriaEntity;
import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.model.Jugador;
import com.example.padelparatodos.model.categorias.Categoria;
import com.example.padelparatodos.service.CategoriaService;
import com.example.padelparatodos.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    private final JugadorService jugadorService;
    private final CategoriaService categoriaService;
    @Autowired
    public JugadorController(JugadorService jugadorService, CategoriaService categoriaService) {
        this.jugadorService = jugadorService;
        this.categoriaService = categoriaService;
    }

    @PostMapping("/crear")
    public String crearJugador(@RequestBody Jugador jugador) {
        JugadorEntity jugadorEntity = convertJugToEntity(jugador);
        jugadorService.guardarJugador(jugadorEntity);
        return "Jugador creado: " + jugadorEntity.getName() + " " + jugadorEntity.getLastName();
    }
    private JugadorEntity convertJugToEntity (Jugador jugador) {
        JugadorEntity jugadorEntity = new JugadorEntity();
        jugadorEntity.setName(jugador.getName());
        jugadorEntity.setLastName(jugador.getLastName());
        jugadorEntity.setAge(jugador.getAge());
        jugadorEntity.setScore(jugador.getScore());
        jugadorEntity.setCategoriaEntity(categoriaService.buscarCategoriaDeJugador(jugadorEntity));
        return jugadorEntity;
    }
}
