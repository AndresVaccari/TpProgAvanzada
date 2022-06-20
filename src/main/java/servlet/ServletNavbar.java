package servlet;

import java.io.IOException;

import entities.PanelBandejaEntrada;
import entities.PanelBandejaSalida;
import entities.PanelInicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletNavbar
 */
public class ServletNavbar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletNavbar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String botonRegistro = request.getParameter("botonRegistro");
		if (botonRegistro != null) {
			response.sendRedirect("registro.jsp");
		}
		String botonLogin = request.getParameter("botonLogin");
		if (botonLogin != null) {
			response.sendRedirect("login.jsp");
		}
		String botonIndex = request.getParameter("bs");
		if (botonIndex != null) {
			HttpSession session = request.getSession();
			try {
				session.getAttribute("usuario").toString();
				PanelInicio panel = new PanelInicio();
				panel.actualizarPanel(request, response);
			} catch (NullPointerException e) {
				response.sendRedirect("index.jsp");
			}
		}
		String botonVolver = request.getParameter("botonVolver");
		if (botonVolver != null) {
			PanelInicio panel = new PanelInicio();
			panel.actualizarPanel(request, response);
		}
		String botonVolverRecibidos = request
				.getParameter("botonVolverRecibidos");
		if (botonVolverRecibidos != null) {
			PanelBandejaEntrada panel = new PanelBandejaEntrada();
			panel.actualizarPanel(request, response);
		}
		String botonVolverEnviados = request
				.getParameter("botonVolverEnviados");
		if (botonVolverEnviados != null) {
			PanelBandejaSalida panel = new PanelBandejaSalida();
			panel.actualizarPanel(request, response);
		}
		String botonLogOut = request.getParameter("botonLogOut");
		if (botonLogOut != null) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
