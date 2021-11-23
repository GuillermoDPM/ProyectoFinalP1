package Logi;

public class MemoriaRam extends Componente {
  private String marca;
  private float capacidadMemoria;
  private String tipoMemoria;
  
public MemoriaRam(float precio, int cantidadMinima, int cantidadDisponible, int serial, Proveedores proveedor,
		String marca, float capacidadMemoria, String tipoMemoria) {
	super(precio, cantidadMinima, cantidadDisponible, serial, proveedor);
	this.marca = marca;
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


  
}
