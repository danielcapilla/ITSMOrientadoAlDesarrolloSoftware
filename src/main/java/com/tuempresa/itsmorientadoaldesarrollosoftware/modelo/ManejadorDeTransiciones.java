package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

public class ManejadorDeTransiciones {

    public static String obtenerCondicionTransiciones(TiposDeEstados estadoActual) {
        switch (estadoActual) {
            case ABIERTO:
                return "${nombre} = 'Crear'";
            case CANCELADO:
                return "${nombre} = 'Cerrar'";
            // A�ade m�s casos seg�n los estados posibles
            default:
                return "1=0"; // Por defecto, no permite ninguna transici�n
        }
    }
}
