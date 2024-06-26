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
	@DescriptionsList(descriptionProperties="nombre, transicion",
		    condition="${nombre} = ?",
		    depends="estado")

	@DefaultValueCalculator(value=EstadosInicial.class)
	Estados estado;
	
	
	@PostLoad
	private void calcularEstado()
	{
		 System.out.print("CARGANDO"+"\n");
		 System.out.print(estado.getNombre()+"\n");
	        EntityManager entityManager = XPersistence.getManager();
	        Query query = entityManager.createQuery("select e from Estados e");
	        List<Estados> estados = query.getResultList();

	        if (!estados.isEmpty()) {
	        	if (estado.getNombre().isEmpty()) {
	            	System.out.print("SAAA" +"\n");
	                this.estado = estados.get(0);;
	                System.out.print(estado.getNombre()+"\n");
	            }
	        	else if (estado.getNombre().equals("ABIERTO"))
	            {
	            	System.out.print("SUUUI" +"\n");
	            	this.estado = estados.get(1);
	            	//this.estado = estados.get(2);
	            	System.out.print(estados.size()+"\n");
	            }
	             else {
	                System.out.print("SUUUI" +"\n");
	            }
	        }

	}
}

