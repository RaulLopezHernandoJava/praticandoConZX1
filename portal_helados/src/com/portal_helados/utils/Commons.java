package com.portal_helados.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Commons {

	public static DataSource getDS() throws NamingException {
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/helados" );
		return ds;
	}

}
