package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;

@View(members= "estado;")
@Entity @Getter @Setter
public class Incidente {
	
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList(descriptionProperties="nombre",
		    condition="${nombre} = ?",
		    depends="estado")

	@DefaultValueCalculator(value=EstadosInicial.class)
	Estados estado;
	
	@PrePersist@PreUpdate
	private void calcularEstado()
	{
		 System.out.print("CARGANDO"+"\n");
	        EntityManager entityManager = XPersistence.getManager();
	        Query query = entityManager.createQuery("select e from Estados e");
	        List<Estados> estados = query.getResultList();

	        if (!estados.isEmpty()) {
	            Estados primerEstado = estados.get(0); // Tomamos el primer estado como ejemplo
	            if (estado.getEstadoPadre().isEmpty()) {
	            	System.out.print("SAAA" +"\n");
	                this.estado = primerEstado;
	            } else {
	                System.out.print("SUUUI" +"\n");
	            }
	        }
	}


}

