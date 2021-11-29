package Logi;

public class Microprocesador extends Componente {
 private String marca;
 private String modelo;
 private String tipoConector;
 private float velocidad;
 
public Microprocesador(float precio, int cantidadMinima, int cantidadDisponible, int serial, Proveedores proveedor,
		String marca, String modelo, String tipoConector, float velocidad) {
	super(precio, cantidadMinima, cantidadDisponible, serial, proveedor);
	this.marca = marca;
	this.modelo = modelo;
	this.tipoConector = tipoConector;
	this.velocidad = velocidad;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
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