package com.tuempresa.itsmorientadoaldesarrollosoftware.acciones;

import java.util.*;

import javax.ejb.*;
import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.util.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;
import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

public class AccionCambiarPantalla extends OnChangePropertyBaseAction{

	public void execute() throws Exception
	{
		try
		{


			TiposDeSolicitud solicitud = (TiposDeSolicitud) getNewValue();

			if(solicitud != null)
			{
				String nombreSolicitud = solicitud.name();
				String currentUser = Users.getCurrent();
			        EntityManager em = XPersistence.getManager();
			        Usuario usuario = (Usuario) em.createQuery("from Usuario where nombre = :nombre")
			            .setParameter("nombre", currentUser)
			            .getSingleResult();
	            Map key = new HashMap();
	            key.put("operacion", solicitud);
	            System.out.println(key);
				//showNewView();
				getView().setModelName(nombreSolicitud);
				System.out.println(getView().getMembersNames());
				getView().setValue("operacion", nombreSolicitud);
				getView().setValue("solicitante", usuario.getNombre());
				getView().findObject();
				System.out.println(getView().getValue("operacion"));
	            getView().setKeyEditable(false);
	            //getView().setEditable(false);
				//getView().refresh();

			}
		}catch(ObjectNotFoundException ex) {
            getView().clear();
            addError("object_not_found");
		}
		
	}
}
