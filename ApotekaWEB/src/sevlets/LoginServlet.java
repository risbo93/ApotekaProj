package sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.KorisnikManager;
import manager.OsobaManager;
import model.Korisnik;
import model.Osoba;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String poruka="";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Korisnik korisnik=KorisnikManager.login(username, password);
		Osoba osoba=OsobaManager.pronadjiOsobu(korisnik);
		if(korisnik==null) {
			poruka="Pogresno unesen username ili password!";
			request.setAttribute("poruka", poruka);
			doGet(request,response);
		}
		else if(osoba==null) {
			poruka="Pogresno unesen username ili password!";
			request.setAttribute("poruka", poruka);
			doGet(request,response);
		}
		else {
		request.getSession().setAttribute("ulogovaniKorisnik", osoba);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
		}
		
		//HttpSession session = request.getSession();
		//Korisnik ulogovaniKorisnik = (Korisnik) session.getAttribute("ulogovaniKorisnik");
		
		/*
		 * <c:choose>
									<c:when test="${loggedInUser.vrstaKorisnika == 'ADMIN' }">
										<input type="hidden" name="userIdForDelete"
											id="userIdForDelete" value="${requestScope.korisnik.id }">
										<input type="hidden" name="userWhoDeleteId"
											id="userWhoDeleteId" value="${loggedInUser.id }">

										<form method="get" action="PocetnaStranaServlet">
											<button id="obrisiBtn2" onclick="alertDelete(this.form)"
												type="submit" class="btn btn-danger">Delete</button>
										</form>

									</c:when>
								</c:choose>
		 */
	}

}
