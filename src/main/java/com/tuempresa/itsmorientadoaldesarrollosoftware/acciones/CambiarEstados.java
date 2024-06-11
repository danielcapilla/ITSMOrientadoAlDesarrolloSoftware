package com.tuempresa.itsmorientadoaldesarrollosoftware.acciones;

import org.openxava.actions.*;
import org.openxava.jpa.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.*;
import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

public class CambiarEstados extends ViewBaseAction {

    public void execute() throws Exception {
        Incidente incidente = XPersistence.getManager().find(Incidente.class, getView().getValue("oid"));
        TiposDeEstados nuevoEstado = TiposDeEstados.valueOf(getView().getValueString("estado"));
        System.out.print(nuevoEstado);
        if (incidente.getEstado() == TiposDeEstados.ABIERTO) {
            if (nuevoEstado != TiposDeEstados.TRABAJO_EN_CURSO && nuevoEstado != TiposDeEstados.PENDIENTE) {
                addError("Transici�n no permitida");
                return;
            }
        } else if (incidente.getEstado() == TiposDeEstados.PENDIENTE) {
            if (nuevoEstado != TiposDeEstados.CANCELADO && nuevoEstado != TiposDeEstados.TRABAJO_EN_CURSO) {
                addError("Transici�n no permitida");
                return;
            }
        }
        try {
            incidente.setEstado(nuevoEstado);
            XPersistence.getManager().merge(incidente);
            addMessage("Estado cambiado con �xito");
        } catch (IllegalArgumentException e) {
            addError(e.getMessage());
        }
    }
}
