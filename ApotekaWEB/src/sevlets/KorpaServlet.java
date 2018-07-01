package sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.KupovinaManager;
import manager.KurirskaSluzbaManager;
import manager.OsobaManager;
import manager.StavkaManager;
import model.KurirskaSluzba;
import model.Osoba;
import model.Stavka;

/**
 * Servlet implementation class KorpaServlet
 */
@WebServlet("/KorpaServlet")
public class KorpaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KorpaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String poruka3 = "";
		poruka3 = request.getParameter("poruka3");
		Osoba ulogovaniKorisnik = (Osoba) request.getSession().getAttribute("ulogovaniKorisnik");
		List<Stavka> listaStavki = StavkaManager.listaStavki(ulogovaniKorisnik);
		int cena = OsobaManager.cenaKupovine(ulogovaniKorisnik);
		request.setAttribute("cena", cena);
		if (listaStavki != null) {
			request.setAttribute("stavke", listaStavki);
		}
		List<KurirskaSluzba> kurirskeSluzbe = KurirskaSluzbaManager.listaKurirskihSluzbi();
		request.setAttribute("kurirskeSluzbe", kurirskeSluzbe);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/korpa.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idLek = request.getParameter("odabraniL");
		if (idLek == null) {
			String poruka3 = "";
			Osoba ulogovaniKorisnik = (Osoba) request.getSession().getAttribute("ulogovaniKorisnik");
			String kurirskaSluzbaId = request.getParameter("odabranaKS");
			KurirskaSluzba kurirskaSluzba = KurirskaSluzbaManager.findKurirskaSluzbaById(kurirskaSluzbaId);
			if (KupovinaManager.novaKupovina(kurirskaSluzba, ulogovaniKorisnik)) {
				if (KupovinaManager.ocistiKorpu(ulogovaniKorisnik)) {
					poruka3 = "Uspesno izvrsena kupovina!";
				}else {
					poruka3 = "Kupovina nije uspesno izvrsena!";
				}
			} else {
				poruka3 = "Kupovina nije uspesno izvrsena!";
			}
		} else {
			Osoba osoba = (Osoba) request.getSession().getAttribute("ulogovaniKorisnik");
			StavkaManager.ukloniStavkuKorisniku(osoba, idLek);
		}
		doGet(request, response);
	}

}
