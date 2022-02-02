package it.presentation;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.business.RubricaEjb;
import it.data.Contatto;


@WebServlet("/elimina")
public class Elimina extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Elimina() {
        
    }

	@EJB
	RubricaEjb r;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto c = new Contatto();
		Integer id = Integer.valueOf(request.getParameter("id"));
		c.setId(id);
		
		try {
			r.elimina(c);;
			response.getWriter().append("Contatto eliminato");
		} catch (Exception e) {
			response.getWriter().append("Si è verificato un errore :").append(e.getMessage());
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
