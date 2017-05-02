package colarinhobranco.daoimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.model.News;
import colarinhobranco.util.JPAUtil;

public class NewsDaoImpl implements NewsDao {

	@Override
	public News save(News news) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(news);
			manager.flush();
			transaction.commit();
			return news;
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
	
	public News get(Integer id) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		try {
			return manager.find(News.class, id);
		} finally {
			manager.close();
		}
		
	}

	public List<News> findAll() {
		
		EntityManager manager = new JPAUtil().getEntityManager();
	
		try {
			return manager.createQuery("select n from News n order by n.date desc", News.class).getResultList();
		} finally {
			manager.close();
		}
				
	}
	
	public static void main(String[] args) {
		
		NewsDao newsDao = new NewsDaoImpl();
		newsDao.save(new News("News 1", new Date(), "News headline 1", "news/headline/image/1", "News content 1"));
		newsDao.save(new News("News 2", new Date(), "News headline 2", "news/headline/image/2", "News content 2"));		
		
		//List<News> news = newsDao.findAll();
		
		//for (News newsObj : news) {
			//System.out.println(newsObj);
		//}
		
	}

}