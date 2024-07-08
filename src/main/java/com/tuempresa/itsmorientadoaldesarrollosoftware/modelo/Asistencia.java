package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;
@View(members=
"solicitante; enunciado; descripcion;estadoInicial, estadoSiguiente;"+
"servicioAfectado;documentos;"
)
@Entity @Getter @Setter
public class Asistencia extends Solicitud {

	
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
