package it.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.business.RubricaEjb;
import it.data.Contatto;

@WebServlet("/cerca1")
public class Cerca1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Cerca1() {
       
    }

	@EJB
	RubricaEjb r;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cognome=request.getParameter("cognome");
		List<Contatto> contatti = r.getContattoByCognome(cognome);
		PrintWriter out = response.getWriter();
		 for (Contatto c : contatti)
	      { 		      
	           out.println(c.getCognome()+" "+c.getNome()+" "+c.getEmail());
	      }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
