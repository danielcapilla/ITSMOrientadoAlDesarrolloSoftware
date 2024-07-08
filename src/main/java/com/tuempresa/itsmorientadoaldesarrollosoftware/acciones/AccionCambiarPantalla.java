package com.tuempresa.itsmorientadoaldesarrollosoftware.acciones;

import org.openxava.actions.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

public class AccionCambiarPantalla extends OnChangePropertyBaseAction{

	public void execute() throws Exception
	{
		System.out.print("HOLAAAA"+getNewValue());
		TiposDeSolicitud solicitud = (TiposDeSolicitud) getNewValue();
		if(solicitud != null)
		{
			String nombreSolicitud = solicitud.name();
			getView().setModelName(nombreSolicitud);
			getView().setKeyEditable(false);
			//getView().setValue("oid", solicitud.getOid());
			getView().refresh();
		}
	}
}
