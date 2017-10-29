package com.as.datasource;

import java.sql.SQLException;

import org.junit.Test;

public class SQLiteConnectionTest {

	@Test
	public void testSQLliteConnectionTest() throws SQLException {
		// Need to create testDB and then convert into dependency list
		/*String url = "jdbc:sqlite:E://sqlite/quickaccessdb.db";
		String sql = "select * from data";
		Connection connection = DriverManager.getConnection(url);
		SQLiteConnection connectionHandle = new SQLiteConnection(sql, connection);
		connectionHandle.executeAndReturnRS();
		connection.close();*/
	}

	@Test
	public void testDelete() {
		//tested and works fine hence commenting
		//QuickAccessDataSourceHelper ds = new QuickAccessDataSourceHelper();
		//ds.deleteFromDb("943b77a0-6050-424c-ba12-3ce83b21fb18");
	}

}
