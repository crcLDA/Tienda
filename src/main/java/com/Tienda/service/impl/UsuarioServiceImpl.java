package com.Tienda.service.impl;

import com.Tienda.dao.UsuarioDao;
import com.Tienda.domain.Rol;
import com.Tienda.domain.Usuario;
import com.Tienda.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
            
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //busca el usuario en la BD
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //sino existe lanza una excepcion
        if (usuario==null) throw new UsernameNotFoundException(username);
        
        //se encontro usuario en BD y se remueve el atributo en la sesion
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        var roles = new ArrayList<GrantedAuthority>();
        
        //se transforma los roles a granted authority
        for (Rol item : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(item.getNombre()));
        }
        
        //retorna el User (clase details)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
    
}
