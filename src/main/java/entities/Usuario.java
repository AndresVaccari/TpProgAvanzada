package entities;

public class Usuario {
	
	private String usuario;
	private String clave;
	private String nombre;
	private String apellido;
	private String documento;
	private String email;
	private EstadoUsuario estado;

    public Usuario(){
    	
    }
	
    public Usuario(String usuario, String clave, String nombre, String apellido, String documento, String email, EstadoUsuario estado){
    	setUsuario(usuario);
    	setClave(clave);
    	setNombre(nombre);
    	setApellido(apellido);
    	setDocumento(documento);
    	setEmail(email);
    	setEstadoUsuario(estado);
    }
    
    public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoUsuario getEstadoUsuario() {
		return estado;
	}
    
	public void setEstadoUsuario(EstadoUsuario estado) {
		this.estado = estado;
	}
}