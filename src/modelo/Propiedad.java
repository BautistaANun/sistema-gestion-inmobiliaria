package modelo;

public abstract class Propiedad {
	protected int idPropiedad;
	protected int codigo;
	protected String direccion;
	protected String localidad;
	protected float superficie;
	public Propiedad(int idPropiedad, int codigo, String direccion, String localidad, float superficie) {
		super();
		this.idPropiedad = idPropiedad;
		this.codigo = codigo;
		this.direccion = direccion;
		this.localidad = localidad;
		this.superficie = superficie;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public float getSuperficie() {
		return superficie;
	}
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	
	public abstract float calcularImpuesto();

	@Override
	public String toString() {
		return "Propiedad [idPropiedad=" + idPropiedad + ", codigo=" + codigo + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", superficie=" + superficie + "]";
	}
	
	
	
}
