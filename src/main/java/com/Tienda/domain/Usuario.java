package com.Tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellidos;
    
    private String telefono;
    private String correo;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String username, String password, String nombre, String apellidos, String telefono, String correo, String rutaImagen, boolean activo, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.roles = roles;
    }
    
    
}
