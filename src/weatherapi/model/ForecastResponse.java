package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class ForecastResponse extends CurrentResponse {
  public ForecastResponse(JsonNode locationNode, JsonNode currentNode, JsonNode forecastNode) {
		super(locationNode, currentNode);
		this.forecast = new Forecast(forecastNode);
	}

  Forecast forecast;

  public Forecast getForecast() {
    return forecast;
  }

  public void setForecast( Forecast forecast ) {
    this.forecast = forecast;
  }
}