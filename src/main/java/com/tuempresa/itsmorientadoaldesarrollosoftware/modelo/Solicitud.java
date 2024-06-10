package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Solicitud {
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
    @Required
	TiposDeSolicitudes tipoDeSolicitud;
	
	@Column(length = 15)
	String estado;
	
	@Column(length = 15)
	String transicion;
	
	@Required
	boolean activo;
	
}

enum TiposDeSolicitudes {
	Asistencia,
	Incidente,
	Problema,
	Cambio
}