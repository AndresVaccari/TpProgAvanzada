package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
			
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE 'Estado' = 0" );
			
			String botonMensajes = request.getParameter("botonMensajes");
			if (botonMensajes != null) {
				response.sendRedirect("registro.jsp");
			}
			String botonBandeja = request.getParameter("botonBandeja");
			if (botonBandeja != null) {
				response.sendRedirect("login.jsp");
			}
			String botonAdmin = request.getParameter("botonAdmin");
			if (botonAdmin != null) {
				Statement stContadorPendientes = conn.createStatement();
				Statement stPendientes = conn.createStatement();
				ResultSet contadorPentientes = stContadorPendientes.executeQuery("SELECT COUNT(*) FROM usuario WHERE Estado = 0" );
				ResultSet usuariosPendientes = stPendientes.executeQuery("SELECT usuario FROM usuario WHERE Estado = 0" );
				
				Statement stContadorActivos = conn.createStatement();
				Statement stActivos = conn.createStatement();
				ResultSet contadorActivos = stContadorActivos.executeQuery("SELECT COUNT(*) FROM usuario WHERE Estado = 1" );
				ResultSet usuariosActivos = stActivos.executeQuery("SELECT usuario FROM usuario WHERE Estado = 1" );
				
				Statement stContadorInactivos = conn.createStatement();
				Statement stInactivos = conn.createStatement();
				ResultSet contadorInactivos = stContadorInactivos.executeQuery("SELECT COUNT(*) FROM usuario WHERE Estado = 2" );		
				ResultSet usuariosInactivos = stInactivos.executeQuery("SELECT usuario FROM usuario WHERE Estado = 2" );		
				
				contadorPentientes.next();
				int pendientes = contadorPentientes.getInt(1);	
				
				contadorActivos.next();
				int activos = contadorActivos.getInt(1);

				contadorInactivos.next();
				int inactivos = contadorInactivos.getInt(1);

				String [] usuariosPendientesLista = new String[pendientes];
				
				usuariosPendientes.next();
				for (int i = 0; i < usuariosPendientesLista.length ; i++) {
					usuariosPendientesLista[i] = usuariosPendientes.getString(1);
					usuariosPendientes.next();
				}
				
				String [] usuariosActivosLista = new String[activos];
				
				usuariosActivos.next();
				for (int i = 0; i < usuariosActivosLista.length ; i++) {
					usuariosActivosLista[i] = usuariosActivos.getString(1);
					usuariosActivos.next();
				}
				
				String [] usuariosInactivosLista;
				boolean hayInactivos;
				
				if (inactivos != 0) {
					usuariosInactivosLista = new String[inactivos];
					usuariosInactivos.next();
					for (int i = 0; i < usuariosInactivosLista.length ; i++) {
						usuariosInactivosLista[i] = usuariosInactivos.getString(1);
						usuariosInactivos.next();
					}
					hayInactivos = true;
					request.setAttribute("usuariosInactivos", usuariosInactivosLista);
				} else {
					usuariosInactivosLista = new String[1];
					usuariosInactivosLista[0] = "No hay usuarios inactivos";
					hayInactivos = false;
				}
				
				request.setAttribute("usuariosActivos", usuariosActivosLista);
				request.setAttribute("usuariosPendientes", usuariosPendientesLista);
				request.setAttribute("hayInactivos", hayInactivos);
				request.setAttribute("usuariosInactivos", usuariosInactivosLista);
				request.getRequestDispatcher("adminpanel.jsp").forward(request, response);		
				
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
