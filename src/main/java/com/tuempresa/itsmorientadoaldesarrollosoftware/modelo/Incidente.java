package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores.*;

import lombok.*;

@Entity@Getter@Setter
public class Incidente {
	
	@Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid; // oid para la clase maestra
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList(descriptionProperties="estado, transicion",
		    condition="${estadoPadre}= ? ",
		    depends="estadoActual")

	@DefaultValueCalculator(value=EstadoInicial.class)
	@Required
	Estado estadoActual;

	@PostLoad
	private void calcularEstado()
	{
		 System.out.print("CARGANDO"+"\n");
		 System.out.print(estadoActual.getEstado()+"\n");
	        EntityManager entityManager = XPersistence.getManager();
	        Query query = entityManager.createQuery("select e from Estado e");
	        List<Estado> estados = query.getResultList();

	        if (!estados.isEmpty()) {
	        	 if (estadoActual.getEstado().equals("ABIERTO"))
	            {
	            	System.out.print("SUUUI" +"\n");
	            	this.estadoActual = estados.get(1);
	            	//this.estado = estados.get(2);
	            	System.out.print(estados.size()+"\n");
	            }
	             else {
	                System.out.print("SUUUI" +"\n");
	            }
	        }

	}
}
