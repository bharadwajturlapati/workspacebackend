package com.as.wsf.docgen;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class TemplateGenTest {

	@Test
	public void testTemplateGeneration() {
		String hello = TemplateGen.generateHTMLTemplate("{\"name\":\"bharadwaj\"}", "testdocgen.vm");
		//assertThat(hello.contains("bharadwaj")).isEqualTo(true);
		System.out.println(hello);
	}
}
