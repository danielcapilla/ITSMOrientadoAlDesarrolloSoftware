package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
	members="cuenta" 
		)
@Entity @Getter @Setter
public class PlanContable {

    @Id
    @Hidden
    @GeneratedValue(generator="system-uuid") // Identificador Universal �nico (1)
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=7)
    String cuenta;
	
	@Column(length=10)
	String nombre;
	
    @Enumerated(EnumType.STRING)
	@Column(length = 15)
    TiposDeGrupos grupo;
}
enum TiposDeGrupos {
	ClientesyProveedores,
	CuentasFinancieras,
	ComprasyGastos,
	VentaseIngresos;
}