package sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.KomentarManager;
import manager.LekManager;
import model.Komentar;
import model.Lek;
import model.Osoba;

/**
 * Servlet implementation class KomentarServlet
 */
@WebServlet("/KomentarServlet")
public class KomentarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KomentarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String odabraniLekID = request.getParameter("odabir");
		List<Komentar> komentari = KomentarManager.getKomentari(odabraniLekID);
		request.setAttribute("komentari", komentari);
		request.setAttribute("odabraniLek", odabraniLekID);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/komentari.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String odabraniLekId=request.getParameter("idLeka");
		Osoba osoba = (Osoba) request.getSession().getAttribute("ulogovaniKorisnik");
		String tekstKomentara =request.getParameter("text");
		System.out.println("Odabrani lek ---> " + odabraniLekId);
		KomentarManager.komentarisi(odabraniLekId, osoba, tekstKomentara);
		List<Komentar> komentari = KomentarManager.getKomentari(odabraniLekId);
		request.setAttribute("komentari", komentari);
		request.setAttribute("odabraniLek", odabraniLekId);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/komentari.jsp");
		rd.forward(request, response);
	}

}
