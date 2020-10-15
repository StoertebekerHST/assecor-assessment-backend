package assecor_assessment_backend;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class TestRestService {
	
	String jsonMimeType = "application/json";
	
	@Test
	public void testAllPerson() throws ClientProtocolException, IOException {
		
		HttpUriRequest request = new HttpGet( "http://localhost:8080/Lovecolor/rest/persons/" );
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
		
		 String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		 assertEquals( jsonMimeType, mimeType );
	}

	@Test
	public void testOnPerson() throws ClientProtocolException, IOException {
		
		HttpUriRequest request = new HttpGet( "http://localhost:8080/Lovecolor/rest/persons/5" );
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
		
		 String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		 assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	public void testColorPerson() throws ClientProtocolException, IOException {
		
		HttpUriRequest request = new HttpGet( "http://localhost:8080/Lovecolor/rest/persons/color/3" );
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
		
		 String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		 assertEquals( jsonMimeType, mimeType );
	}
	
	
	
}
