package Logi;

import java.util.ArrayList;

public class Combos {
  private String codigo;
  private String nombre;
  private float descuento;
  private ArrayList<Componente> misComponentes;
  
public Combos(String codigo, String nombre, float descuento, ArrayList<Componente> misComponentes) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.descuento = descuento;
	this.misComponentes = new ArrayList<Componente>();
	
}

public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public float getDescuento() {
	return descuento;
}
public void setDescuento(float descuento) {
	this.descuento = descuento;
}
public ArrayList<Componente> getMisComponentes() {
	return misComponentes;
}
public void setMisComponentes(ArrayList<Componente> misComponentes) {
	this.misComponentes = misComponentes;
}

	public float calcValCombo() {
	float combo = 0;
	combo = calcPrecioTotal() - calcPrecioTotal() * (descuento/100);
	return combo;
}

	private float calcPrecioTotal() {
	float total = 0;
	for (Componente componente : misComponentes) {
		if (componente != null) {
			total += componente.getPrecio();
		}
	}
	return total;
}

  
}
