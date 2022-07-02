package entities;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PanelMensaje {
	public void actualizarPanel(HttpServletRequest request,
			HttpServletResponse response, int IDMensaje, String nameVolver)
			throws ServletException, IOException {
		try {
			java.sql.Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tpfinal", "root", "");

			Statement stMensaje = conn.createStatement();
			ResultSet mensaje = stMensaje.executeQuery(
					"SELECT * FROM mensaje WHERE ID = '" + IDMensaje + "'");

			if (nameVolver.equals("botonVolverRecibidos")) {
				Statement stActualizarEstado = conn.createStatement();
				stActualizarEstado.executeUpdate(
						"UPDATE mensaje SET Estado = 'Leido' WHERE ID = '"
								+ IDMensaje + "'");
			}

			mensaje.next();

			Mensaje MensajeRecibido = new Mensaje(mensaje.getString(1),
					mensaje.getString(2), mensaje.getString(3),
					mensaje.getString(4), mensaje.getString(5),
					mensaje.getString(6), mensaje.getInt(7));

			request.setAttribute("nameVolver", nameVolver);
			request.setAttribute("mensaje", MensajeRecibido);
			request.getRequestDispatcher("mensaje.jsp").forward(request,
					response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
