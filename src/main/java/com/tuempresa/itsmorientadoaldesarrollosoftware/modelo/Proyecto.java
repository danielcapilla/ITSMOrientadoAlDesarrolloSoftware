package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;
@View(members=
"nombre,color, icono;"
+ "descripcion;"
+ "estado;" 
+ "fechaDeInicio,fechaFinal;"
+ "clave;"
+ "contactos;"
+ "tags;"
)
@Entity @Getter @Setter
public class Proyecto extends Identificable{
	
	@Column(length=50)
	String descripcion;
	
	@Icon
	@Column(length=40)
	String icono;
	
	// De momento no se como hacerlo
	
	@Column(length=40)
	String color;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	EstadoProyecto estado;
	
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fechaDeInicio;
    
    @Required
    LocalDate fechaFinal;
    
    @Id @Column(length=9)
    String clave;
	 
    @ManyToOne(fetch=FetchType.LAZY, optional = true)
    @DescriptionsList()
	Contacto contactos;
    
    // Mas adelante se tiene que cambiar (creo)
    @Column(length=50)
	String tags;

}
enum EstadoProyecto {
    EN_PROCESO,
    COMPLETADO,
    CANCELADO,
    ESPERANDO,
    PRESUPUESTADO
}