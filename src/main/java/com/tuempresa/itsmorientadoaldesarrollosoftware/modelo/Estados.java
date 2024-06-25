package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
@View(members= "nombre,estadoPadre;transicion;")
@Entity @Getter @Setter
public class Estados {

	@Column(length = 20)
	@Id
	@ReadOnly
	String nombre;
	
	@Column(length = 20)
	@ReadOnly
	String estadoPadre;
	
	@Column(length = 20)
	@Required
	String transicion;
}
