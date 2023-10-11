package com.Tienda.dao; //esta usa un java interface

import com.Tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author antho
 */
public interface CategoriaDao extends JpaRepository <Categoria, Long> {
    
}
