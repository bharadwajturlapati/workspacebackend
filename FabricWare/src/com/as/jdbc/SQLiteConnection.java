package com.as.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteConnection {
	private String sql;
	private Connection connection;

	public SQLiteConnection(String sql, Connection connection) {
		setSql(sql);
		setConnection(connection);
	}

	public ResultSet executeAndReturnRS() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = getConnection().prepareStatement(getSql());
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int executeAndLeave() {
		PreparedStatement pstmt = null;
		try {
			pstmt = getConnection().prepareStatement(getSql());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void closeAll(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			try {
				if (closeable != null) {
					closeable.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
