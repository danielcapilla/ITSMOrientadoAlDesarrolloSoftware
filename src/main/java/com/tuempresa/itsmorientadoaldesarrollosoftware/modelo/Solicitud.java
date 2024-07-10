package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;

@Entity @Getter @Setter
public class Solicitud {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList()
	@DefaultValueCalculator(UsuarioInicial.class)
	Usuario solicitante;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList()
	Servicio servicioAfectado;
	
    @Column(length=50) @Required
    String descripcion;
    @Column(length=50) @Required
    String enunciado;
    @Files
    @Column(length=32) 
    String documentos;
    
}
