package colarinhobranco.dao;

import java.util.List;

import colarinhobranco.model.News;

public interface NewsDao {
	
	public News save(News news);
	
	public News get(Integer id);
	
	public List<News> findAll();

}
