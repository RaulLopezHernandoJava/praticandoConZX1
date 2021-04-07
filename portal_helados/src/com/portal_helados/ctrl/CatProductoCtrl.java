package com.portal_helados.ctrl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.portal_helados.dao.CatProductoDao;
import com.portal_helados.model.*;

public class CatProductoCtrl extends BaseCtrl {

	private Listbox lbxCatProducto;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cargarProductos();

	}

	private void cargarProductos() {
		List<CatProducto> lst = null;
		try {
			lst = CatProductoDao.getInstance().getLstProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (lst != null && lst.size() > 0) {

			lbxCatProducto.getItems().clear();

			Listitem item;
			Listcell cell;
			for (CatProducto prod : lst) {
				item = new Listitem();
				// Asociamos el item al id de la vista "cat_producto.zul"
				// <listbox id="lbxCatProducto">
				item.setParent(lbxCatProducto);
				item.setValue(prod);

				cell = new Listcell();
				cell.setParent(item);
				cell.setLabel(String.valueOf(prod.getId()));

				cell = new Listcell();
				cell.setParent(item);
				cell.setLabel(prod.getNombre());

				cell = new Listcell();
				cell.setParent(item);
				cell.setLabel(prod.getDescripcion());

				cell = new Listcell();
				cell.setParent(item);
				cell.setLabel(prod.getPrecio().toString());
			}

			// Para refrescar nuestro "listBox" ejecutamos este metodo
			lbxCatProducto.invalidate();

		}

	}
	
	public void onClick$btnGuardar(Event event) {
		guardarProducto();
	}

	private void guardarProducto() {
		CatProducto prod = new CatProducto();
		prod.setId(1);
		prod.setNombre("Chocolate");
		prod.setDescripcion("Helado de Chocolate");
		prod.setPrecio(new BigDecimal("1.50"));

		int result;
		try {
			result = CatProductoDao.getInstance().insert(prod);
			if (result == 0) {
				System.out.println("Ha ocurrido un error al insertar");
			} else {
				System.out.println("Producto Agregado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
}
