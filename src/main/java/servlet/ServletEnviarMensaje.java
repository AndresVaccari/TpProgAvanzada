package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Statement;

import entities.PanelAdmin;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
			
			String botonEnviar = request.getParameter("botonEnviar");
			
			if (botonEnviar != null) {
				Statement st = conn.createStatement();
				st.executeUpdate("DELETE FROM usuario WHERE Usuario = '" + botonRechazar + "'");
				panel.actualizarPanel(request, response);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
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
