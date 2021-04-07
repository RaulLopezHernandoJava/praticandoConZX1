package com.portal_helados.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.portal_helados.model.CatProducto;
import com.portal_helados.utils.Commons;

public class CatProductoDao {
	private DataSource ds;
	private QueryRunner qr;
	private static CatProductoDao dao;

	private final String SQL_INSERT = "INSERT INTO cat_producto (id, nombre, descripcion,precio) VALUES ( ? , ? , ? , ? )";
	private final String SQL_SELECT = "SELECT * FROM cat_producto";

	public void CatProductoDao() throws NamingException {
		this.ds = Commons.getDS();
		this.qr = new QueryRunner(ds);
	}

	public static CatProductoDao getInstance() throws NamingException {
		if (dao == null) {
			dao = new CatProductoDao();
		}
		return dao;
	}

	// Insertar en la base de datos

	public int insert(CatProducto producto) throws SQLException {
		int result = 0;
		Object[] params = { producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio() };
		result = qr.update(SQL_INSERT, params);
		return result;

	}

	
	  // Seleccionar en la base de datos
	  
	  public List<CatProducto> getLstProductos() throws SQLException {
	  
	  ResultSetHandler<List<CatProducto>> rsh = new
	  BeanListHandler<CatProducto>(CatProducto.class);
	  
	  return qr.query(SQL_SELECT, rsh);
	  
	  }
	 

}
