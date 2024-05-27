package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
@View(name = "Simple",
members=
"nombre,nif;" +
"basico { basico}" + 
"bancos { bancos}"	
)
@Entity @Getter @Setter
public class Contacto extends Identificable{

	@Column(length = 50)
	String nif;
	
	@Embedded
	@ReferenceView("Pedidos1")
	Basico basico;
	
	@Embedded
	Bancos bancos;
}
