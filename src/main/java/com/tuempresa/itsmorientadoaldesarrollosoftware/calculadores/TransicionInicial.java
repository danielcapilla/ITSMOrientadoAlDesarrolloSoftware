package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;

public class TransicionInicial implements ICalculator {
	 //private static final long serialVersionUID = 1L;
	 //@Getter@Setter
	 //TiposDeEstados estadoActual;

	    public Object calculate() throws Exception {
	    	//System.out.print(estadoActual);
	    	Query query = XPersistence.getManager().createQuery("select t from Transicion t order by t.nombre");
	        query.setMaxResults(1);

	        // Ejecuta la consulta
	        Transicion transicion = (Transicion) query.getSingleResult();
	        // Comprueba si la transición es null antes de acceder a su id
	        System.out.print(transicion.getNombre());
	        return transicion.getNombre(); // Devuelve el id (nombre) de la transición
	    }
}
