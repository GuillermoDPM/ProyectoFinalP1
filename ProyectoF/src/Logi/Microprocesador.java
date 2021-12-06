package Logi;

public class Microprocesador extends Componente {
	
	private static final long serialVersionUID = 5L;
 private String tipoConector;
 private float velocidad;
 
public Microprocesador(String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial,String marca, String modelo, Proveedores proveedor,
		 String tipoConector, float velocidad) {
	super(codigoComponente,precio, cantidadMinima, cantidadDisponible, serial,marca,modelo, proveedor);
	this.tipoConector = tipoConector;
	this.velocidad = velocidad;
}


public String getTipoConector() {
	return tipoConector;
}

public void setTipoConector(String tipoConector) {
	this.tipoConector = tipoConector;
}

public float getVelocidad() {
	return velocidad;
}

public void setVelocidad(float velocidad) {
	this.velocidad = velocidad;
}


 
 
}
