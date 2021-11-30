package Logi;

public class Cliente {
 private String codigoCliente;
 private String nombre;
 private String direccion;
 private String telefono;
 private String rnc;
 private String cedula;
 private float limiteCredito;
 private float cuentasPorCobrar;
 
public Cliente(String nombre, String direccion, String telefono, String rnc, String cedula, float limiteCredito) {
	super();
	this.setCodigoCliente(codigoCliente);
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.rnc = rnc;
	this.cedula = cedula;
	this.limiteCredito = limiteCredito;
	this.cuentasPorCobrar = 0;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getRnc() {
	return rnc;
}

public void setRnc(String rnc) {
	this.rnc = rnc;
}

public String getCedula() {
	return cedula;
}

public void setCedula(String cedula) {
	this.cedula = cedula;
}

public float getLimiteCredito() {
	return limiteCredito;
}

public void setLimiteCredito(float limiteCredito) {
	this.limiteCredito = limiteCredito;
}

public float getCuentasPorCobrar() {
	return cuentasPorCobrar;
}

public void setCuentasPorCobrar(float cuentasPorCobrar) {
	this.cuentasPorCobrar = cuentasPorCobrar;
}

public String getCodigoCliente() {
	return codigoCliente;
}

public void setCodigoCliente(String codigoCliente) {
	this.codigoCliente = codigoCliente;
}
 
 
 
 
}
