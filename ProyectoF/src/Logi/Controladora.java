package Logi;

import java.util.ArrayList;


public class Controladora {
   private ArrayList<Combos> misCombos;
   private ArrayList<Factura> misFacturas;
   private ArrayList<Cliente> misClientes;
   
   public static Controladora instanciaGlobal = null;

   
private Controladora() {
	super();
	this.misCombos = new ArrayList<Combos>();
	this.misFacturas = new ArrayList<Factura>();
	this.misClientes = new ArrayList<Cliente>();
}

public static Controladora getInstance() {
	if(instanciaGlobal==null) {
		instanciaGlobal= new Controladora();
	}		
	return instanciaGlobal;
}

public ArrayList<Combos> getMisCombos() {
	return misCombos;
}

public void setMisCombos(ArrayList<Combos> misCombos) {
	this.misCombos = misCombos;
}

public ArrayList<Factura> getMisFacturas() {
	return misFacturas;
}

public void setMisFacturas(ArrayList<Factura> misFacturas) {
	this.misFacturas = misFacturas;
}

public ArrayList<Cliente> getMisClientes() {
	return misClientes;
}

public void setMisClientes(ArrayList<Cliente> misClientes) {
	this.misClientes = misClientes;
}

   
	
}
