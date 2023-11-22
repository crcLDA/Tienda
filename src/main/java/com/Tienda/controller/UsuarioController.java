/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda.controller;

import com.Tienda.domain.Usuario;
import com.Tienda.service.FirebaseStorageService;
import com.Tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author antho
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";
    }

    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }

    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        //validar si es nuevo o se esta modificando (si trae id)
        boolean esNuevo=true;
        
        if (usuario.getIdUsuario()!=0) {
            esNuevo=false;
            Usuario actual = usuarioService.getUsuario(usuario);
            usuario.setPassword(actual.getPassword());
            usuario.setUsername(actual.getUsername());
            usuario.setRoles(actual.getRoles());
            if (!imagenFile.isEmpty()) {
                usuario.setRutaImagen(actual.getRutaImagen());
            }
        }
            else {
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            usuario.setActivo(true); //para crearlo siempre activo
        }

        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario,false);
            usuario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "usuario",
                            usuario.getIdUsuario()));
        }
        usuarioService.save(usuario,esNuevo);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}
