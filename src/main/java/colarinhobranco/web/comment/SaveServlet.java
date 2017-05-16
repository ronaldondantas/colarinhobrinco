package colarinhobranco.web.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colarinhobranco.dao.CommentDao;
import colarinhobranco.daoimpl.CommentDaoImpl;
import colarinhobranco.model.Comment;
import colarinhobranco.model.News;

@SuppressWarnings("serial")
@WebServlet("/comment/save")
public class SaveServlet extends HttpServlet {
	
	private CommentDao dao = new CommentDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Integer newsId = Integer.parseInt(request.getParameter("newsId"));
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		
		Comment comment = new Comment(author, content);
		News news = new News();
		news.setId(newsId);
		comment.setNews(news);
		
		dao.save(comment);
		
		response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write("Success");
		
	}

}
