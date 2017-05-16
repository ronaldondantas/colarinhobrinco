/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.daoimpl;

import colarinhobranco.dao.UsuarioDao;
import colarinhobranco.model.Usuario;
import colarinhobranco.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author jotap
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public Usuario save(Usuario usuario) {
            EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(usuario);
			manager.flush();
			transaction.commit();
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			
			if (transaction.isActive()) {
				transaction.rollback();
			}
			
			return null;			
		} finally {
			manager.close();
		}
    }

    @Override
    public List<Usuario> findByEmail(String email) {
                EntityManager manager = new JPAUtil().getEntityManager();
	
		String jpql = "SELECT u FROM Usuario u WHERE u.email = :email";

		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("email", email);

		return query.getResultList();
    }
    
}
