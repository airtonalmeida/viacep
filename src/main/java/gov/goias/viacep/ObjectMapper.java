package gov.goias.viacep;

import java.io.IOException;
import java.util.concurrent.CompletionException;

import com.fasterxml.jackson.core.type.TypeReference;



public class ObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Parses the given JSON string into a Map.
	 */
	Dados readValueDados(String content) {
		try {
			return this.readValue(content, new TypeReference<Dados>() {
			});
		} catch (IOException ioe) {
			throw new CompletionException(ioe);
		}
	}

}
