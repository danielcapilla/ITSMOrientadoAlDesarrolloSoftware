package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;

import lombok.*;


public class EstadosInicial implements ICalculator{
	
	@Getter @Setter
	Estados estadoP;
	
	@Override
    public Object calculate() throws Exception {

		//System.out.print("HOLAAAA"+"\n");
        Query query;
        query = XPersistence.getManager().createQuery("select e from Estados e where e.nombre = 'ABIERTO'");
        query.setMaxResults(1);

        // Ejecuta la consulta
        Estados estado = (Estados) query.getSingleResult();
        // Comprueba si la transición es null antes de acceder a su id
        System.out.print(estado.getEstadoPadre()+"\n");
        if(estado.getEstadoPadre().isEmpty())
        {
        	System.out.print("JAJA"+"\n");
        	return estado.getNombre(); // Devuelve el id (nombre) de la transición
        }
        else if (estado.getEstadoPadre() == "ABIERTO")
        {
        	System.out.print("JEJE"+"\n");
        }
        System.out.print("JOJO"+"\n");
        return estado.getNombre(); // Devuelve el id (nombre) de la transición
    }
}
