package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;
import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

import lombok.*;

public class TransicionInicial implements ICalculator {
	 //private static final long serialVersionUID = 1L;
	 @Getter@Setter
	 TiposDeEstados estadoAct;
	 @Override
	 public Object calculate() throws Exception {
	        System.out.print(estadoAct);
	        Query query;
	        if (estadoAct == TiposDeEstados.ABIERTO) {
	        	System.out.print(" SOY TRANSICION ");
	            query = XPersistence.getManager().createQuery("select t from Transicion t order by t.nombre");
	        } else {
	            query = XPersistence.getManager().createQuery("select t from Transicion t order by t.nombre");
	        }
	        query.setMaxResults(1);

	        // Ejecuta la consulta
	        Transicion transicion = (Transicion) query.getSingleResult();
	        // Comprueba si la transición es null antes de acceder a su id
	        System.out.print(transicion.getNombre()+"\n");
	        return transicion.getNombre(); // Devuelve el id (nombre) de la transición
	    }
}
