package sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.LekManager;

/**
 * Servlet implementation class DodavanjeLekaServlet
 */
@WebServlet("/DodavanjeLekaServlet")
public class DodavanjeLekaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodavanjeLekaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub);
		String poruka1="";
		request.setAttribute("poruka1", poruka1);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/dodavanjeLeka.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String naziv=request.getParameter("naziv");
		String cena=request.getParameter("cena");
		String poruka1="";
		if(LekManager.dodajLek(naziv, cena)) {
			poruka1="Lek je uspesno dodat!";
			request.setAttribute("poruka1",poruka1);
		}else {
			poruka1="Pogresno uneseni podaci!";
			request.setAttribute("poruka1",poruka1);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/dodavanjeLeka.jsp");
		rd.forward(request, response);
	}

}
