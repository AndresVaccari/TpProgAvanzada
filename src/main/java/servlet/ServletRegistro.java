package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class ServletRegistro
 */
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String doc = request.getParameter("doc");
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		
		if (user.equals("") || pass.equals("") || doc.equals("") || name.equals("") || lname.equals("") || email.equals("")) {
			PrintWriter out = response.getWriter();  
			out.println("<script type=\"text/javascript\">");
			out.println("location='registro.jsp';");
			out.println("alert('Debe completar todos lo campos');");
			out.println("</script>");	
		}
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario = '" + user + "'");
			
			if (rs.next()) {
				PrintWriter out = response.getWriter();  
				out.println("<script type=\"text/javascript\">");
				out.println("location='registro.jsp';");
				out.println("alert('Usuario ya existente');");
				out.println("</script>");	
			} else {
				st.executeUpdate("INSERT INTO `usuario`(`Usuario`, `Nombre`, `Apellido`, `Documento`, `Email`, `Password`) VALUES ('" + user + "','" + name + "','" + lname + "','" + doc + "','" + email +"','" + pass +"')");
				PrintWriter out = response.getWriter();  
				out.println("<script type=\"text/javascript\">");
				out.println("location='index.jsp';");
				out.println("alert('Usuario registrado correctamente, En espera de aprobacion');");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
