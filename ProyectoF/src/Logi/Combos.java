package Logi;

import java.util.ArrayList;
import java.io.Serializable;

public class Combos implements Serializable {
	
	private static final long serialVersionUID = 5L;
  private String codigo;
  private String nombre;
  private float descuento;
  private float precioCombo;
  private ArrayList<Componente> misComponentes;
  
public Combos(String codigo, String nombre, float descuento, ArrayList<Componente> misComponentes, float precioCombo) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.descuento = descuento;
	this.misComponentes = new ArrayList<Componente>();
	this.precioCombo = precioCombo;
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

public float getPrecioCombo() {
	return precioCombo;
}

public void setPrecioCombo(float precioCombo) {
	this.precioCombo = precioCombo;
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
