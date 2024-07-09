package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;
@View(members=
"solicitante; enunciado; descripcion;tipoDeSolicitud;estadoPadre; transicion;"+
"servicioAfectado;documentos;"
)
@Entity @Getter @Setter
public class Cambio  extends Solicitud{

	@ReadOnly
	@Column(length=20)
	String estadoPadre;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList( descriptionProperties="transicion",
		    condition="${estadoPadre}= ? and ${operacion} = 'Cambio'",
		    depends="estadoPadre")
	//@ReferenceView("SoloTrans")
	Estado transicion;
	@Column(length=15)
	@ReadOnly
	@DefaultValueCalculator(
			 value=SolicitudInicial.class, // Esta clase calcula el valor inicial
	    	    properties=@PropertyValue(
	        	        name="nombreSolicitud", // La propiedad numeroProducto del calculador...
	        	        value="3") // ... se llena con el valor de producto.numero de la entidad
	        	)
	String tipoDeSolicitud;

	@PostLoad
	private void recalcularEstadoInicial() {
		if(this.transicion != null)
		{
			this.estadoPadre = this.transicion.getEstado();
		}
		
	}
}
