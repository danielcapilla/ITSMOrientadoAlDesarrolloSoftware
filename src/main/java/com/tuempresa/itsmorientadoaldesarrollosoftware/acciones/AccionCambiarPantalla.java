package com.tuempresa.itsmorientadoaldesarrollosoftware.acciones;

import java.util.*;

import javax.ejb.*;

import org.openxava.actions.*;

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
	            Map key = new HashMap();
	            key.put("operacion", solicitud);
	            System.out.println(key);
				//showNewView();
				getView().setModelName(nombreSolicitud);
				System.out.println(getView().getMembersNames());
				getView().setValue("operacion", solicitud);
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
