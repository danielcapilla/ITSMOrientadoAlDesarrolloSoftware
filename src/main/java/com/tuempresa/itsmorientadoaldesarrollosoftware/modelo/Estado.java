package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

import lombok.*;
@View( name="SoloTrans", 
members=                        
    "estado;" 
)
@Entity@Getter@Setter
public class Estado {

	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid; // oid para la clase maestra
	
	@Column(length=25)
	@Required
	String estado;
	
	@Column(length=25)
	String estadoPadre;
	
	@Column(length=25)
	@Required
	String transicion;
	
    @Enumerated(EnumType.STRING)
	@Column(length = 15)
    @Required
    TiposDeSolicitud operacion;
}
