package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import lombok.*;

@Getter @Setter@Entity
public class Transicion {

	@Column(length = 20)
	@Id
	String nombre;
	
	
}
