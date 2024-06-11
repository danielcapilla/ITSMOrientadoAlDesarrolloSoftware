package com.tuempresa.itsmorientadoaldesarrollosoftware.acciones;

import org.openxava.calculators.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

public class EstadoInicial implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return TiposDeEstados.ABIERTO;
    }
}
