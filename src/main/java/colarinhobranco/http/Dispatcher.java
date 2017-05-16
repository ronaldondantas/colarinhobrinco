/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.http;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Neo Figueiredo
 */
public class Dispatcher{
    
    //public String target;
    public ServletContext context;
    public HttpServletRequest request;
    public HttpServletResponse response;

    Dispatcher(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
        //this.target = this.request.getParameter("command");
    }
    
    public void forward(String target) throws ServletException, IOException{
        String targetURL = String.format("/pages/%s.jsp", target);
        RequestDispatcher dispatcher = this.context.getRequestDispatcher(targetURL);
        dispatcher.forward(this.request,this.response);
    }
    
}
