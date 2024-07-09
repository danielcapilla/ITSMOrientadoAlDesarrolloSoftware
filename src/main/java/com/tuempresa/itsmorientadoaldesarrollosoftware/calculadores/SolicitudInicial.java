package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import org.openxava.calculators.*;

import lombok.*;

public class SolicitudInicial implements ICalculator{

	@Getter @Setter
	String nombreSolicitud;
	@Override
	public Object calculate() throws Exception
	{
		String nombre = null;
		if(nombreSolicitud.equals("1"))
		{
			nombre = "Incidente";
		}
		else if(nombreSolicitud.equals("2"))
		{
			nombre = "Asistencia";
		}
		else if(nombreSolicitud.equals("3"))
		{
			nombre = "Cambio";
		}

		return nombre;
	}
}
