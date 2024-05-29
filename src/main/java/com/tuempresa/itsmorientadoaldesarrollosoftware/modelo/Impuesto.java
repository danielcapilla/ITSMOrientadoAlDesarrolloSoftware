package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="nombre" 
	)
@Entity
@Getter @Setter
public class Impuesto {

	@Id
	@Column(length=10)
	String nombre;
}
