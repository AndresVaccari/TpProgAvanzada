package entities;

import java.sql.Date;

public class Mensaje {
	private String destinatario;
	private String asunto;
	private String remitente;
	private String mensaje;
	private Date horaEnvio;
	private String estado;
	private String tipoMensaje;

    public Mensaje(){
    	
    }
	
    public Mensaje(String destinatario, String asunto, String mensaje, Date horaEnvio, String estado, String tipoMensaje)
    {
    	this.destinatario = destinatario;
    	this.asunto = asunto;
    	this.mensaje = mensaje;
    	this.horaEnvio = horaEnvio;
    	this.estado = estado;
    	this.tipoMensaje = tipoMensaje;
    }
}
