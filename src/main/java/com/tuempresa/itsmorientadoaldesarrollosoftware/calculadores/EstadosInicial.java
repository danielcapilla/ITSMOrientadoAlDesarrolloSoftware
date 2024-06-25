package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;

public class EstadosInicial implements ICalculator{

	@Override
    public Object calculate() throws Exception {
		//System.out.print(estadoAct);
        Query query;
        query = XPersistence.getManager().createQuery("select e from Estados e where e.nombre = 'ABIERTO'");
        query.setMaxResults(1);

        // Ejecuta la consulta
        Estados estado = (Estados) query.getSingleResult();
        // Comprueba si la transición es null antes de acceder a su id
        //System.out.print(estado.getNombre()+"\n");
        if(estado.getEstadoPadre() == null)
        {
        	return estado.getNombre(); // Devuelve el id (nombre) de la transición
        }
        
        return estado.getNombre(); // Devuelve el id (nombre) de la transición
    }
}
