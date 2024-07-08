package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;

@View(members=
"solicitante; enunciado; descripcion;tipoDeSolicitud;estadoInicial, estadoSiguiente;"+
"servicioAfectado;documentos;"
)
@Entity@Getter@Setter
public class Incidente extends Solicitud {
	
	
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
	@Column(length=15)
	@ReadOnly
	@DefaultValueCalculator(
			 value=SolicitudInicial.class, // Esta clase calcula el valor inicial
	    	    properties=@PropertyValue(
	        	        name="nombreSolicitud", // La propiedad numeroProducto del calculador...
	        	        value="1") // ... se llena con el valor de producto.numero de la entidad
	        	)
	String tipoDeSolicitud;

	@PostLoad
	private void recalcularEstadoInicial() {
		if(this.estadoSiguiente != null)
		{
			this.estadoInicial = this.estadoSiguiente;
		}
		
	}

}
