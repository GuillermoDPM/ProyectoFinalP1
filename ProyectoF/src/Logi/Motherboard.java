package Logi;

import java.util.ArrayList;

public class Motherboard extends Componente {
 private String marca;
 private String modelo;
 private String tipoConector;
 private String tipoRam;
 private ArrayList<String> misConexiones;
 
public Motherboard(float precio, int cantidadMinima, int cantidadDisponible, int serial, Proveedores proveedor,
		String marca, String modelo, String tipoConector, String tipoRam, ArrayList<String> misConexiones) {
	super(precio, cantidadMinima, cantidadDisponible, serial, proveedor);
	this.marca = marca;
	this.modelo = modelo;
	this.tipoConector = tipoConector;
	this.tipoRam = tipoRam;
	this.misConexiones = misConexiones;
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

public String getTipoRam() {
	return tipoRam;
}

public void setTipoRam(String tipoRam) {
	this.tipoRam = tipoRam;
}

public ArrayList<String> getMisConexiones() {
	return misConexiones;
}

public void setMisConexiones(ArrayList<String> misConexiones) {
	this.misConexiones = misConexiones;
}


 
 
}