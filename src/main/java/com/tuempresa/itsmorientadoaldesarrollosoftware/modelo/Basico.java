package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@View( name="Pedidos1", 
members= 
	"datos"+"["+"direccion;" +   
    "poblacion, codigoPostal;" +
    "provincia, pais;"+
    "nombreComercial;"
    + "identificacionVat;"
    		+ "]"
     +"contacto"+"["+"email;" +   
     "telefono, movil;" +
     "website;"
     + "tags;"
     + "tipoDeContacto"+"];"
    )
@Embeddable
@Getter @Setter
public class Basico {

    @Column(length = 25)
    String direccion;

    @Column(length = 10)
    String codigoPostal;

    @Column(length = 10)
    String poblacion;

    @Column(length = 10)
    String provincia;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	@Required
    TiposDePaises pais;

    @Email
    String email;

    @Column(length = 10)
    String telefono;

    @Column(length = 10)
    String movil;
    
    @Column(length = 25)
    String website;
    
    @Column(length = 25)
    String tags;
    
    @Column(length = 25)
    String nombreComercial;
    
    @Column(length = 25)
    String identificacionVat;
    
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	@Required
	TiposDeContacto tipoDeContacto;
}
enum TiposDeContacto {
	Cliente,
	Proveedor,
	Lead,
	Deudor,
	Acreedor;
}
enum TiposDePaises {
	España,
	Francia,
	Inglaterra,
	Italia,
	Alemania;
}