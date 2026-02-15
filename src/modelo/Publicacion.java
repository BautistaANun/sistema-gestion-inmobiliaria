package modelo;
import java.time.*;
public class Publicacion {
	
	private int idPublicacion;
	private Propiedad propiedad;
	LocalDate fecha;
	private String tipo;
	private float precio;
	public Publicacion(int idPublicacion, Propiedad propiedad, LocalDate fecha, String tipo, float precio) {
		super();
		this.idPublicacion = idPublicacion;
		this.propiedad = propiedad;
		this.fecha = fecha;
		this.tipo = tipo;
		this.precio = precio;
	}
	public int getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public Propiedad getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
	    return "Publicacion [Propiedad=" + propiedad.getCodigo() +
	           ", fecha=" + fecha +
	           ", tipo=" + tipo +
	           ", precio=" + precio + "]";
	}

}
