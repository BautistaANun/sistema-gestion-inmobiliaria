package modelo;
import java.time.*;
import java.util.*;


public class OperacionInmobiliaria {
	
	private int idOperacion;
	LocalDate fecha;
	private Publicacion publicacion;
	private Cliente cliente;
	private float total;
	
	
	public OperacionInmobiliaria(int idOperacion, LocalDate fecha, Publicacion publicacion, Cliente cliente,
			float total) {
		super();
		this.idOperacion = idOperacion;
		this.fecha = fecha;
		this.publicacion = publicacion;
		this.cliente = cliente;
		this.total = total;
	}
	
	public int getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Publicacion getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
	    return "OperacionInmobiliaria [fecha=" + fecha +
	           ", publicacion=" + publicacion +
	           ", cliente=" + cliente.getDni() +
	           ", total=" + total + "]";
	}

	
	
	
}
