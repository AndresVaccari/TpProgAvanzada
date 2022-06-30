package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.EstadoUsuario;
import entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRegistro
 */
public class ServletRegistro extends HttpServlet {
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
	public ServletRegistro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email_regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		Usuario usuario = new Usuario();
		usuario.setUsuario(request.getParameter("user"));
		usuario.setClave(request.getParameter("pass"));
		String clave2 = (request.getParameter("pass2"));
		usuario.setDocumento(request.getParameter("doc"));
		usuario.setNombre(request.getParameter("name"));
		usuario.setApellido(request.getParameter("lname"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setEstadoUsuario(EstadoUsuario.Pendiente);

		if (usuario.getUsuario().equals("") || usuario.getClave().equals("")
				|| usuario.getDocumento().equals("")
				|| usuario.getNombre().equals("")
				|| usuario.getApellido().equals("")
				|| usuario.getEmail().equals("")) {
			String mensaje = "Debe completar todos lo campos";
			String color = "bg-danger";
			request.setAttribute("color", color);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("registro.jsp").forward(request,
					response);
		} else {
			try {
				java.sql.Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/tpfinal", "root", "");

				Statement st = conn.createStatement();

				ResultSet rs = st
						.executeQuery("SELECT * FROM usuario WHERE usuario = '"
								+ usuario.getUsuario() + "'");

				if (rs.next()) {
					String mensaje = "Usuario ya existente";
					String color = "bg-danger";
					request.setAttribute("color", color);
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("registro.jsp")
							.forward(request, response);
				} else if (!(usuario.getClave().equals(clave2))) {
					String mensaje = "Las claves no coinciden";
					String color = "bg-danger";
					request.setAttribute("color", color);
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("registro.jsp")
							.forward(request, response);
				} else if (!usuario.getEmail().matches(email_regex)) {
					String mensaje = "Ingrese un mail valido";
					String color = "bg-danger";
					request.setAttribute("color", color);
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("registro.jsp")
							.forward(request, response);
				} else {
					st.executeUpdate("INSERT INTO `usuario`"
							+ "(`Usuario`, `Nombre`, `Apellido`, `Documento`, `Email`, `Password`, `Estado`) "
							+ "VALUES " + "('" + usuario.getUsuario() + "','"
							+ usuario.getNombre() + "','"
							+ usuario.getApellido() + "','"
							+ usuario.getDocumento() + "','"
							+ usuario.getEmail() + "','" + usuario.getClave()
							+ "','" + usuario.getEstadoUsuario().ordinal()
							+ "')");
					String mensaje = "Usuario registrado correctamente";
					String color = "bg-success";
					request.setAttribute("color", color);
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("registro.jsp")
							.forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

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
