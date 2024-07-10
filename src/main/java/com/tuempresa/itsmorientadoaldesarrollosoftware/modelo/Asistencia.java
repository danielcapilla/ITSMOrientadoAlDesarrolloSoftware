package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;
import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

import lombok.*;
@View(members=
"solicitante; enunciado; descripcion;tipoDeSolicitud;estadoPadre; transicion;"+
"servicioAfectado;documentos;operacion;"
)
@Entity @Getter @Setter
public class Asistencia extends Solicitud {

	@ReadOnly
	@Column(length=20)
	String estadoPadre;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList( descriptionProperties="transicion",
		    condition="${estadoPadre}= ? and ${operacion} = 'Asistencia'",
		    depends="estadoPadre")
	//@ReferenceView("SoloTrans")
	Estado transicion;
	@Column(length=15)
	@ReadOnly
	@DefaultValueCalculator(
			 value=SolicitudInicial.class, // Esta clase calcula el valor inicial
	    	    properties=@PropertyValue(
	        	        name="nombreSolicitud", // La propiedad numeroProducto del calculador...
	        	        value="2") // ... se llena con el valor de producto.numero de la entidad
	        	)
	String tipoDeSolicitud;
    @Column(length=32) 
    @ReadOnly
    TiposDeSolicitud operacion;
	@PostLoad
	private void recalcularEstadoInicial() {
		if(this.transicion != null)
		{
			this.estadoPadre = this.transicion.getEstado();
		}
		
	}
}
