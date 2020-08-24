package com.ore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LENGUAJE")
public class LenguajeProgramacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLenguaje;
	
	@Column(name = "lenguaje", nullable = false, length = 70)
	@Size(min = 2)
	private String lenguaje;
	
	
	public Integer getIdLenguaje() {
		return idLenguaje;
	}
	public void setIdLenguaje(Integer idLenguaje) {
		this.idLenguaje = idLenguaje;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	
	
}
