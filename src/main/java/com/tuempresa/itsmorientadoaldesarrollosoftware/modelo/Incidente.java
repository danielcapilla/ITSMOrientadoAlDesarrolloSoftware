package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;

@Entity@Getter@Setter
public class Incidente {
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid; // oid para la clase maestra
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DefaultValueCalculator(value=EstadoInicial.class)
	@Required
	@ReadOnly
	Estado estadoInicial;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList(showReferenceView=true, descriptionProperties="estado",
		    condition="${estadoPadre}= ? ",
		    depends="estadoInicial.estado")

	Estado estadoSiguiente;
	
	@PostLoad
	private void recalcularEstadoInicial() {
		if(this.estadoSiguiente != null)
		{
			this.estadoInicial = this.estadoSiguiente;
		}
		
	}

}
