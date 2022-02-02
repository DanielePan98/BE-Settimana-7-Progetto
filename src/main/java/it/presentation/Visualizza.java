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
import it.data.NumTelefono;


@WebServlet("/visualizza")
public class Visualizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Visualizza() {
      
    }
@EJB
RubricaEjb r;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Contatto> contatto = r.getAllContatti();
		List<NumTelefono> numeri = r.getAllNumeri();
		PrintWriter out = response.getWriter();
						
		for(Contatto c: contatto) {
			out.println("Nome: "+c.getNome() +" Cognome: "+c.getCognome()+" Email: "+c.getEmail());
		
			 for (NumTelefono n : numeri)
		      { 		      
		           out.println("Numeri di telefono :" +n);
		           out.println("---------------------------------------------------------------------------------------------------------------------------------");
		      }
			
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
