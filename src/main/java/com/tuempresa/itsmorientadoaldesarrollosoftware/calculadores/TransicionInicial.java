package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

public class TransicionInicial implements ICalculator {
	 private static final long serialVersionUID = 1L;
	    @Override
	    public Object calculate() throws Exception {
	    	Query query = XPersistence.getManager().createQuery("SELECT t FROM Transicion t WHERE t.nombre = :nombre");
	        query.setParameter("nombre", "Crear");
	        return query.getSingleResult();
	    }
}
