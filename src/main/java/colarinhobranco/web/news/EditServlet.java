/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.web.news;

import colarinhobranco.http.FrontCommand;
import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Neo Figueiredo
 */
public class EditServlet extends FrontCommand {
	
    private NewsDao newsDao = new NewsDaoImpl();
    
    public EditServlet(){
        this.target = "news/edit";
    }
    
    @Override
    public void process() throws ServletException, IOException {
    
    }
	
}