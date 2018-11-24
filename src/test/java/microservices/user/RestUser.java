package microservices.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import microservices.entities.Trabajo;


public class RestUser {
	
	public void getTrabajosEnviados() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    RestTemplate restTemplate = new RestTemplate();
	        
		String url = "http://localhost:8080/microservice/user/trabajos/{id}";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<Trabajo[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Trabajo[].class, 1);
	        
	        Trabajo[] trabajos = responseEntity.getBody();
	        
	        for(Trabajo trabajo : trabajos) {
	              trabajo.toString();
	        }
	}
}
