/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.http;

/**
 * NAO USADO
 * @author Neo Figueiredo
 */
abstract class CommandMapper {
    
    private static CommandMapper _instance;
    
    static {
        try {
        _instance = new CommandMapper() {};
        } catch (Exception se) {
        System.err.println(se);
            se.printStackTrace(System.err);
        }
    }
    static public CommandMapper getInstance() {
       return _instance;
    }

}
