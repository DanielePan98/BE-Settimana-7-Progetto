package it.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.business.RubricaEjb;
import it.data.Contatto;


@WebServlet("/cerca2")
public class Cerca2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cerca2() {
        
    }

	@EJB
	RubricaEjb r;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numero=request.getParameter("numero");
		Contatto c = r.getContattoByNumero(numero);
		PrintWriter out = response.getWriter();
		out.print(c.getNumTelefoni()+" "+c.getCognome()+" "+c.getNome());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
