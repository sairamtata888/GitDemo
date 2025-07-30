package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
	public RequestSpecification spec() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(this.getGlobalValue("baseURI")).addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.build();
		return req;
	}
	
	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream f = new FileInputStream("C:\\Users\\saira\\eclipse-workspace\\CucumberProject\\src\\test\\java\\Resources\\global.properties");
		prop.load(f);
		return prop.getProperty(key);
	}
}
