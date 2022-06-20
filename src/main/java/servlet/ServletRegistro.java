package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("location='registro.jsp';");
			out.println("alert('Debe completar todos lo campos');");
			out.println("</script>");
		} else {
			if (!(usuario.getClave().equals(clave2))) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("location='registro.jsp';");
				out.println("alert('Las claves no coinciden');");
				out.println("</script>");
			} else {
				try {
					java.sql.Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/tpfinal", "root", "");

					Statement st = conn.createStatement();

					ResultSet rs = st.executeQuery(
							"SELECT * FROM usuario WHERE usuario = '"
									+ usuario.getUsuario() + "'");

					if (rs.next()) {
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("location='registro.jsp';");
						out.println("alert('Usuario ya existente');");
						out.println("</script>");
					} else {
						st.executeUpdate("INSERT INTO `usuario`"
								+ "(`Usuario`, `Nombre`, `Apellido`, `Documento`, `Email`, `Password`, `Estado`) "
								+ "VALUES " + "('" + usuario.getUsuario()
								+ "','" + usuario.getNombre() + "','"
								+ usuario.getApellido() + "','"
								+ usuario.getDocumento() + "','"
								+ usuario.getEmail() + "','"
								+ usuario.getClave() + "','"
								+ usuario.getEstadoUsuario().ordinal() + "')");
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("location='index.jsp';");
						out.println(
								"alert('Usuario registrado correctamente, En espera de aprobacion');");
						out.println("</script>");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
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
