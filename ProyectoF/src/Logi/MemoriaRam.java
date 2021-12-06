package Logi;

public class MemoriaRam extends Componente {
	
	private static final long serialVersionUID = 5L;

  private float capacidadMemoria;
  private String tipoMemoria;
  
public MemoriaRam(String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial,String marca,String modelo, Proveedores proveedor,
		 float capacidadMemoria, String tipoMemoria) {
	super(codigoComponente,precio, cantidadMinima, cantidadDisponible, serial,marca,modelo, proveedor);
	this.capacidadMemoria = capacidadMemoria;
	this.tipoMemoria = tipoMemoria;
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
