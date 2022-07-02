package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.Conexion;
import entities.EstadoUsuario;
import entities.PanelInicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
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
	public ServletLogin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String br = request.getParameter("br");
		if (br != null) {
			response.sendRedirect("registro.jsp");
		}

		try {

			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			java.sql.Connection conn = Conexion.getConexion();

			Statement st = conn.createStatement();

			ResultSet rs = st
					.executeQuery("SELECT * FROM usuario WHERE usuario = '"
							+ user + "' AND password = '" + pass + "'");

			if (rs.next()) {
				if (rs.getInt(7) == EstadoUsuario.Activo.ordinal()) {

					HttpSession session = request.getSession();

					String nombre = rs.getString(2);
					String apellido = rs.getString(3);
					String tipoUsuario;
					if (rs.getString(1).equals("admin")) {
						tipoUsuario = "admin";
					} else {
						tipoUsuario = "user";
					}
					//
					session.setAttribute("usuario", user);
					session.setAttribute("tipoUsuario", tipoUsuario);
					session.setAttribute("nombre", nombre);
					session.setAttribute("apellido", apellido);
					//
					PanelInicio panel = new PanelInicio();
					panel.actualizarPanel(request, response);
				} else {
					String mensaje = "Usuario inactivo o pendiente de aprobacion";
					String color = "bg-danger";
					request.setAttribute("color", color);
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				}
			} else {
				String mensaje = "Usuario o contraseña incorrecta";
				String color = "bg-danger";
				request.setAttribute("color", color);
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
