package modelo;

public class Departamento extends Propiedad {

    private int piso;
    private int numero;
    private boolean tieneBalcon;

    public Departamento(int idPropiedad, int codigo, String direccion,
                         String localidad, float superficie,
                         int piso, int numero, boolean tieneBalcon) {

        super(idPropiedad, codigo, direccion, localidad, superficie);
        this.piso = piso;
        this.numero = numero;
        this.tieneBalcon = tieneBalcon;
    }

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isTieneBalcon() {
		return tieneBalcon;
	}

	public void setTieneBalcon(boolean tieneBalcon) {
		this.tieneBalcon = tieneBalcon;
	}
	
	@Override
	public float calcularImpuesto() {
	    float impuesto = 5f;

	    if (tieneBalcon) {
	        impuesto = impuesto * 1.05f;
	    }
	    return impuesto;
	}

	@Override
	public String toString() {
	    return "Departamento [codigo=" + codigo +
	           ", direccion=" + direccion +
	           ", localidad=" + localidad +
	           ", superficie=" + superficie +
	           ", piso=" + piso +
	           ", numero=" + numero +
	           ", tieneBalcon=" + tieneBalcon + "]";
	}

	
}
