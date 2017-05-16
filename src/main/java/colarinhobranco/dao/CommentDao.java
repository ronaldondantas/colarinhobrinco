package colarinhobranco.dao;

import java.util.List;

import colarinhobranco.model.Comment;
import colarinhobranco.model.News;

public interface CommentDao {
	
	public Comment save(Comment comment);
	
	public List<Comment> findByNews(News news);

}
