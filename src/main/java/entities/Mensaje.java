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
    	setDestinatario(destinatario);
    	setAsunto(asunto);
    	setMensaje(mensaje);
    	setHoraEnvio(horaEnvio);
    	setEstado(estado);
    	setTipoMensaje(tipoMensaje);
    }

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getHoraEnvio() {
		return horaEnvio;
	}

	public void setHoraEnvio(Date horaEnvio) {
		this.horaEnvio = horaEnvio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
}
