package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author antho
 */
public interface CategoriaService {
    
    //rertona una lista de categorias, activa o todas
    public List<Categoria> getCategorias(boolean activos);
    
    //retorna una categoria por id
    public Categoria getCategoria(Categoria categoria);
    
    //se inserta un nuevo registro si el id de la categoria esta vacío
    //se actualiza el registro si el id de la categoria NO está vacío
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
    
    public List<Categoria> getCategoriasPorDescipcion(String descripcion);
}
