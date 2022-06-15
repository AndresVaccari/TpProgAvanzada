package entities;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PanelBandeja {
	public void actualizarPanel(HttpServletRequest request, HttpServletResponse response, String usuario) throws ServletException, IOException {
    	try {
    		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal", "root", "");
        	
        	Statement stContadorMensajes = conn.createStatement();
    		Statement stMensajes = conn.createStatement();
    		ResultSet contadorMensajes = stContadorMensajes.executeQuery("SELECT COUNT(*) FROM mensaje WHERE Destinario ='" + usuario + "' AND TipoMensaje = 'Recibido'");
    		ResultSet mensajes = stMensajes.executeQuery("SELECT * FROM mensaje WHERE Destinario = '" + usuario + "' AND TipoMensaje = 'Recibido'");
    		
    		
    		contadorMensajes.next();
    		int cantidadMensajes = contadorMensajes.getInt(1);	

    		Mensaje [] listaMensajes = new Mensaje[cantidadMensajes];
    		
    		mensajes.next();
    		for (int i = 0; i < listaMensajes.length ; i++) {
    			listaMensajes[i] = new Mensaje(mensajes.getString(1), mensajes.getString(2), mensajes.getString(3), mensajes.getString(4), mensajes.getString(5), mensajes.getString(6));
    			mensajes.next();
    		}
    		
    		//System.out.println(listaMensajes.length);
    		
    		request.setAttribute("mensajes", listaMensajes);
    		request.getRequestDispatcher("bandejaEntrada.jsp").forward(request, response);	
		} catch (Exception e) {
		}
    }
}
