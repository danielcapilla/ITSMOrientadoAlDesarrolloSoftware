package com.tuempresa.itsmorientadoaldesarrollosoftware.acciones;

import org.openxava.actions.*;

public class RefreshDefaultsAction extends ViewBaseAction {

    public void execute() throws Exception {
        getView().refresh();
    }
}
