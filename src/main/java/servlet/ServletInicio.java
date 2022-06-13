package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entities.PanelAdmin;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String botonMensajes = request.getParameter("botonMensajes");
			if (botonMensajes != null) {
				request.setAttribute("usuario", botonMensajes);
				request.getRequestDispatcher("enviarMensaje.jsp").forward(request, response);
			}
			String botonBandeja = request.getParameter("botonBandeja");
			if (botonBandeja != null) {
				response.sendRedirect("login.jsp");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
