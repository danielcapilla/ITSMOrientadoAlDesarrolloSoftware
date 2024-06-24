package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import lombok.*;

@Getter @Setter@Entity
public class Transicion {

	@Column(length = 20)
	@Id
	String nombre;
	
	// Constructor para crear una instancia con nombre espec�fico
    public Transicion(String nombre) {
        this.nombre = nombre;
    }

    // Constructor vac�o (necesario para JPA)
    public Transicion() {
    }
}
