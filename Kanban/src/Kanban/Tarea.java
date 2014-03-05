package Kanban;

import java.util.Date;

public class Tarea {
	private String despcripcion;
	private Estado estado;
	private String categoria;
	private int prioridad;
	private String propietario;
	private Date fechaDeEntrega;
	private Date fechaDeCreacion;
	public String getDespcripcion() {
		return despcripcion;
	}
	public void setDespcripcion(String despcripcion) {
		this.despcripcion = despcripcion;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado doTo) {
		this.estado=doTo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria.toUpperCase().trim();//Categoría a mayúscula y quitar espacios
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public Date getFechaDeEntrega() {
		return fechaDeEntrega;
	}
	public void setFechaDeEntrega(Date fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
	}
	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	
	
}