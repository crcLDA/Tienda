package com.Tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author antho
 */

@Data //para la creacion automatica de los set y get de los atributos y no se muestran
@Entity //actua como una entidad 
@Table(name="categoria")
public class Categoria implements Serializable { //convierte la clase en entidad
    private static final long serialVersionUID = 1L; //es el tipo de serializacion para trabajar con la BD
    
    @Column(name = "id_categoria") //si el nombre es diferente con esta anotacion puede reconocer la columna de BD
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCategoria; //se transforma en id_categoria
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    /*@OneToMany
    @JoinColumn(name="id_categoria")
    List<Producto> productos;*/
    

    public Categoria() {}

    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
    
    
    
}
