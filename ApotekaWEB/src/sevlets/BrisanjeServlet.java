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
import model.Lek;

/**
 * Servlet implementation class BrisanjeServlet
 */
@WebServlet("/BrisanjeServlet")
public class BrisanjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrisanjeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Lek> lekovi = LekManager.listaLekova();
		request.setAttribute("lekovi", lekovi);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/brisanje.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String odabraniLekID = request.getParameter("odabraniLek");
		Lek odabraniLek = LekManager.findLekById(odabraniLekID);
		LekManager.obrisiLek(odabraniLek);
		doGet(request, response);
	}

}
