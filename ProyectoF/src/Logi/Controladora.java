package Logi;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

import Logi.Cliente;
import Logi.Factura;

public class Controladora implements Serializable {
	
	private static final long serialVersionUID = 4059652231878894539L;
	
   private ArrayList<Combos> misCombos;
   private ArrayList<Factura> misFacturas;
   private ArrayList<Cliente> misClientes;
   private ArrayList<Componente> misComponentes;
   private ArrayList<Usuario> misUsuarios;
   private ArrayList<Proveedores> misProveedores;
   private ArrayList<OrdenCompra> misOrdenes;
   private int cantidadClientes;
   private int cantidadProveedores;
   private int componentesTotalidad;
   private int cantidadFacturas;
   private int cantidadCombos;
   private int cantidadOrdenes;
   private int cantidadMemoria;
   private int cantidadDiscos;
   private int cantidadMotherboard;
   private int cantidadProcesador;
   private int generadorCodigoOrdenes;
   private int genCodigoFactura;
   private double balance = 0;
   public static Controladora instanciaGlobal = null;

   
private Controladora() {
	super();
	this.misCombos = new ArrayList<Combos>();
	this.misFacturas = new ArrayList<Factura>();
	this.misClientes = new ArrayList<Cliente>();
	this.misComponentes = new ArrayList<Componente>();
	this.misUsuarios = new ArrayList<Usuario>();
	this.misProveedores = new ArrayList<Proveedores>();
	this.misOrdenes = new ArrayList<OrdenCompra>();
	genCodigoFactura=1;
}

public static Controladora getInstance() {
	if(instanciaGlobal==null) {
		instanciaGlobal= new Controladora();
	}		
	return instanciaGlobal;
}



public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
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

public int getCantidadClientes() {
	return cantidadClientes;
}

public void setCantidadClientes(int cantidadClientes) {
	this.cantidadClientes = cantidadClientes;
}

public int getCantidadMemoria() {
	return cantidadMemoria;
}

public void setCantidadMemoria(int cantidadMemoria) {
	this.cantidadMemoria = cantidadMemoria;
}

public ArrayList<Componente> getMisComponentes() {
	return misComponentes;
}

public void setMisComponentes(ArrayList<Componente> misComponentes) {
	this.misComponentes = misComponentes;
}

public int getCantidadDiscos() {
	return cantidadDiscos;
}

public void setCantidadDiscos(int cantidadDiscos) {
	this.cantidadDiscos = cantidadDiscos;
}

public int getCantidadMotherboard() {
	return cantidadMotherboard;
}

public void setCantidadMotherboard(int cantidadMotherboard) {
	this.cantidadMotherboard = cantidadMotherboard;
}

public int getCantidadProcesador() {
	return cantidadProcesador;
}

public void setCantidadProcesador(int cantidadProcesador) {
	this.cantidadProcesador = cantidadProcesador;
}

public ArrayList<Usuario> getMisUsuarios() {
	return misUsuarios;
}

public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
	this.misUsuarios = misUsuarios;
}

public ArrayList<Proveedores> getMisProveedores() {
	return misProveedores;
}

public void setMisProveedores(ArrayList<Proveedores> misProveedores) {
	this.misProveedores = misProveedores;
}

public ArrayList<OrdenCompra> getMisOrdenes() {
	return misOrdenes;
}

public void setMisOrdenes(ArrayList<OrdenCompra> misOrdenes) {
	this.misOrdenes = misOrdenes;
}

public int getCantidadOrdenes() {
	return cantidadOrdenes;
}

public void setCantidadOrdenes(int cantidadOrdenes) {
	this.cantidadOrdenes = cantidadOrdenes;
}

public int getGeneradorCodigoOrdenes() {
	return generadorCodigoOrdenes;
}

public void setGeneradorCodigoOrdenes(int generadorCodigoOrdenes) {
	this.generadorCodigoOrdenes = generadorCodigoOrdenes;
}

public int getGenCodigoFactura() {
	return genCodigoFactura;
}

public void setGenCodigoFactura(int genCodigoFactura) {
	this.genCodigoFactura = genCodigoFactura;
}

public int getCantidadProveedores() {
	return cantidadProveedores;
}

public void setCantidadProveedores(int cantidadProveedores) {
	this.cantidadProveedores = cantidadProveedores;
}

public int getComponentesTotalidad() {
	return componentesTotalidad;
}

public void setComponentesTotalidad(int componentesTotalidad) {
	this.componentesTotalidad = componentesTotalidad;
}

public int getCantidadCombos() {
	return cantidadCombos;
}

public void setCantidadCombos(int cantidadCombos) {
	this.cantidadCombos = cantidadCombos;
}

public int getCantidadFacturas() {
	return cantidadFacturas;
}

public void setCantidadFacturas(int cantidadFacturas) {
	this.cantidadFacturas = cantidadFacturas;
}

public void insertarOrdenCompra(OrdenCompra ordenCompra) {
	misOrdenes.add(ordenCompra);
	setCantidadOrdenes(getCantidadOrdenes()+1);
	cantidadOrdenes++;
}

public void insertarProveedor(Proveedores proveedor) {
	misProveedores.add(proveedor);
	setCantidadProveedores(getCantidadProveedores() + 1);
}

public Proveedores buscarProveedor(String rnc) {
	Proveedores proveedor = null;
	boolean encontrado = false;
	int indexBuscador=0;

	while (!encontrado && indexBuscador<misProveedores.size()) {

		if(misProveedores.get(indexBuscador).getrnc().equalsIgnoreCase(rnc)) {
			proveedor=misProveedores.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return proveedor;
}

public int buscarIndexProveedor(String rnc) {
	int proveedor = -1;
	int i = 0;
	boolean encontrado = false;
	while (!encontrado && i < cantidadProveedores) {
		if(misProveedores.get(i).getrnc().equalsIgnoreCase(rnc)) {
			encontrado = true;
			proveedor = i;
		}
		i++;
	}
	return proveedor;
}

public void modificarProveedor(Proveedores updated) {
	int index = buscarIndexProveedor(updated.getrnc());
	if(index!= -1){
	   misProveedores.set(index, updated);
	}
	
}

public void insertarFacturas(Factura factura) {
	misFacturas.add(factura);
	cantidadFacturas++;
	genCodigoFactura++;
}

public Factura buscarFactura(String codigoFactura) {
	Factura factura = null;
	boolean encontrado = false;
	int indexBuscador=0;

	while (!encontrado && indexBuscador<misFacturas.size()) {

		if(misFacturas.get(indexBuscador).getCodigo().equalsIgnoreCase(codigoFactura)) {
			factura=misFacturas.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return factura;
}

public void insertarClientes(Cliente cliente) {
	misClientes.add(cliente);
	cantidadClientes++;
}

public Cliente buscarCliente(String cedula) {
	Cliente cliente = null;
	boolean encontrado = false;
	int indexBuscador=0;

	while (!encontrado && indexBuscador<misClientes.size()) {

		if(misClientes.get(indexBuscador).getIdentifiacion().equalsIgnoreCase(cedula)) {
			cliente=misClientes.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return cliente;
}

public int buscarIndexCliente(String code) {
	int cliente = -1;
	int i = 0;
	boolean encontrado = false;
	while (!encontrado && i < cantidadClientes) {
		if(misClientes.get(i).getIdentifiacion().equalsIgnoreCase(code)) {
			encontrado = true;
			cliente = i;
		}
		i++;
	}
	return cliente;
}

public void modificarCliente(Cliente updated) {
	int index = buscarIndexCliente(updated.getIdentifiacion());
	if(index!= -1){
	   misClientes.set(index, updated);
	}
	
}

public void insertarComponentes(Componente componente) {
	misComponentes.add(componente);
	
	for (Componente componente1 : misComponentes) {
		if(componente1 instanceof MemoriaRam) {
			setCantidadMemoria(getCantidadMemoria()+1);
		}
		if(componente1 instanceof DiscoDuro) {
			setCantidadDiscos(getCantidadDiscos()+1);
		}
		if(componente1 instanceof Microprocesador) {
			setCantidadProcesador(getCantidadProcesador()+1);
		}
		if(componente1 instanceof Motherboard) {
			setCantidadMotherboard(getCantidadMotherboard()+1);
		}
		
		componentesTotalidad = getCantidadMemoria() + getCantidadDiscos() + getCantidadProcesador() + getCantidadMotherboard();
		
	}
}

public Componente buscarComponenteByCode(String codigo) {
	Componente componente = null;
	boolean encontrado = false;
	int i = 0;
	while (!encontrado && i < misComponentes.size()) {
		if(misComponentes.get(i).getCodigoComponente().equalsIgnoreCase(codigo))
		{
			componente = misComponentes.get(i);
			encontrado = true;
		}
		i++;
	}
	return componente;
	} 

public int buscarIndexComponente(String codigoComponente) {
	int componente = -1;
	int i = 0;
	boolean encontrado = false;
	while (!encontrado && i < componentesTotalidad) {
		if(misComponentes.get(i).getCodigoComponente().equalsIgnoreCase(codigoComponente)) {
			encontrado = true;
			componente = i;
		}
		i++;
	}
	return componente;
}

public void modificarComponente(Componente updated) {
	int index = buscarIndexComponente(updated.getCodigoComponente());
	if(index!= -1){
	   misComponentes.set(index, updated);
	}
}

public void insertarCombos(Combos combo) {
	misCombos.add(combo);
	cantidadCombos++;
}


public Combos buscarCombos(String codigo) {
	Combos combo = null;
	boolean encontrado = false;
	int indexBuscador=0;

	while (!encontrado && indexBuscador<misCombos.size()) {

		if(misCombos.get(indexBuscador).getCodigo().equalsIgnoreCase(codigo)) {
			combo=misCombos.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return combo;
}

public int buscarIndexCombo(String codigoCombo) {
	int combo = -1;
	int i = 0;
	boolean encontrado = false;
	while (!encontrado && i < cantidadCombos) {
		if(misCombos.get(i).getCodigo().equalsIgnoreCase(codigoCombo)) {
			encontrado = true;
			combo = i;
		}
		i++;
	}
	return combo;
}

public void modificarCombo(Combos updated) {
	int index = buscarIndexComponente(updated.getCodigo());
	if(index!= -1){
	   misCombos.set(index, updated);
	}
}

public float preciototalfactura(String codigofactura) 
{
	float preciototal = 0;
	Factura factura = Buscarcodigo(codigofactura);
	preciototal = factura.getPrecioTotal();
	return preciototal;
	
	}

public Factura Buscarcodigo(String codigofactura) {
	Factura factura = null;
	boolean encontrado = false;
	int i = 0;
	while (!encontrado && i <misFacturas.size()) {
		if(misFacturas.get(i).getCodigo().equalsIgnoreCase(codigofactura))
		{
			factura = misFacturas.get(i);
			encontrado = true;
		}
		i++;
	}
	return factura;
	}

public float CreditCliente(Cliente c) {
	float res = 0;
	for(Factura f : misFacturas) {
		if(f.getCliente().getIdentifiacion().equalsIgnoreCase(c.getIdentifiacion()) && !f.isPagado()) {
			res+=f.getPrecioTotal();
		}
	}
	
	return c.getLimiteCredito()-res;
}

public static void setInstanciaGlobal(Controladora instanciaGlobal) {
	Controladora.instanciaGlobal = instanciaGlobal;
}

public ArrayList<String> NombresVendedores() {
	ArrayList<String>nombres = new ArrayList<String>();
	for(Usuario p : misUsuarios) {
		if(p instanceof Usuario) {
			nombres.add(p.getNombre());
		}
	}
	return nombres;
}

public Usuario BuscarUser(String user) {
	Usuario usuario = null;
	boolean encontrado = false;
	int i = 0;
	while (!encontrado && i <misUsuarios.size()) {
		if(misUsuarios.get(i).getNombre().equalsIgnoreCase(user))
		{
			usuario = misUsuarios.get(i);
			encontrado = true;
		}
		i++;
	}
	return usuario;
	}

public void PagarDeudaCliente(Cliente aux) {
	float total=0;
	ArrayList<String>s=new ArrayList<String>();
	for(Factura f : misFacturas) {
		if(f.getCliente().equals(aux) && !f.isPagado()) {
			s.add(f.getCodigo());
			f.setPagado(true);
			total = aux.getLimiteCredito();
		}
	}
	aux.setLimiteCredito(total);
	
}
	
}
