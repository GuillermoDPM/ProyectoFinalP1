package Logi;

public class MemoriaRam extends Componente {
  private String marca;
  private String modelo;
  private float capacidadMemoria;
  private String tipoMemoria;
  
public MemoriaRam(String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial, Proveedores proveedor,
		String marca,String modelo, float capacidadMemoria, String tipoMemoria) {
	super(codigoComponente,precio, cantidadMinima, cantidadDisponible, serial, proveedor);
	this.marca = marca;
	this.setModelo(modelo);
	this.capacidadMemoria = capacidadMemoria;
	this.tipoMemoria = tipoMemoria;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public float getCapacidadMemoria() {
	return capacidadMemoria;
}

public void setCapacidadMemoria(float capacidadMemoria) {
	this.capacidadMemoria = capacidadMemoria;
}

public String getTipoMemoria() {
	return tipoMemoria;
}

public void setTipoMemoria(String tipoMemoria) {
	this.tipoMemoria = tipoMemoria;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}


  
}
