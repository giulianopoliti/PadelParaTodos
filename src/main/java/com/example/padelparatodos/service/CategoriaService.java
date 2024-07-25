package com.example.padelparatodos.service;

import com.example.padelparatodos.entity.CategoriaEntity;
import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.model.Jugador;
import com.example.padelparatodos.model.categorias.Categoria;
import com.example.padelparatodos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public void guardarCategoria (Categoria categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNameCategory(categoria.getName());
        categoriaEntity.setRangoInferior(categoria.getRangoInferior());
        categoriaEntity.setRangoSuperior(categoria.getRangoSuperior());
        CategoriaEntity categoriaSaved = categoriaRepository.save(categoriaEntity);
    }
    public CategoriaEntity buscarCategoriaDeJugador (JugadorEntity jugadorEntity){
        Optional<CategoriaEntity> categoriaOpt = categoriaRepository.findByPuntosInRange(jugadorEntity.getScore());
        if (categoriaOpt.isPresent()){
            CategoriaEntity categoriaEntity = categoriaOpt.get();
            jugadorEntity.setCategoriaEntity(categoriaEntity);
            return categoriaEntity;
        } else {
            throw new RuntimeException("Es muy bueno no hay categoria para el");
        }
    }
    public CategoriaEntity buscarCategoria (int id) {
        Optional<CategoriaEntity> categoriaOpt = categoriaRepository.findById(id);
        if (categoriaOpt.isPresent()){
            CategoriaEntity categoriaEntity = categoriaOpt.get();
            return categoriaEntity;
        } else {
            throw new RuntimeException("No se encontro la categoria");
        }
    }
}
