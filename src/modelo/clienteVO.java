package modelo;

public class clienteVO {

	int id;
	String nombre;
	int edad;
	String correo;
	String telefono;
	String contrasena;
	int codigo;
	boolean alta;
	int tipo;
	String ciudad;
	String documento;

	public clienteVO(int id, String nombre, int edad, String correo, String telefono, String contrasena, int codigo,
			boolean alta, int tipo, String ciudad, String documento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.codigo = codigo;
		this.alta = alta;
		this.tipo = tipo;
		this.ciudad = ciudad;
		this.documento = documento;
	}

	public clienteVO(String nombre, int edad, String correo, String telefono, String contrasena, int codigo,
			boolean alta, int tipo, String ciudad, String documento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.codigo = codigo;
		this.alta = alta;
		this.tipo = tipo;
		this.ciudad = ciudad;
		this.documento = documento;
	}

	public clienteVO(String nombre, int edad, String correo, String telefono, String ciudad, String documento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.documento = documento;
	}

	// CORRECTO
	public clienteVO(int id, String documento, String nombre, int edad, String ciudad, String correo, String telefono,
			String contrasena) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasena = contrasena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "clienteVO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", correo=" + correo + ", telefono="
				+ telefono + ", contrasena=" + contrasena + ", codigo=" + codigo + ", alta=" + alta + ", tipo=" + tipo
				+ ", ciudad=" + ciudad + ", documento=" + documento + ", getId()=" + getId() + ", getNombre()="
				+ getNombre() + ", getEdad()=" + getEdad() + ", getCorreo()=" + getCorreo() + ", getTelefono()="
				+ getTelefono() + ", getContrasena()=" + getContrasena() + ", getCodigo()=" + getCodigo()
				+ ", isAlta()=" + isAlta() + ", getTipo()=" + getTipo() + ", getCiudad()=" + getCiudad()
				+ ", getDocumento()=" + getDocumento() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}