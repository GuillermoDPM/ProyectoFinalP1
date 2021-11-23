package Logi;

public class Componente {
 protected float precio;
 protected int cantidadMinima;
 protected int cantidadDisponible;
 protected int serial;
 private Proveedores proveedor;
 
public Componente(float precio, int cantidadMinima, int cantidadDisponible, int serial, Proveedores proveedor) {
	super();
	this.precio = precio;
	this.cantidadMinima = cantidadMinima;
	this.cantidadDisponible = cantidadDisponible;
	this.serial = serial;
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

public int getSerial() {
	return serial;
}

public void setSerial(int serial) {
	this.serial = serial;
}

public Proveedores getProveedor() {
	return proveedor;
}

public void setProveedor(Proveedores proveedor) {
	this.proveedor = proveedor;
}
 

 
}
