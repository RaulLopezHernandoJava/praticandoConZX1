package com.portal_helados.ctrl;

import org.zkoss.zk.ui.Component;

// Insertamoz zk en nuestro controlador base

import org.zkoss.zk.ui.util.GenericForwardComposer;

public abstract class BaseCtrl extends GenericForwardComposer {
	
	// Para poder mostrar elementos en el momento en el que la vista se renderiza
	// se hace mediante este metodo "doAfterCompose"
	// Metodo de inicio cuando se renderiza una vista y manda ejecutar el controlador
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

}
