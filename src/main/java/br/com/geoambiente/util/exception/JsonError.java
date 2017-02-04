package br.com.geoambiente.util.exception;

public class JsonError {

	private String key;
	
	private String[] parameters;
	
	public JsonError(String key, String... parameters) {
		this.key = key;
		this.parameters = parameters;
	}

	public String getKey() {
		return key;
	}

	public String[] getParameters() {
		return parameters;
	}
}
