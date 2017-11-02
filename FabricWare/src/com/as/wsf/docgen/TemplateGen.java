package com.as.wsf.docgen;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.as.datasource.apidoc.PostManCollection;
import com.google.gson.Gson;

public class TemplateGen {

	private static VelocityEngine ve;
	private static Properties velocityProps = new Properties();

	static {
		try {
			ve = new VelocityEngine();

			velocityProps.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			velocityProps.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			velocityProps.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, NullLogChute.class.getName());
			ve.init(velocityProps);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String generateHTMLTemplate(String requestBody, String vm) {
		Gson gson = new Gson();
		PostManCollection postManCollection = gson.fromJson(requestBody, PostManCollection.class);
		VelocityContext velocityContext = new VelocityContext();
		Writer writer = new StringWriter();

		Template t = ve.getTemplate(vm);
		velocityContext.put("postManCollection", postManCollection);

		t.merge(velocityContext, writer);
		return writer.toString();
	}
}
