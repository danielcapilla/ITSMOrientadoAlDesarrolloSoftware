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

    @Column(length = 100)
    String direccion;

    @Column(length = 10)
    String codigoPostal;

    @Column(length = 50)
    String poblacion;

    @Column(length = 50)
    String provincia;

    @Column(length = 50)
    String pais;

    @Email
    String email;

    @Column(length = 20)
    String telefono;

    @Column(length = 20)
    String movil;
    
    @Column(length = 50)
    String website;
    
    @Column(length = 50)
    String tags;
    
    @Column(length = 50)
    String nombreComercial;
    
    @Column(length = 50)
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