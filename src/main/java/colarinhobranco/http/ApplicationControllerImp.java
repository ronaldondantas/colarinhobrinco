/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.http;

import colarinhobranco.web.news.*;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Neo Figueiredo
 */
public class ApplicationControllerImp implements ApplicationController {
    private FrontCommand controller;
    public Map requestContextMap;
    public Dispatcher dispatcher;

    ApplicationControllerImp(Map requestContextMap, Dispatcher dispatcher) {
       this.requestContextMap = requestContextMap;
       System.out.println(dispatcher.context);
       this.dispatcher = dispatcher;
    }
    
    @Override
    public void getInstance() {
       try {
            String[] cmd = (String[])this.requestContextMap.get("command");
            String[] util = (String[])this.requestContextMap.get("util");
            Class type;
            if (util==null) {
                type = Class.forName(String.format(
                        "colarinhobranco.web.news.%sServlet",cmd
                ));
            }else{
                type = Class.forName(String.format(
                        "colarinhobranco.web.util.%sServer",cmd
                ));
            }
           this.controller = (FrontCommand) type
             .asSubclass(FrontCommand.class)
             .newInstance();
       } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
           this.controller = new ListServlet();
       }
    }
    
    @Override
    public void process(){
        try {
            this.controller.init(this.requestContextMap,this.dispatcher);
            this.controller.process();
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ApplicationControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void forward(){
        try {
            String goTarget = this.controller.getTarget();
            if(!"".equals(goTarget.trim())){
                dispatcher.forward(goTarget);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ApplicationControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
