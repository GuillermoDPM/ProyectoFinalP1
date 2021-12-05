package Logi;

public class Cliente {
 private String nombre;
 private String direccion;
 private String telefono;
 private String tipo;
 private String identifiacion;
 private float limiteCredito;
 private float cuentasPorCobrar;
 
public Cliente(String nombre, String direccion, String telefono, String tipo, String identificacion, float limiteCredito) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.setTipo(tipo);
	this.setIdentifiacion(identificacion);
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

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getIdentifiacion() {
	return identifiacion;
}

public void setIdentifiacion(String identifiacion) {
	this.identifiacion = identifiacion;
}
 
 
 
 
}
