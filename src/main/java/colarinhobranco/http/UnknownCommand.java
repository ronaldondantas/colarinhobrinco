/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.http;

import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Neo Figueiredo
 */
public class UnknownCommand extends FrontCommand {

    /**
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void process() throws ServletException, IOException {
        //forward("404");
    }
}
