package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Statement;

import entities.Conexion;
import entities.PanelBandejaEntrada;
import entities.PanelMensaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBandejaEntrada
 */
public class ServletBandejaEntrada extends HttpServlet {

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
	public ServletBandejaEntrada() {
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
			java.sql.Connection conn = Conexion.getConexion();

			String botonLeer = request.getParameter("botonLeer");
			if (botonLeer != null) {
				PanelMensaje panel = new PanelMensaje();
				panel.actualizarPanel(request, response,
						Integer.parseInt(botonLeer), "botonVolverRecibidos");
			}
			String botonBorrar = request.getParameter("botonBorrar");
			if (botonBorrar != null) {
				PanelBandejaEntrada panel = new PanelBandejaEntrada();
				Statement st = conn.createStatement();
				st.executeUpdate("DELETE FROM mensaje WHERE ID = '"
						+ botonBorrar + "' AND TipoMensaje = 'Recibido'");
				panel.actualizarPanel(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//test
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
