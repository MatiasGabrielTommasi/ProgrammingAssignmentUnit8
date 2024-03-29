package weatherapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class ForecastDay {
  private String date;
  private double dateEpoch;
  Day day;
  Astro astro;
  ArrayList<Hour> hour = new ArrayList<Hour>();

  public ForecastDay(JsonNode forecastdayNode) {
		try {
			this.date = forecastdayNode.get("date").asText();
			this.dateEpoch = forecastdayNode.get("date_epoch").asDouble();
			this.day = new Day(forecastdayNode.get("day"));
			this.astro = new Astro(forecastdayNode.get("astro"));
			
			JsonNode hourArray = forecastdayNode.get("hour");
			for (JsonNode hourNode : hourArray) {
				this.hour.add(new Hour(hourNode));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

 // Getter Methods 

  public String getDate() {
    return date;
  }

  public double getDateEpoch() {
    return dateEpoch;
  }

  public Day getDay() {
    return day;
  }

  public Astro getAstro() {
    return astro;
  }

 // Setter Methods 

  public void setDate( String date ) {
    this.date = date;
  }

  public void setDateEpoch( double dateEpoch ) {
    this.dateEpoch = dateEpoch;
  }

  public void setDay( Day dayObject ) {
    this.day = dayObject;
  }

  public void setAstro( Astro astroObject ) {
    this.astro = astroObject;
  }
}