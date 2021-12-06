package Logi;

public class Componente {
 protected String codigoComponente;
 protected float precio;
 protected int cantidadMinima;
 protected int cantidadDisponible;
 protected String serial;
 private Proveedores proveedor;
 
public Componente(String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial, Proveedores proveedor) {
	super();
	this.codigoComponente = codigoComponente;
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

 

 
}
