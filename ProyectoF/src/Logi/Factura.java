package Logi;

import java.util.ArrayList;

public class Factura {
 private String codigo;
 private float precioTotal;
 private Usuario vendedor;
 private ArrayList<Combos> misCombos;
 private ArrayList<Componente> misComponentes;
 private Cliente cliente;
 private String tipoDePago;
 private boolean pagado;
 
 public Factura(String codigo, float precioTotal, Usuario vendedor, ArrayList<Combos> misCombos,
			ArrayList<Componente> misComponentes, Cliente cliente, String tipoDePago, boolean pagado) {
		super();
		this.codigo = codigo;
		this.precioTotal = precioTotal;
		this.vendedor = vendedor;
		this.misCombos = new ArrayList<Combos>();
		this.misComponentes = new ArrayList<Componente>();
		this.cliente = cliente;
		this.tipoDePago = tipoDePago;
		this.pagado = pagado;
	}

public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public float getPrecioTotal() {
	return precioTotal;
}
public void setPrecioTotal(float precioTotal) {
	this.precioTotal = precioTotal;
}
public Usuario getVendedor() {
	return vendedor;
}
public void setVendedor(Usuario vendedor) {
	this.vendedor = vendedor;
}
public ArrayList<Combos> getMisCombos() {
	return misCombos;
}
public void setMisCombos(ArrayList<Combos> misCombos) {
	this.misCombos = misCombos;
}
public ArrayList<Componente> getMisComponentes() {
	return misComponentes;
}
public void setMisComponentes(ArrayList<Componente> misComponentes) {
	this.misComponentes = misComponentes;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public String getTipoDePago() {
	return tipoDePago;
}
public void setTipoDePago(String tipoDePago) {
	this.tipoDePago = tipoDePago;
}
public boolean isPagado() {
	return pagado;
}
public void setPagado(boolean pagado) {
	this.pagado = pagado;
}

}
