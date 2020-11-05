package managers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiManager {
	
	private  RequestSpecification baseRequestSpecification;
	private  ResponseSpecification baseRresposneSpecification;
	private static String BaseUri;
	private static String ApiKey;
	
	public ApiManager() {
		
		BaseUri = FileReaderManager.getInstance().getConfigReader().getApiBaseUrl();
		ApiKey = FileReaderManager.getInstance().getConfigReader().getApiKey();
	}
	
	public RequestSpecification getBaseRequestSpecification() throws IOException {
		if (baseRequestSpecification == null) {
			
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt")); 
			
			baseRequestSpecification = new RequestSpecBuilder()
					.setBaseUri(BaseUri)
					.addQueryParam("appid", ApiKey)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();
		}
		
		return baseRequestSpecification;
	}
	
	public ResponseSpecification getBaseResponseSpecification() {
		return baseRresposneSpecification;
	}
}
