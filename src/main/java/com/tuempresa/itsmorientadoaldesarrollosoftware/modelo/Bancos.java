package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
@View( name="Bancos1", 
members= 
		"banco, iban, swift;" +
				"RemesasSEPA"+"["+"ref, fechaMandato;" + "];"+
				"bancoPredeterminado;"
    )
@Embeddable
@Getter @Setter
public class Bancos {

	@Column(length=50)
	String iban;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	@Required
	TiposDeBancos banco;
	
	@Column(length=20)
	String swift;
	
	@Column(length=20)
	String ref;
	
    @Required
    LocalDate fechaMandato;
    
    @Column(columnDefinition="BOOLEAN DEFAULT FALSE")
    boolean bancoPredeterminado;
 
}
enum TiposDeBancos {
	BBVA;
}