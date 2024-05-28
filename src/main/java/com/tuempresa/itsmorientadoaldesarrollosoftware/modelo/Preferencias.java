package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;


import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
@View( name="Preferencias1", 
members= 
	"cuenta"+"["+"idioma, moneda;" +   
    "cuentaDeVentas; cuentaDeCompras;" +
    "referencia;"
    		+ "]"
     +"pago"+"[#"+"formaDePago;vencimiento;" +  
     "descuento, tarifa;"+
     "diaDePago;"+
     "mostrarNombreComercialEnFacturas; mostrarPaisEnFacturas" +
     "];"
    )
@Embeddable
@Getter @Setter
public class Preferencias {

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeIdiomas idioma;
	
	@Column(length = 30)
	String referencia;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeMonedas moneda;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeCuentas cuentaDeVentas;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeCuentas cuentaDeCompras;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeFormasDePago formaDePago;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeVencimientos vencimiento;
	
	@Column(length = 15)
	String descuento;
	

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeTarifa tarifa;
	
	@Column(length = 2)
	int diaDePago;
	
    @Column(columnDefinition="BOOLEAN DEFAULT FALSE")
    boolean mostrarNombreComercialEnFacturas;
    
    @Column(columnDefinition="BOOLEAN DEFAULT TRUE")
    boolean mostrarPaisEnFacturas;
}
enum TiposDeIdiomas {
	Español,
	Francés,
	Inglés,
	Italiano,
	Alemán;
}
enum TiposDeMonedas {
	EUR,
	USD,
	GBP,
	JPY,
	MXN;
}
enum TiposDeCuentas {
	PlanContable;
}
enum TiposDeFormasDePago {
	Contado,
	Transferencia;
}
enum TiposDeVencimientos {
	MismoDía,
	SieteDías,
	QuinceDías,
	TreintaDías,
	SesentaDías,
	NoventaDías;
}
enum TiposDeTarifa {
	Predeterminada;
}
