package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;
import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

import lombok.*;
@View(members= "estadoActual;trans;")
@Tabs({
    @Tab(name = "Abierto", baseCondition = "${transicion}='Crear'"),
})
@Entity @Getter @Setter
public class Incidente {
	
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	@Required
	@DefaultValueCalculator(EstadoInicial.class)
	@ReadOnly
	TiposDeEstados estadoActual;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	@Required
	@ReadOnly
	@DefaultValueCalculator(EstadoInicial.class)
	TiposDeEstados estadoSiguiente;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList(descriptionProperties="nombre",
            condition="${nombre} = ?",
            depends="trans")
    @DefaultValueCalculator(value = TransicionInicial.class)
    Transicion trans;
	

	
	
}

