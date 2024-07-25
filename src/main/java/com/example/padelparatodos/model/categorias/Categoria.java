package com.example.padelparatodos.model.categorias;

import com.example.padelparatodos.entity.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria implements Observer {
    private String name;
    private int rangoInferior;
    private int rangoSuperior;

    public Categoria(String name, int rangoInferior, int rangoSuperior) {
        this.name = name;
        this.rangoInferior = rangoInferior;
        this.rangoSuperior = rangoSuperior;
    }
    public Categoria (CategoriaEntity categoriaEntity) {
        this.name = categoriaEntity.getNameCategory();
        this.rangoInferior = categoriaEntity.getRangoInferior();
        this.rangoSuperior = categoriaEntity.getRangoSuperior();
    }
    public Categoria (){}

    @Override
    public void update() {

    }
    public CategoriaEntity convertCatToEntity (Categoria categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNameCategory(categoria.getName());
        categoriaEntity.setRangoInferior(categoria.getRangoInferior());
        categoriaEntity.setRangoSuperior(categoria.getRangoSuperior());
        return categoriaEntity;
    }
}
