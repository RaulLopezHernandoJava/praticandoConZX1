package com.portal_helados.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Label;

public class IndexCtrl extends BaseCtrl {
	
	// Para utilizar un "Label" de zl es necesario importar su clase. Todo este tipo de
	// componentes como "Label" se encuentran en "org.zkoss.Label"
	
	//"lblSaludo" hace referencia al id del label que se encuentra en "index.zul"
	
	private Label lblSaludo;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		lblSaludo.setValue("Hola desde Index Ctrl");
	}
	
	public void onClick$btnSaludo(Event event) {
		lblSaludo.setValue("Hiciste click en el boton");
		lblSaludo.setStyle("color:blue");
	}
	
}
