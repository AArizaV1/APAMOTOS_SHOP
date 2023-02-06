package modelo;

public class categoriaVO {

	int id;
	String nombre;

	public categoriaVO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public categoriaVO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public categoriaVO() {
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
		return "categoriaVO [id=" + id + ", nombre=" + nombre + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
