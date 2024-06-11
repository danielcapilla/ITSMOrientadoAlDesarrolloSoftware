package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Solicitud {
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;
	
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