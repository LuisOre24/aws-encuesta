package com.ore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ENCUESTA")
public class Encuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEncuesta;
	
	@Column(name = "nombre", nullable = false, length = 70)
	@Size(min = 3)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 70)
	@Size(min = 3)
	private String apellido;
	
	@Column(name = "profesion", nullable = false, length = 90)
	@Size(min = 3)
	private String profesion;
	
	@Column(name = "trabajo", nullable = true, length = 120)
	@Size(min = 3)
	private String lugarTrabajo;
	
	@ManyToOne
	@JoinColumn(name = "id_lenguaje", nullable = false, foreignKey = @ForeignKey(name = "fk_encuesta_lenguaje"))
	private LenguajeProgramacion listaLenguaje;
	
	
	public Integer getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public String getLugarTrabajo() {
		return lugarTrabajo;
	}
	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}
	public LenguajeProgramacion getListaLenguaje() {
		return listaLenguaje;
	}
	public void setListaLenguaje(LenguajeProgramacion listaLenguaje) {
		this.listaLenguaje = listaLenguaje;
	}
	
	
	
}
