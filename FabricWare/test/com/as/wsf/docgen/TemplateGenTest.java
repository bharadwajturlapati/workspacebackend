package com.as.wsf.docgen;

import org.junit.Test;

import com.as.datasource.apidoc.PostManSerializationTest;

import static org.fest.assertions.api.Assertions.assertThat;

public class TemplateGenTest {

	@Test
	public void testTemplateGeneration() {
		String hello = TemplateGen.generateHTMLTemplate("{\"name\":\"bharadwaj\"}", "testdocgen.vm");
		assertThat(hello.contains("bharadwaj")).isEqualTo(true);
	}
	
	@Test
	public void testComplexCollection() {
		String jsonCollection = PostManSerializationTest.readFile("resources\\testresources\\testCollectionJson.json");
		String value = TemplateGen.generateHTMLTemplate(jsonCollection, "api-docgen.vm");
		System.out.println(value);
	}
}
