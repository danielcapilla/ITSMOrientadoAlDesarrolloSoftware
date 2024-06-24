package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import lombok.*;

@Getter @Setter@Entity
public class Transicion {

	@Column(length = 20)
	@Id
	String nombre;
	
	// Constructor para crear una instancia con nombre específico
    public Transicion(String nombre) {
        this.nombre = nombre;
    }

    // Constructor vacío (necesario para JPA)
    public Transicion() {
    }
}
