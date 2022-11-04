package gov.goias.viacep;


import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/dados", path = "/dados")
public class DadosController {
	
	@Autowired
	private DadosService dadosService;
	
	
	@GetMapping(path = "/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dados> buscar(@PathVariable Long cep) throws InterruptedException, 
																			ExecutionException, URISyntaxException{				
		
		return ResponseEntity.ok(dadosService.obter(String.valueOf(cep)));		
		
	}

}
