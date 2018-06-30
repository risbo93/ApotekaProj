package sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.KurirskaSluzbaManager;
import manager.LekManager;
import manager.OsobaManager;
import manager.StavkaManager;
import model.KurirskaSluzba;
import model.Lek;
import model.Osoba;
import model.Stavka;

/**
 * Servlet implementation class ObrisiIzKorpeServlet
 */
@WebServlet("/ObrisiIzKorpeServlet")
public class ObrisiIzKorpeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObrisiIzKorpeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String odabraniLekId=(String) request.getAttribute("odabraniL");
		Osoba osoba = (Osoba) request.getSession().getAttribute("ulogovaniKorisnik");
		System.out.println("---------------------------------->"+odabraniLekId);
		//StavkaManager.ukloniStavkuKorisniku(osoba, odabraniLekId);
		Osoba ulogovaniKorisnik = (Osoba) request.getSession().getAttribute("ulogovaniKorisnik");
		List<Stavka> listaStavki=StavkaManager.listaStavki(ulogovaniKorisnik);
		int cena=OsobaManager.cenaKupovine(ulogovaniKorisnik);
		request.setAttribute("cena", cena);
		if(listaStavki!=null) {
			request.setAttribute("stavke", listaStavki);
		}
		List<KurirskaSluzba> kurirskeSluzbe=KurirskaSluzbaManager.listaKurirskihSluzbi();
		request.setAttribute("kurirskeSluzbe", kurirskeSluzbe);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/korpa.jsp");
		rd.forward(request, response);
	}

}
