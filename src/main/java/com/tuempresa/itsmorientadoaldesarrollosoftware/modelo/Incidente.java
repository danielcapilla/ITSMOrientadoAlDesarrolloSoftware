package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.acciones.*;
import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

import lombok.*;


@Tabs({
    @Tab(name = "Abierto", baseCondition = "${estado}='ABIERTO'"),
    @Tab(name = "Pendiente", baseCondition = "${estado}='PENDIENTE'")
})
@Entity @Getter @Setter
public class Incidente {
	
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	@Required
	@DefaultValueCalculator(EstadoInicial.class)
	TiposDeEstados estado = TiposDeEstados.ABIERTO;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	@Required
	TiposDeTransicion transicion = TiposDeTransicion.Crear;
	
}

enum TiposDeTransicion {
    Crear,
    Investigar,
    Pendiente,
    Resolver,
    Volver_A_Trabajo_En_Progreso,
    CanCancelar,
    Cancelar,
    Cerrar

}