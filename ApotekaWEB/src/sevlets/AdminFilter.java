package sevlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import model.Osoba;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(filterName="filterAdmin", urlPatterns = { "/BrisanjeServlet/*", "/DodavanjeLekaServlet/*", 
		"/PregledServlet/*", "/ReportServlet/*", "/ImenikServlet/*", "/PregledKupovinaServlet/*","/KupovineReportServlet/*"})
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		Osoba o = (Osoba)((HttpServletRequest) request).getSession().getAttribute("ulogovaniKorisnik");
		if(o!=null && o.getUloga().equalsIgnoreCase("admin")){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("/IndexServlet").forward(request, response);
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
