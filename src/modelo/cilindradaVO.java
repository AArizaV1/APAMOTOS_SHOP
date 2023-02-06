package modelo;

public class cilindradaVO {

	// VARIABLES
	int id;
	String nombre;
	int categoria;

	public cilindradaVO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public cilindradaVO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public cilindradaVO() {
		super();
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

	@Override
	public String toString() {
		return "cilindradaVO [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}