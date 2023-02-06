package modelo;

public class articuloVO {

	String nombre;
	String descripcion;
	float precio;
	String codigo;
	int categoria;
	int cilindrada;
	String idCliente;

	public articuloVO(String nombre, String descripcion, float precio, String codigo, int categoria, String idCliente) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
		this.categoria = categoria;
		this.idCliente = idCliente;

	}

	public articuloVO(String nombre, String descripcion, float precio, String codigo, int categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
		this.categoria = categoria;

	}

	public articuloVO(String nombre, String descripcion, float precio, String codigo, int categoria, int cilindrada) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
		this.categoria = categoria;
		this.cilindrada = cilindrada;

	}

	public articuloVO(String nombre, String descripcion, float precio, String codigo, int categoria, int cilindrada,
			String idCliente) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
		this.categoria = categoria;
		this.cilindrada = cilindrada;
		this.idCliente = idCliente;
	}

	public articuloVO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "articuloVO [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", codigo="
				+ codigo + ", categoria=" + categoria + ", cilindrada=" + cilindrada + ", idCliente=" + idCliente
				+ ", getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion() + ", getPrecio()="
				+ getPrecio() + ", getCodigo()=" + getCodigo() + ", getCategoria()=" + getCategoria()
				+ ", getIdCliente()=" + getIdCliente() + ", getCilindrada()=" + getCilindrada() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
