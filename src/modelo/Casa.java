package modelo;

public class Casa extends Propiedad {

    private int cantHabitaciones;
    private boolean tienePatio;

    public Casa(int idPropiedad, int codigo, String direccion,
                String localidad, float superficie,
                int cantHabitaciones, boolean tienePatio) {

        super(idPropiedad, codigo, direccion, localidad, superficie);
        this.cantHabitaciones = cantHabitaciones;
        this.tienePatio = tienePatio;
        
        
    }


	public int getCantHabitaciones() {
		return cantHabitaciones;
	}

	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones = cantHabitaciones;
	}

	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}
	
	@Override
	public float calcularImpuesto() {
	    float impuesto = 10f;

	    if (superficie > 100) {
	        impuesto = impuesto * 1.10f;
	    }
	    return impuesto;
	}

	@Override
	public String toString() {
	    return "Casa [codigo=" + codigo +
	           ", direccion=" + direccion +
	           ", localidad=" + localidad +
	           ", superficie=" + superficie +
	           ", cantHabitaciones=" + cantHabitaciones +
	           ", tienePatio=" + tienePatio + "]";
	}

}
