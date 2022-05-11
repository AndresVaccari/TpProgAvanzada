package servletLogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
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
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM usuario WHERE usuario = '" + user + "' AND password = '" + pass + "'");
			rs.next();
			
			if (rs.getInt(1) == 1) {
				response.sendRedirect("inicio.jsp");
			} else {
				PrintWriter out = response.getWriter();  
				out.println("<script type=\"text/javascript\">");
				out.println("location='index.jsp';");
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
