package entities;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PanelAdmin {
	public void actualizarPanel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
        	
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
    		
    		String [] usuariosActivosLista = new String[activos - 1];
    		
    		usuariosActivos.next();
    		for (int i = 0; i < usuariosActivosLista.length ; i++) {
    			if (usuariosActivos.getString(1).equals("admin")) {
    				usuariosActivos.next();
    				i--;
					continue;
				}
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
		} catch (Exception e) {
		}
    }
}
