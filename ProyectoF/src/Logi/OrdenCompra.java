package Logi;

import java.io.Serializable;
import java.util.Date;

public class OrdenCompra implements Serializable  {
	
	private static final long serialVersionUID = 5L;
	
 private String codigo;
 private Date fecha;
 private String estado;
 private int cantidad;
 private Componente componente;
 private float precioUnitario;
 private Proveedores proveedor;
 private String tipoDePago;
 
public OrdenCompra(String codigo, Date fecha, String estado, int cantidad, Componente componente, float precioUnitario,
		Proveedores proveedor, String tipoDePago) {
	super();
	this.codigo = codigo;
	this.fecha = fecha;
	this.estado = estado;
	this.cantidad = cantidad;
	this.componente = componente;
	this.precioUnitario = precioUnitario;
	this.proveedor = proveedor;
	this.tipoDePago = tipoDePago;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public Componente getComponente() {
	return componente;
}

public void setComponente(Componente componente) {
	this.componente = componente;
}

public float getPrecioUnitario() {
	return precioUnitario;
}

public void setPrecioUnitario(float precioUnitario) {
	this.precioUnitario = precioUnitario;
}

public Proveedores getProveedor() {
	return proveedor;
}

public void setProveedor(Proveedores proveedor) {
	this.proveedor = proveedor;
}

public String getTipoDePago() {
	return tipoDePago;
}

public void setTipoDePago(String tipoDePago) {
	this.tipoDePago = tipoDePago;
}

 
 
}
