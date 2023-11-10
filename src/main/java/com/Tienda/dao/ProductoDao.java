package com.Tienda.dao;

import com.Tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao  extends JpaRepository <Producto, Long> {
    /*//Ejemplo de método utilizando Métodos de Querry
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Ejemplo de método utilizando consultas JPQL
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);*/
}