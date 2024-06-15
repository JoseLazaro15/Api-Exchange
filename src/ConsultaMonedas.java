import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {

	public static double buscarMoneda(String monedaBase, String monedaDestino) throws IOException, InterruptedException {
		// Insanciacion del API
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://v6.exchangerate-api.com/v6/930502296d8b7cd84636c432/pair/"+monedaBase+"/"+monedaDestino))
				.GET()
				.build();

		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String responseBody = response.body();
		JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
		return jsonObject.get("conversion_rate").getAsDouble();
	}
}
