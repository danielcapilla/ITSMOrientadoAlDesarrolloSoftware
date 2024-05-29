package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
@View(
members=
"nombre,nif;" +
"basico { basico}" + 
"bancos { bancos}" +
"preferencias { preferencias}" +
"contabilidad { contabilidad}"
)
@Entity @Getter @Setter
public class Contacto extends Identificable{

	@Column(length = 50)
	String nif;
	
	@Embedded
	@ReferenceView("Pedidos1")
	Basico basico;
	
	@Embedded 
	@ReferenceView("Bancos1")
	Bancos bancos;
	
	@Embedded
	@ReferenceView("Preferencias1")
	Preferencias preferencias;
	
	@Embedded
	@ReferenceView("Contabilidad1")
	Contabilidad contabilidad;
}
