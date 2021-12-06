package Logi;

public class DiscoDuro extends Componente {
	private static final long serialVersionUID = 5L;
	
 private String tipoConexion;
 private float almacenamiento;
 
public DiscoDuro(String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial,String marca, String modelo, Proveedores proveedor,
		 String tipoConexion, float almacenamiento) {
	super(codigoComponente,precio, cantidadMinima, cantidadDisponible, serial,marca,modelo, proveedor);
	this.tipoConexion = tipoConexion;
	this.almacenamiento = almacenamiento;
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
