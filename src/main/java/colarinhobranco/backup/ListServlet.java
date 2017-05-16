package colarinhobranco.backup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;

/*@SuppressWarnings("serial")
@WebServlet(urlPatterns="/news/list")*/
public class ListServlet extends HttpServlet {
	
	private NewsDao newsDao = new NewsDaoImpl();
		
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		request.setAttribute("news", newsDao.findAll());
		
		request.getRequestDispatcher("/pages/news/list.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
}