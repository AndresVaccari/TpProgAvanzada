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
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE 'Estado' = 0" );
			
			String be = request.getParameter("be");
			if (be != null) {
				response.sendRedirect("registro.jsp");
			}
			String bb = request.getParameter("bb");
			if (bb != null) {
				response.sendRedirect("login.jsp");
			}
			String ba = request.getParameter("ba");
			if (ba != null) {
				String listado = "";
				while (rs.next()) {
					if (rs.getInt(7) != 0) {
						continue;
					}
					String user = rs.getString(1);
					if (rs.next()) {
						listado += "<li>" + user + " <input type=\"checkbox\"> </li>";
					}
				}		
				request.setAttribute("listado", listado);
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
