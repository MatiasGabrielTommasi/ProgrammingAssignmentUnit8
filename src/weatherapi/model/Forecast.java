package weatherapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class Forecast {
  private ArrayList<ForecastDay> forecastDay = new ArrayList<ForecastDay>();
  public Forecast(JsonNode forecastNode) {
  	JsonNode forecastdayNode = forecastNode.get("forecastday");
	for (JsonNode dayNode : forecastdayNode) {
		this.forecastDay.add(new ForecastDay(dayNode));
    }
  }

  public ArrayList<ForecastDay> getForecastDay(){
	  return forecastDay;
  }
}