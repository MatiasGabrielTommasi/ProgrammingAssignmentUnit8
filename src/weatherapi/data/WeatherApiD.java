package weatherapi.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import weatherapi.model.CurrentResponse;
import weatherapi.model.ForecastResponse;

public class WeatherApiD {
	private static String apiKey = "b1a29336648e432885c84743230210";
	
	private static String getCurrentWeatherUrl(String search) {
		return "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + search;
	}
	
	private static String getForecastWeatherUrl(String search) {
		return "http://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&days=3&q=" + search;
	}
	
	public static CurrentResponse getCurrentWeather(String search) {
		CurrentResponse response = null;		
        try {
    		String apiCall = getCurrentWeatherUrl(search);
            URL url = new URL(apiCall);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();

                String json = content.toString();

            	ObjectMapper mapper = new ObjectMapper();
            	JsonNode rootNode = mapper.readTree(json);
            	JsonNode locationNode = rootNode.get("location");
            	JsonNode currentNode = rootNode.get("current");
            	
            	response = new CurrentResponse(locationNode, currentNode);
            	
                System.out.println(json);
            } else {
                System.out.println("Something went wrong: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response;
	}
	
	public static ForecastResponse getForecastWeather(String search) {
		ForecastResponse response = null;		
        try {
    		String apiCall = getForecastWeatherUrl(search);
            URL url = new URL(apiCall);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();

                String json = content.toString();

            	ObjectMapper mapper = new ObjectMapper();
            	JsonNode rootNode = mapper.readTree(json);
            	JsonNode locationNode = rootNode.get("location");
            	JsonNode currentNode = rootNode.get("current");
            	JsonNode forecastNode = rootNode.get("forecast");
            	
            	response = new ForecastResponse(locationNode, currentNode, forecastNode);
            	
                System.out.println(json);
            } else {
                System.out.println("Something went wrong: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response;
	}
}