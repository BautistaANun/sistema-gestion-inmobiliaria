package modelo;

import java.util.*;
import java.time.*;

public class Sistema {

	private List<Propiedad> lstPropiedades;
	private List<Cliente> lstClientes;
	private List<Publicacion> lstPublicaciones;
	private List<OperacionInmobiliaria> lstOperacionesInmobiliarias;

	public Sistema(List<Propiedad> lstPropiedades, List<Cliente> lstClientes, List<Publicacion> lstPublicaciones,
			List<OperacionInmobiliaria> lstOperacionesInmobiliarias) {
		super();
		this.lstPropiedades = lstPropiedades;
		this.lstClientes = lstClientes;
		this.lstPublicaciones = lstPublicaciones;
		this.lstOperacionesInmobiliarias = lstOperacionesInmobiliarias;
	}

	public List<Propiedad> getLstPropiedades() {
		return lstPropiedades;
	}

	public void setLstPropiedades(List<Propiedad> lstPropiedades) {
		this.lstPropiedades = lstPropiedades;
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

	public List<Publicacion> getLstPublicaciones() {
		return lstPublicaciones;
	}

	public void setLstPublicaciones(List<Publicacion> lstPublicaciones) {
		this.lstPublicaciones = lstPublicaciones;
	}

	public List<OperacionInmobiliaria> getLstOperacionesInmobiliarias() {
		return lstOperacionesInmobiliarias;
	}

	public void setLstOperacionesInmobiliarias(List<OperacionInmobiliaria> lstOperacionesInmobiliarias) {
		this.lstOperacionesInmobiliarias = lstOperacionesInmobiliarias;
	}

	@Override
	public String toString() {
		return "Sistema [lstPropiedades=" + lstPropiedades + ", lstClientes=" + lstClientes + ", lstPublicaciones="
				+ lstPublicaciones + ", lstOperacionesInmobiliarias=" + lstOperacionesInmobiliarias + "]";
	}

	public Cliente traerCliente(long dni) {
		int i = 0;
		boolean encontrado = false;
		Cliente cliente = null;

		while (i < lstClientes.size() && !encontrado) {
			if (lstClientes.get(i).getDni() == dni) {
				cliente = lstClientes.get(i);
				encontrado = true;
			}
			i++;
		}
		return cliente;
	}

	public boolean agregarCliente(long dni, String nombre, String apellido) {

		if (traerCliente(dni) != null) {
			throw new RuntimeException("Ya existe un cliente con DNI: " + dni);
		}

		int id = calcularNuevoIdCliente();
		Cliente cliente = new Cliente(id, dni, nombre, apellido);
		lstClientes.add(cliente);

		return true;
	}

	private int calcularNuevoIdCliente() {
		if (lstClientes.isEmpty()) {
			return 1;
		} else {
			Cliente ultimo = lstClientes.get(lstClientes.size() - 1);
			return ultimo.getIdCliente() + 1;
		}
	}

	public Propiedad traerPropiedad(int codigo) {
		int i = 0;
		boolean encontrada = false;
		Propiedad propiedad = null;

		while (i < lstPropiedades.size() && !encontrada) {
			if (lstPropiedades.get(i).getCodigo() == codigo) {
				propiedad = lstPropiedades.get(i);
				encontrada = true;
			}
			i++;
		}
		return propiedad;
	}

	public boolean agregarCasa(int codigo, String direccion, String localidad, float superficie, int cantHabitaciones,
			boolean tienePatio) {

		int id = calcularNuevoIdPropiedad();
		Casa casa = new Casa(id, codigo, direccion, localidad, superficie, cantHabitaciones, tienePatio);

		lstPropiedades.add(casa);
		return true;
	}

	private int calcularNuevoIdPropiedad() {
		if (lstPropiedades.isEmpty()) {
			return 1;
		} else {
			Propiedad ultima = lstPropiedades.get(lstPropiedades.size() - 1);
			return ultima.getIdPropiedad() + 1;
		}
	}

	public boolean agregarDepartamento(int codigo, String direccion, String localidad, float superficie, int piso,
			int numero, boolean tieneBalcon) {

		int id = calcularNuevoIdPropiedad();
		Departamento depto = new Departamento(id, codigo, direccion, localidad, superficie, piso, numero, tieneBalcon);

		lstPropiedades.add(depto);
		return true;
	}

	public Publicacion traerPublicacion(Propiedad propiedad, String tipo) {

		Publicacion encontrada = null;
		int i = 0;
		boolean encontrado = false;

		while (i < lstPublicaciones.size() && !encontrado) {

			Publicacion p = lstPublicaciones.get(i);

			if (p.getPropiedad().equals(propiedad) && p.getTipo().equalsIgnoreCase(tipo)) {
				encontrada = p;
				encontrado = true;
			}

			i++;
		}

		return encontrada;
	}

	private int calcularNuevoIdPublicacion() {
		if (lstPublicaciones.isEmpty()) {
			return 1;
		} else {
			Publicacion ultima = lstPublicaciones.get(lstPublicaciones.size() - 1);
			return ultima.getIdPublicacion() + 1;
		}
	}

	public boolean agregarPublicacion(Propiedad propiedad, LocalDate fecha, String tipo, float precio) {

		if (precio <= 0) {
			throw new IllegalArgumentException("El precio debe ser mayor a 0");
		}

		int id = calcularNuevoIdPublicacion();
		Publicacion p = new Publicacion(id, propiedad, fecha, tipo, precio);
		lstPublicaciones.add(p);

		return true;
	}

	private int calcularNuevoIdOperacion() {
		if (lstOperacionesInmobiliarias.isEmpty()) {
			return 1;
		} else {
			OperacionInmobiliaria ultima = lstOperacionesInmobiliarias.get(lstOperacionesInmobiliarias.size() - 1);
			return ultima.getIdOperacion() + 1;
		}
	}

	public boolean agregarOperacionInmobiliaria(LocalDate fecha, Publicacion publicacion, Cliente cliente) {

		int id = calcularNuevoIdOperacion();

		float precio = publicacion.getPrecio();
		float impuesto = publicacion.getPropiedad().calcularImpuesto();
		float total = precio + impuesto;

		OperacionInmobiliaria op = new OperacionInmobiliaria(id, fecha, publicacion, cliente, total);

		lstOperacionesInmobiliarias.add(op);

		return true;
	}

	public List<Publicacion> traerPublicacionesPorFecha(LocalDate fechaDesde, LocalDate fechaHasta) {

		List<Publicacion> resultado = new ArrayList<>();
		int i = 0;

		while (i < lstPublicaciones.size()) {

			Publicacion p = lstPublicaciones.get(i);
			LocalDate fecha = p.getFecha();

			if ((fecha.isEqual(fechaDesde) || fecha.isAfter(fechaDesde))
					&& (fecha.isEqual(fechaHasta) || fecha.isBefore(fechaHasta))) {

				resultado.add(p);
			}

			i++;
		}

		return resultado;
	}

	public List<Publicacion> traerPublicacionesDeCasas(LocalDate fechaDesde, LocalDate fechaHasta,
			int cantHabitaciones) {

		List<Publicacion> resultado = new ArrayList<>();
		int i = 0;

		while (i < lstPublicaciones.size()) {

			Publicacion p = lstPublicaciones.get(i);
			LocalDate fecha = p.getFecha();
			Propiedad prop = p.getPropiedad();

			boolean fechaOk = (fecha.isEqual(fechaDesde) || fecha.isAfter(fechaDesde))
					&& (fecha.isEqual(fechaHasta) || fecha.isBefore(fechaHasta));

			if (fechaOk && prop instanceof Casa) {

				Casa casa = (Casa) prop;

				if (casa.getCantHabitaciones() >= cantHabitaciones) {
					resultado.add(p);
				}
			}

			i++;
		}

		return resultado;
	}
	
	public List<Cliente> traerClientesConOperacionesInmobiliarias(String tipo) {

	    List<Cliente> resultado = new ArrayList<>();
	    int i = 0;

	    while (i < lstOperacionesInmobiliarias.size()) {

	        OperacionInmobiliaria op = lstOperacionesInmobiliarias.get(i);
	        Publicacion pub = op.getPublicacion();

	        if (pub.getTipo().equalsIgnoreCase(tipo)) {

	            Cliente c = op.getCliente();

	            if (!resultado.contains(c)) {
	                resultado.add(c);
	            }
	        }

	        i++;
	    }

	    return resultado;
	}


}
