package main.java.service;

import com.google.gson.Gson;
import main.java.model.ApiResponseModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ExchangeRateApiService {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/b07ad1486f72cf908df9bcee/latest/";

    public static String getJsonResponse(String baseCurrency) throws IOException {
        // Tu código para hacer la solicitud HTTP y obtener la respuesta JSON...
        // Setting URL
        String url_str = API_URL+baseCurrency;

        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Leer la respuesta JSON
        InputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }

        // Cerrar recursos
        reader.close();
        inputStream.close();

        return responseBuilder.toString();
    }

    //In this function we use the model to parse json data
    public double getConversionRate(String baseCurrency, String targetCurrency) throws IOException {
        String jsonResponse = getJsonResponse(baseCurrency);
        ApiResponseModel response = new Gson().fromJson(jsonResponse, ApiResponseModel.class);
        Map<String, Double> conversionRates = response.getConversion_rates();
        return conversionRates.get(targetCurrency);
    }


}
