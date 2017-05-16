package colarinhobranco.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import colarinhobranco.dao.CommentDao;
import colarinhobranco.model.Comment;
import colarinhobranco.model.News;
import colarinhobranco.util.JPAUtil;

public class CommentDaoImpl implements CommentDao {

	@Override
	public Comment save(Comment commentary) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(commentary);
			manager.flush();
			transaction.commit();
			return commentary;
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
	public List<Comment> findByNews(News news) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
	
		String jpql = "SELECT c FROM Comment c WHERE c.news = :news";

		TypedQuery<Comment> query = manager.createQuery(jpql, Comment.class);
		query.setParameter("news", news);

		return query.getResultList();
		
	}

}