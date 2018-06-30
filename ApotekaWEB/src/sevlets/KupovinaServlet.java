package sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.LekManager;
import manager.StavkaManager;
import model.Korisnik;
import model.Lek;
import model.Osoba;
import model.Stavka;

/**
 * Servlet implementation class KupovinaServlet
 */
@WebServlet("/KupovinaServlet")
public class KupovinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KupovinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String poruka="";
		poruka=request.getParameter("poruka");
		List<Lek> listaLekova = LekManager.listaLekova();
		request.setAttribute("lekovi", listaLekova);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/kupovina.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String odabraniLekID = request.getParameter("odabir");
		Lek odabraniLek = LekManager.findLekById(odabraniLekID);
		String poruka2="";
		Osoba ulogovaniKorisnik = (Osoba) request.getSession().getAttribute("ulogovaniKorisnik");
	
		if(StavkaManager.dodajStavkuKorisniku(ulogovaniKorisnik, odabraniLek)) {
			poruka2="Uspesno dodato u korpu!";
		}else {
			poruka2="Neuspesno dodavanje u korpu, pokusajte ponovo!";
		}
		request.setAttribute("poruka2", poruka2);
		doGet(request, response);
	}

}
