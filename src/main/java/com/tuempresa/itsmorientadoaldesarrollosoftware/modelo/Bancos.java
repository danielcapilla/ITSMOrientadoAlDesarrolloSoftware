package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter @Setter
public class Bancos {

	@Column(length=50)
	String iban;
}
