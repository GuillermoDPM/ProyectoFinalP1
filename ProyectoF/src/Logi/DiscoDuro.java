package Logi;

public class DiscoDuro extends Componente {
	private static final long serialVersionUID = 5L;
	
 private String marca;
 private String modelo;
 private String tipoConexion;
 private float almacenamiento;
 
public DiscoDuro(String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial, Proveedores proveedor,
		String marca, String modelo, String tipoConexion, float almacenamiento) {
	super(codigoComponente,precio, cantidadMinima, cantidadDisponible, serial, proveedor);
	this.marca = marca;
	this.modelo = modelo;
	this.tipoConexion = tipoConexion;
	this.almacenamiento = almacenamiento;
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

public String getTipoConexion() {
	return tipoConexion;
}

public void setTipoConexion(String tipoConexion) {
	this.tipoConexion = tipoConexion;
}

public float getAlmacenamiento() {
	return almacenamiento;
}

public void setAlmacenamiento(float almacenamiento) {
	this.almacenamiento = almacenamiento;
}


 
 
}
