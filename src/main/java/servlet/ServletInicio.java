package servlet;

import java.io.IOException;

import entities.PanelAdmin;
import entities.PanelBandeja;
import entities.PanelEnviados;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletInicio
 */
public class ServletInicio extends HttpServlet {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletInicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();

			String usuario = session.getAttribute("usuario").toString();

			String botonMensajes = request.getParameter("botonMensajes");
			if (botonMensajes != null) {
				request.getRequestDispatcher("enviarMensaje.jsp")
						.forward(request, response);
			}
			String botonEnviados = request.getParameter("botonEnviados");
			if (botonEnviados != null) {
				PanelEnviados panel = new PanelEnviados();
				panel.actualizarPanel(request, response);
			}
			String botonBandeja = request.getParameter("botonBandeja");
			if (botonBandeja != null) {
				PanelBandeja panel = new PanelBandeja();
				panel.actualizarPanel(request, response);
			}
			String botonAdmin = request.getParameter("botonAdmin");
			if (botonAdmin != null) {
				PanelAdmin panel = new PanelAdmin();
				panel.actualizarPanel(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
