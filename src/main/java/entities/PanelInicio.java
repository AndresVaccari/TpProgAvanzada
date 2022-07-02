package entities;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PanelInicio {
	public void actualizarPanel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			String usuario = session.getAttribute("usuario").toString();
			String tipoUsuario = session.getAttribute("tipoUsuario").toString();
			String nombre = session.getAttribute("nombre").toString();
			String apellido = session.getAttribute("apellido").toString();

			request.setAttribute("tipoUsuario", tipoUsuario);
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("inicio.jsp").forward(request,
					response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
