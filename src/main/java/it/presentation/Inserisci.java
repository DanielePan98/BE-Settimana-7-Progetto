package it.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.business.RubricaEjb;
import it.data.Contatto;
import it.data.NumTelefono;


@WebServlet("/inserisci")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Inserisci() {
       
    }
@EJB
RubricaEjb r;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Contatto c = new Contatto();
	ArrayList<NumTelefono> numeri = new ArrayList<NumTelefono>();
	NumTelefono n1 = new NumTelefono();
	NumTelefono n2 = new NumTelefono();
	
	String cognome=request.getParameter("cognome");
	String nome=request.getParameter("nome");
	String email=request.getParameter("email");
	n1.setNumero(request.getParameter("num1"));
	n2.setNumero(request.getParameter("num2"));
	
	c.setCognome(cognome);
	c.setNome(nome);
	c.setEmail(email);
	n1.setContatto(c);
	n2.setContatto(c);
	numeri.add(n1);
	numeri.add(n2);
	c.setNumTelefoni(numeri);
	
	try {
		r.inserisci(c);;
		response.getWriter().append("Contatto inserito");
	} catch (Exception e) {
		response.getWriter().append("Si è verificato un errore :").append(e.getMessage());
		e.printStackTrace();
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
