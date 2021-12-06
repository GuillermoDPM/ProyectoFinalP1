package Logi;

import java.io.Serializable;

public class Proveedores implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
	private String nombre;
	private String rnc;
	private String telefono;
	private String direccion;
	private float cuentaPorPagar;
	
	public Proveedores(String nombre, String rnc, String telefono, String direccion, float cuentaPorPagar) {
		super();
		this.nombre = nombre;
		this.rnc = rnc;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cuentaPorPagar = cuentaPorPagar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getrnc() {
		return rnc;
	}

	public void setRNC(String rnc) {
		this.rnc = rnc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getCuentaPorPagar() {
		return cuentaPorPagar;
	}

	public void setCuentaPorPagar(float cuentaPorPagar) {
		this.cuentaPorPagar = cuentaPorPagar;
	}
	
	

}
