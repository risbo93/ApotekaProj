package sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.OsobaManager;

/**
 * Servlet implementation class RegistracijaServlet
 */
@WebServlet("/RegistracijaServlet")
public class RegistracijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaServlet() {
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/registracija.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		String godine=request.getParameter("godine");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String passwordConfirm=request.getParameter("confirm");
		String grad=request.getParameter("grad");
		String ulica=request.getParameter("ulica");
		String telefon=request.getParameter("telefon");
		String poruka="";
		if(OsobaManager.dodajOsobu(ime, prezime, godine, username, password, passwordConfirm, grad, ulica, telefon)) {
			poruka="Uspesna registracija!";
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}else {
			poruka="Pogresno uneti podaci!";
			doGet(request, response);
		}
	}

}
