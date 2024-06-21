package com.tuempresa.itsmorientadoaldesarrollosoftware.calculadores;

import org.openxava.calculators.*;

import com.tuempresa.itsmorientadoaldesarrollosoftware.modelo.Enums.*;

public class EstadoInicial implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return TiposDeEstados.ABIERTO;
    }
}
