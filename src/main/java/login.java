import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login {
	public static void main(String[] args) {
		try {
			String nombre = "admin";
			String pass = "admin";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT nombre FROM usuario WHERE usuario = " nombre " AND password = " pass);
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
