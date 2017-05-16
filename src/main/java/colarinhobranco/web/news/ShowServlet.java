package colarinhobranco.web.news;

import colarinhobranco.http.FrontCommand;
import java.io.IOException;

import javax.servlet.ServletException;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;

public class ShowServlet extends FrontCommand {
	
    private NewsDao newsDao = new NewsDaoImpl();
    
    public ShowServlet(){
        this.target = "news/show";
    }
		
    @Override
    public void process() throws ServletException, IOException {
		
		Integer newsId = (Integer)map.get("newsId");
		
		this.dispatcher.request.setAttribute("news", newsDao.get(newsId));
		
		//forward("news/show");
		
	}
	
}