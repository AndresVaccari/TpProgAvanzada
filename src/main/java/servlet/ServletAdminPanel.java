package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Statement;

import entities.Conexion;
import entities.PanelAdmin;

/**
 * Servlet implementation class ServletAdminPanel
 */
public class ServletAdminPanel extends HttpServlet {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminPanel() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PanelAdmin panel = new PanelAdmin();
			
			java.sql.Connection conn = Conexion.getConexion();
			
			String botonDesactivar = request.getParameter("botonDesactivar");
			if (botonDesactivar != null) {
				Statement st = conn.createStatement();
				st.executeUpdate("UPDATE usuario SET Estado = 2 WHERE Usuario = '" + botonDesactivar + "'");
				panel.actualizarPanel(request, response);
			}
			String botonActivar = request.getParameter("botonActivar");
			if (botonActivar != null) {
				Statement st = conn.createStatement();
				st.executeUpdate("UPDATE usuario SET Estado = 1 WHERE Usuario = '" + botonActivar + "'");
				panel.actualizarPanel(request, response);
			}
			String botonRechazar = request.getParameter("botonRechazar");;
			if (botonRechazar != null) {
				Statement st = conn.createStatement();
				st.executeUpdate("DELETE FROM usuario WHERE Usuario = '" + botonRechazar + "'");
				panel.actualizarPanel(request, response);
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
