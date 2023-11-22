package com.Tienda.service;

import com.Tienda.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
    public Usuario getUsuarioPorUsername(String username);
}
