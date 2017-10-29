package com.as.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.as.datasource.QuickAccessModel;
import com.google.gson.Gson;

public class QuickAccessDataSourceHelper {
	private static final String url = "jdbc:sqlite:E://sqlite/quickaccessdb.db";

	public String readFromDB() {
		Gson gson = new Gson();
		String sql = "select * from data";
		List<QuickAccessModel> accessModelList = new ArrayList<QuickAccessModel>();

		try {
			Connection connection = DriverManager.getConnection(url);
			SQLiteConnection connectionHandle = new SQLiteConnection(sql, connection);
			ResultSet rs = connectionHandle.executeAndReturnRS();

			while (rs.next()) {
				QuickAccessModel accessModel = new QuickAccessModel();
				accessModel.setId(rs.getString("id"));
				accessModel.setFileurl(rs.getString("fileurl"));
				accessModel.setLogicalgroup(rs.getString("logicalgroup"));
				accessModel.setNickname(rs.getString("nickname"));
				accessModelList.add(accessModel);
			}
			SQLiteConnection.closeAll(connection);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return gson.toJson(accessModelList);
	}

	public String insertIntoDB(String requestBody) {
		Gson gson = new Gson();
		Connection connection = null;
		QuickAccessModel accessModel = gson.fromJson(requestBody, QuickAccessModel.class);

		String query = "insert into data(id, fileurl, logicalgroup, nickname) values(?,?,?,?)";

		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, getUUID());
			preparedStmt.setString(2, accessModel.getFileurl());
			preparedStmt.setString(3, accessModel.getLogicalgroup());
			preparedStmt.setString(4, accessModel.getNickname());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			SQLiteConnection.closeAll(connection);
		}

		return readFromDB();
	}

	public int deleteFromDb(String deletionID) {
		Connection connection = null;
		String query = "delete from data where id='" + deletionID+"';";

		try {
			connection = DriverManager.getConnection(url);
			SQLiteConnection connectionHandle = new SQLiteConnection(query, connection);
			return connectionHandle.executeAndLeave();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			SQLiteConnection.closeAll(connection);
		}
		
		return 0;
	}

	private String getUUID() {
		return UUID.randomUUID().toString();
	}
}
