/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.dao;

import colarinhobranco.model.Usuario;
import java.util.List;

/**
 *
 * @author jotap
 */
public interface UsuarioDao {
    
        public Usuario save(Usuario usuario);	
	public List<Usuario> findByEmail(String email);   
    
}
