package com.sistemaescolar.app.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="datos_alumnos")
public class DatosalaumnosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellidos;
	private String carreras;
	private String clave;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCarreras() {
		return carreras;
	}
	public void setCarreras(String carreras) {
		this.carreras = carreras;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	@Override
	public String toString() {
		return "DatosalaumnosEntity [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", carreras="
				+ carreras + ", clave=" + clave + "]";
	}
	
	
}
