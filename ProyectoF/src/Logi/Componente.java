package Logi;

import java.io.Serializable;

public class Componente implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
 protected String codigoComponente;
 protected float precio;
 protected int cantidadMinima;
 protected int cantidadDisponible;
 protected String serial;
 private String marca;
 private String modelo;
 private Proveedores proveedor;
 private int itemsCombo;
 
public Componente(String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial,String marca, String modelo, Proveedores proveedor) {
	super();
	this.codigoComponente = codigoComponente;
	this.precio = precio;
	this.cantidadMinima = cantidadMinima;
	this.cantidadDisponible = cantidadDisponible;
	this.serial = serial;
	this.setMarca(marca);
	this.setModelo(modelo);
	this.proveedor = proveedor;
}

public float getPrecio() {
	return precio;
}

public void setPrecio(float precio) {
	this.precio = precio;
}

public int getCantidadMinima() {
	return cantidadMinima;
}

public void setCantidadMinima(int cantidadMinima) {
	this.cantidadMinima = cantidadMinima;
}

public int getCantidadDisponible() {
	return cantidadDisponible;
}

public void setCantidadDisponible(int cantidadDisponible) {
	this.cantidadDisponible = cantidadDisponible;
}

public String getSerial() {
	return serial;
}

public void setSerial(String serial) {
	this.serial = serial;
}

public Proveedores getProveedor() {
	return proveedor;
}

public void setProveedor(Proveedores proveedor) {
	this.proveedor = proveedor;
}

public String getCodigoComponente() {
	return codigoComponente;
}

public void setCodigoComponente(String codigoComponente) {
	this.codigoComponente = codigoComponente;
}

public int getItemsCombo() {
	return itemsCombo;
}

public void setItemsCombo(int itemsCombo) {
	this.itemsCombo = itemsCombo;
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

 

 
}
