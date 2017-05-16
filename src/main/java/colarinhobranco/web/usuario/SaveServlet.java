/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colarinhobranco.web.usuario;

import colarinhobranco.dao.UsuarioDao;
import colarinhobranco.daoimpl.UsuarioDaoImpl;
import colarinhobranco.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jotap
 */
@SuppressWarnings("serial")
@WebServlet("/usuario/save")
public class SaveServlet extends HttpServlet{
        
        private UsuarioDao dao = new UsuarioDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("content");
                String senha = request.getParameter("content");
		
		Usuario usuario = new Usuario(nome, email, senha);		
		dao.save(usuario);
		
		response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write("Success");
		
	}
    
}
