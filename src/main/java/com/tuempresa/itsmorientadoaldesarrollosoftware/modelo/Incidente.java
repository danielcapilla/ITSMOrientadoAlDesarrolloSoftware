package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;

@View(members= "estado;numero")
@Entity @Getter @Setter
public class Incidente {
	
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;

	@ReadOnly
	int numero;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList(descriptionProperties="nombre",
			condition = "${nombre} = ?",
            depends = "estado")
	
	@DefaultValueCalculator(value=EstadosInicial.class,
			properties=@PropertyValue(
	    	        name="estadoP", 
	    	        from="estado"))
	Estados estado;
	
	@PrePersist
	private void calcularEstadoPadre() {
		this.numero = 100;
	}


}

