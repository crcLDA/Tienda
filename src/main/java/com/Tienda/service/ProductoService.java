package com.Tienda.service;

import com.Tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    public List<Producto> getProductos(boolean activos);
    
    public Producto getProducto(Producto producto);
    
    //se inserta un nuevo registro si el id de la categoria esta vacío
    //se actualiza el registro si el id de la categoria NO está vacío
    public void save(Producto producto);
    
    public void delete(Producto producto);
    
   //Lista de productos con precio entre ordenados por descripcion ConsultaAmpliada
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Lista de productos utilizando consultas JPQL
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);
}
