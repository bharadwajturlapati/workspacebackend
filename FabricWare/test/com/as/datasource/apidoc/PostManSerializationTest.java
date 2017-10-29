package com.as.datasource.apidoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

import com.google.gson.Gson;

public class PostManSerializationTest {

	@Test
	public void testSerializeData() {
		String FILENAME = "resources/postmancollections/sample-postman-collection.json";
		Gson gson = new Gson();
		PostManCollection psmc = gson.fromJson(readFile(FILENAME), PostManCollection.class);
		assertThat(psmc.getRequestList()).isNotNull();
	}

	private String readFile(String fileName) {
		StringBuilder resultStringBuilder = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				resultStringBuilder.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultStringBuilder.toString();
	}
}
