package gov.goias.viacep;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DadosService {
	
	@Autowired
	private DadosRepository dadosRepositoty;
	
	public Dados obter(String cep) throws InterruptedException, ExecutionException, URISyntaxException {
		
		ObjectMapper objectMapper = new ObjectMapper();

	        HttpRequest request = HttpRequest.newBuilder(new URI("https://viacep.com.br/ws/"+cep+"/json/"))
	                .header("Accept", "application/json")
	                .build();	        
			
			Dados dados = HttpClient.newHttpClient()
					.sendAsync(request, HttpResponse.BodyHandlers.ofString())
					.thenApply(HttpResponse::body)
					.thenApply(objectMapper::readValueDados)
					.get();

			System.out.println(dados.getBairro());
				
			return save(dados);
		
	}
	
	private Dados save(Dados dados) {		
		return dadosRepositoty.save(dados);		
	}

}
