package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;
//@View(members= "estadoActual;trans;estadoSiguiente;estado;")
@View(members= "estado;")
@Entity @Getter @Setter
public class Incidente {
	
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;
	
	//@Enumerated(EnumType.STRING)
	//@Column(length=20)
	//@Required
	//@DefaultValueCalculator(EstadoInicial.class)
	//@ReadOnly
	//TiposDeEstados estadoActual;
	
	//@Enumerated(EnumType.STRING)
	//@Column(length=20)
	//@ReadOnly
	//@DefaultValueCalculator(EstadoInicial.class)
	//TiposDeEstados estadoSiguiente;
	/*
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@DescriptionsList(descriptionProperties="nombre",
    condition="${nombre} = ?",
    depends="estadoActual")
	@DefaultValueCalculator(
		    value=TransicionInicial.class, // Esta clase calcula el valor inicial
		    		properties=
		    	    @PropertyValue(name="estadoAct", from = "estadoActual")
		)
    Transicion trans;*/
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList(descriptionProperties="nombre",
		    condition="${nombre} = ?",
		    depends="estado")
	//@ElementCollection
	@DefaultValueCalculator(value=EstadosInicial.class)
	//@ListProperties("nombre, estadoPadre, transicion")
	Estados estado;
	/*
	@Depends("estadoActual, trans")  // When the user changes product or quantity
	public TiposDeEstados getEstadoSiguiente() {
		System.out.print("SOY CALCULADA \n");// this property is recalculated and redisplayed
	    if (trans == null) return TiposDeEstados.ABIERTO;
	    return TiposDeEstados.CANCELADO; 
	}*/

}

