package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;
import org.openxava.util.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;

public class UsuarioInicial implements ICalculator{

	@Override
    public Object calculate() throws Exception {
        String currentUser = Users.getCurrent();
        EntityManager em = XPersistence.getManager();
        Usuario usuario = (Usuario) em.createQuery("from Usuario where nombre = :nombre")
            .setParameter("nombre", currentUser)
            .getSingleResult();
        return usuario;
    }
}
