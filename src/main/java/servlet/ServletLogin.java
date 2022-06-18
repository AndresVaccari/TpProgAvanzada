package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.EstadoUsuario;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
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
    public ServletLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String br = request.getParameter("br");
		if (br != null) {
			response.sendRedirect("registro.jsp");
		}
		
		try {
			
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario = '" + user + "' AND password = '" + pass + "'");
			
			if (rs.next()) {
				if(rs.getInt(7) == EstadoUsuario.Activo.ordinal()) {
					
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
					//
					request.setAttribute("tipoUsuario", tipoUsuario);
					request.setAttribute("mensaje", nombre + " " + apellido);
					request.setAttribute("usuario", user);
					request.getRequestDispatcher("inicio.jsp").forward(request, response);
				}
				else {
					PrintWriter out = response.getWriter();  
					out.println("<script type=\"text/javascript\">");
					out.println("location='login.jsp';");
					out.println("alert('Usuario inactivo o pendiente de aprobacion');");
					out.println("</script>");
				}
			} else {
				PrintWriter out = response.getWriter();  
				out.println("<script type=\"text/javascript\">");
				out.println("location='login.jsp';");
				out.println("alert('Usuario o contrasenia incorrecta');");
				out.println("</script>");		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
