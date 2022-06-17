package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.Mensaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEnviarMensaje
 */
public class ServletEnviarMensaje extends HttpServlet {
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
	public ServletEnviarMensaje() {
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

			java.sql.Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tpfinal", "root", "");

			String botonEnviar = request.getParameter("botonEnviar");

			if (botonEnviar != null) {

				Statement stUltimoID = conn.createStatement();
				ResultSet ultimoID = stUltimoID.executeQuery(
						"SELECT * FROM mensaje ORDER BY ID DESC LIMIT 1");

				Mensaje mensaje = new Mensaje();
				mensaje.setDestinatario(request.getParameter("destinatario"));
				mensaje.setAsunto(request.getParameter("asunto"));
				mensaje.setRemitente(botonEnviar);
				mensaje.setMensaje(request.getParameter("mensaje"));
				mensaje.setEstado("NoLeido");
				mensaje.setTipoMensaje("Enviado");
				if (ultimoID.next()) {
					mensaje.setIDMensaje(ultimoID.getInt(7) + 1);
				} else {
					mensaje.setIDMensaje(0);
				}
				Statement st = conn.createStatement();
				System.out.println("Primer mensaje");
				st.executeUpdate("INSERT INTO `mensaje`"
						+ "(`Destinario`, `Asunto`, `Remitente`, `Mensaje`, `Estado`, `TipoMensaje`, `ID`) "
						+ "VALUES " + "('" + mensaje.getDestinatario() + "','"
						+ mensaje.getAsunto() + "','" + mensaje.getRemitente()
						+ "','" + mensaje.getMensaje() + "','"
						+ mensaje.getEstado() + "','" + mensaje.getTipoMensaje()
						+ "','" + mensaje.getIDMensaje() + "')");
				System.out.println("Segundo mensaje");
				st.executeUpdate("INSERT INTO `mensaje`"
						+ "(`Destinario`, `Asunto`, `Remitente`, `Mensaje`, `Estado`, `TipoMensaje`, `ID`) "
						+ "VALUES " + "('" + mensaje.getDestinatario() + "','"
						+ mensaje.getAsunto() + "','" + mensaje.getRemitente()
						+ "','" + mensaje.getMensaje() + "','"
						+ mensaje.getEstado() + "', 'Recibido', '"
						+ mensaje.getIDMensaje() + "')");
				// panel.actualizarPanel(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
