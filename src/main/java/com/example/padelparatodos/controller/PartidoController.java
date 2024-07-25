package com.example.padelparatodos.controller;

import com.example.padelparatodos.model.categorias.Categoria;
import com.example.padelparatodos.model.partido.Partido;
import com.example.padelparatodos.model.partido.PartidoSinIniciar;
import com.example.padelparatodos.model.partido.PartidoState;
import com.example.padelparatodos.service.CategoriaService;
import com.example.padelparatodos.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partido")
public class PartidoController {
    private final JugadorService jugadorService;
    private final CategoriaService categoriaService;
    @Autowired
    public PartidoController(JugadorService jugadorService, CategoriaService categoriaService) {
        this.jugadorService = jugadorService;
        this.categoriaService = categoriaService;
    }

    @PostMapping("/nuevo")
    public Partido crearPartido (@RequestBody Partido partido) {
        PartidoState nuevoPartido = new PartidoSinIniciar(partido);
        partido.setPartidoState(nuevoPartido);
        return partido;
    }
}
