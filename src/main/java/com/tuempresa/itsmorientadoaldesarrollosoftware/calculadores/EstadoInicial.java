package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;

public class EstadoInicial implements ICalculator{

	@Override
    public Object calculate() throws Exception {
        Query query;
        query = XPersistence.getManager().createQuery("select e from Estado e where e.estado = 'ABIERTO'");
        query.setMaxResults(1);

        // Ejecuta la consulta
        Estado estado = (Estado) query.getSingleResult();
        // Comprueba si la transición es null antes de acceder a su id
        //System.out.print(estado.getNombre()+"\n");
       
        return estado.getEstadoPadre(); // Devuelve el id (nombre) de la transición
    }
}
