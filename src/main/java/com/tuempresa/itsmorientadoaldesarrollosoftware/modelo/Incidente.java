package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity@Getter@Setter
public class Incidente {
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid; // oid para la clase maestra
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList(showReferenceView=true, descriptionProperties="estado",
		    condition="${estadoPadre}= ? ",
		    depends="estadoActual.estado")

	//@DefaultValueCalculator(value=EstadoInicial.class)
	//@Required
	Estado estadoActual;

}
