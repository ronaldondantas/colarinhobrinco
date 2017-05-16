/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.http;

import colarinhobranco.web.news.ListServlet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Neo Figueiredo
 */
public class FrontController extends HttpServlet {

    protected void process(HttpServletRequest request,
            HttpServletResponse response) throws java.io.IOException {

        request.setCharacterEncoding("UTF-8");
        
        // Cria um objeto RequestContext usando a estratégia do Map
        Map requestContextMap = new HashMap(request.getParameterMap());
        try {
            if (request.getContentType() != null && request.getContentType().toLowerCase().contains("multipart/form-data") ) {
                Collection<Part> partes = request.getParts();
                if (!partes.isEmpty()) {
                    requestContextMap.put("partes", partes);
                }
            }
        } catch (ServletException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dispatcher dispatcher = new Dispatcher(getServletContext(),request, response);
        
        ApplicationControllerImp applicationController = new ApplicationControllerImp(requestContextMap,dispatcher);
        applicationController.getInstance();
        applicationController.process();
        applicationController.forward();
        
    }
    
    
//  private FrontCommand getCommand(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            Class type = Class.forName(String.format(
//              "colarinhobranco.web.news.%sServlet",
//              request.getParameter("command")));
//            return (FrontCommand) type
//              .asSubclass(FrontCommand.class)
//              .newInstance();
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//            return new ListServlet();
//        }
//    }

  /** Handles the HTTP <code>GET</code> method.
   * @param request servlet request
   * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
   */
  @Override
  protected void doGet(HttpServletRequest request, 
    HttpServletResponse response)
    throws ServletException, java.io.IOException {
      
//      FrontCommand command = getCommand(request, response);
//        command.init(getServletContext(), request, response);
//        command.
                process(request,response);
  }

  /** Handles the HTTP <code>POST</code> method.
   * @param request servlet request
   * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
//        FrontCommand command = getCommand(request, response);
//        command.init(getServletContext(), request, response);
//        command.
        process(request,response);
  }

  /** Returns a short description of the servlet
     * @return  */
  @Override
  public String getServletInfo() {
    return "Front Controller";
  }

}
