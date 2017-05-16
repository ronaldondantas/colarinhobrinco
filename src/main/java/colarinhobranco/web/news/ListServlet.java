package colarinhobranco.web.news;

import colarinhobranco.http.FrontCommand;
import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;

public class ListServlet extends FrontCommand {

    private NewsDao newsDao = new NewsDaoImpl();
    public ListServlet(){
        this.target = "news/list";
    }
    @Override
    public void process() throws ServletException, IOException {
        this.dispatcher.request.setAttribute("news", newsDao.findAll()); 
    }
	
}