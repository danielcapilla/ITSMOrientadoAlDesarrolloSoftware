package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
@View( name="Contabilidad1", 
members= 
	"impuestos"+"[#"+"impuestosDeVenta, impuestosDeCompra;" 
    		+ "];"
     +"IdNúmero"+"[#"+"cuentaC, cuentaP;" +  
     "];"
     +"otros"+"[#"+"operacion, modelo;" +  
     "];"
    )
@Embeddable
@Getter @Setter
public class Contabilidad {

	@ManyToOne(fetch=FetchType.LAZY, optional = true)
	@ReferenceView("Simple")
	Impuesto impuestosDeVenta;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = true)
	@ReferenceView("Simple")
	Impuesto impuestosDeCompra;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = true)
	@DescriptionsList()
	@ReferenceView("Simple")
	PlanContable cuentaC;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = true)
	@DescriptionsList()
	@ReferenceView("Simple")
	PlanContable cuentaP;
	
    @Enumerated(EnumType.STRING)
	@Column(length = 15)
    @Required
    TiposDeOperacion operacion;
    
    @Enumerated(EnumType.STRING)
	@Column(length = 2)
    @Required
    TiposDeModelo347 modelo;
	
}
enum TiposDeOperacion {
	General,
	Intracomunitario,
	ImportacionExportacion,
	NoSujeto,
	RecargoEquivalencia;
}
enum TiposDeModelo347 {
	Sí,
	No;
}