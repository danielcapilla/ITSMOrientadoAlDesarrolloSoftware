package com.tuempresa.itsmorientadoaldesarrollosoftware.acciones;

import org.openxava.actions.*;

public class CambiarEstados extends ViewBaseAction {

    public void execute() throws Exception {
    	/*
        Incidente incidente = XPersistence.getManager().find(Incidente.class, getView().getValue("oid"));
        TiposDeEstados nuevoEstado = TiposDeEstados.valueOf(getView().getValueString("estado"));
        System.out.print(nuevoEstado);
        if (incidente.getEstadoSiguiente() == TiposDeEstados.ABIERTO) {
            if (nuevoEstado != TiposDeEstados.TRABAJO_EN_CURSO && nuevoEstado != TiposDeEstados.PENDIENTE) {
                addError("Transición no permitida");
                return;
            }
        } else if (incidente.getEstadoSiguiente() == TiposDeEstados.PENDIENTE) {
            if (nuevoEstado != TiposDeEstados.CANCELADO && nuevoEstado != TiposDeEstados.TRABAJO_EN_CURSO) {
                addError("Transición no permitida");
                return;
            }
        }
        try {
            incidente.setEstadoSiguiente(nuevoEstado);
            XPersistence.getManager().merge(incidente);
            addMessage("Estado cambiado con éxito");
        } catch (IllegalArgumentException e) {
            addError(e.getMessage());
        }*/
    	System.out.print("HOLA");
    }
}

