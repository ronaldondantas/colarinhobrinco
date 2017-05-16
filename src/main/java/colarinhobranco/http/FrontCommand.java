/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.http;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;

/**
 * nao usado, deve ser removido do projeto
 * @author Neo Figueiredo
 */
public abstract class FrontCommand {

    public Map map;
    public String target;
    public Dispatcher dispatcher;
    public void init(Map requestContextMap, Dispatcher dispatcher) {
        this.map = requestContextMap;
        this.dispatcher = dispatcher;
    }
    
    public abstract void process() throws ServletException, IOException;
    public String getTarget(){ 
        return this.target;
    }
    
}
