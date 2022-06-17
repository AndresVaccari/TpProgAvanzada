package entities;

public class Mensaje {
	private String destinatario;
	private String asunto;
	private String remitente;
	private String mensaje;
	private String estado;
	private String tipoMensaje;
	private int IDMensaje;

	public Mensaje() {

	}

	public Mensaje(String destinatario, String asunto, String remitente,
			String mensaje, String estado, String tipoMensaje, int IDMensaje) {
		setDestinatario(destinatario);
		setAsunto(asunto);
		setRemitente(remitente);
		setMensaje(mensaje);
		setEstado(estado);
		setTipoMensaje(tipoMensaje);
		setIDMensaje(IDMensaje);
	}

	public void setIDMensaje(int IDMensaje) {
		this.IDMensaje = IDMensaje;
	}

	public int getIDMensaje() {
		return IDMensaje;
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
