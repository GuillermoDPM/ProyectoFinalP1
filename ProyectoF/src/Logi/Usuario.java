package Logi;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 5L;
  private String nombre;
  private String direccion;
  private String telefono;
  private String login;
  private String username;
  private String password;
  
public Usuario(String nombre, String direccion, String telefono, String login, String username, String password) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.login = login;
	this.username = username;
	this.password = password;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
  
  
}
