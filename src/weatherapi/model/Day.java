package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Day {
  private double maxTempC;
  private double maxTempF;
  private double minTempC;
  private double minTempF;
  private double avgTempC;
  private double avgTempF;
  private double maxWindMph;
  private double maxWindKph;
  private double totalPrecipMm;
  private double totalPrecipIn;
  private double totalSnowCm;
  private double avgVisKm;
  private double avgVisMiles;
  private double avgHumidity;
  private double dailyWillItRain;
  private double dailyChanceOfRain;
  private double dailyWillItSnow;
  private double dailyChanceOfSnow;
  Condition ConditionObject;
  private double uv;

  public Day(JsonNode dayNode) {
		try {
			this.maxTempC = dayNode.get("maxtemp_c").asDouble();
			this.maxTempF = dayNode.get("mintemp_f").asDouble();
			this.minTempC = dayNode.get("mintemp_c").asDouble();
			this.minTempF = dayNode.get("mintemp_f").asDouble();
			this.avgTempC = dayNode.get("avgtemp_c").asDouble();
			this.avgTempF = dayNode.get("avgtemp_f").asDouble();
			this.maxWindMph = dayNode.get("maxwind_mph").asDouble();
			this.maxWindKph = dayNode.get("maxwind_kph").asDouble();
			this.totalPrecipMm = dayNode.get("totalprecip_mm").asDouble();
			this.totalPrecipIn = dayNode.get("totalprecip_in").asDouble();
			this.totalSnowCm = dayNode.get("totalsnow_cm").asDouble();
			this.avgVisKm = dayNode.get("avgvis_km").asDouble();
			this.avgVisMiles = dayNode.get("avgvis_miles").asDouble();
			this.avgHumidity = dayNode.get("avghumidity").asDouble();
			this.dailyWillItRain = dayNode.get("daily_will_it_rain").asDouble();
			this.dailyChanceOfRain = dayNode.get("daily_chance_of_rain").asDouble();
			this.dailyWillItSnow = dayNode.get("daily_will_it_snow").asDouble();
			this.dailyChanceOfSnow = dayNode.get("daily_chance_of_snow").asDouble();
			this.ConditionObject = new Condition(dayNode.get("condition"));
			this.uv = dayNode.get("uv").asDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

 // Getter Methods 

  public double getMaxtempC() {
    return maxTempC;
  }

  public double getMaxTempF() {
    return maxTempF;
  }

  public double getMinTempC() {
    return minTempC;
  }

  public double getMinTempF() {
    return minTempF;
  }

  public double getAvgTempC() {
    return avgTempC;
  }

  public double getAvgTempF() {
    return avgTempF;
  }

  public double getMaxWindMph() {
    return maxWindMph;
  }

  public double getMaxWindKph() {
    return maxWindKph;
  }

  public double getTotalPrecipMm() {
    return totalPrecipMm;
  }

  public double getTotalPrecipIn() {
    return totalPrecipIn;
  }

  public double getTotalSnowCm() {
    return totalSnowCm;
  }

  public double getAvgVisKm() {
    return avgVisKm;
  }

  public double getAvgVisMiles() {
    return avgVisMiles;
  }

  public double getAvgHumidity() {
    return avgHumidity;
  }

  public double getDailyWillItRain() {
    return dailyWillItRain;
  }

  public double getDailyChanceOfRain() {
    return dailyChanceOfRain;
  }

  public double getDailyWillItSnow() {
    return dailyWillItSnow;
  }

  public double getDailyChanceOfSnow() {
    return dailyChanceOfSnow;
  }

  public Condition getCondition() {
    return ConditionObject;
  }

  public double getUv() {
    return uv;
  }

 // Setter Methods 

  public void setMaxTempC( double maxtemp_c ) {
    this.maxTempC = maxtemp_c;
  }

  public void setMaxTempF( double maxtemp_f ) {
    this.maxTempF = maxtemp_f;
  }

  public void setMinTempC( double minTempC ) {
    this.minTempC = minTempC;
  }

  public void setMinTempF( double minTempF ) {
    this.minTempF = minTempF;
  }

  public void setAvgTempC( double avgTempC ) {
    this.avgTempC = avgTempC;
  }

  public void setAvgTempF( double avgTempF ) {
    this.avgTempF = avgTempF;
  }

  public void setMaxWindMph( double maxWindMph ) {
    this.maxWindMph = maxWindMph;
  }

  public void setMaxWindKph( double maxWindKph ) {
    this.maxWindKph = maxWindKph;
  }

  public void setTotalPrecipMm( double totalPrecipMm ) {
    this.totalPrecipMm = totalPrecipMm;
  }

  public void setTotalPrecipIn( double totalPrecipIn ) {
    this.totalPrecipIn = totalPrecipIn;
  }

  public void setTotalSnowCm( double totalSnowCm ) {
    this.totalSnowCm = totalSnowCm;
  }

  public void setAvgVisKm( double avgVisKm ) {
    this.avgVisKm = avgVisKm;
  }

  public void setAvgVisMiles( double avgVisMiles ) {
    this.avgVisMiles = avgVisMiles;
  }

  public void setAvgHumidity( double avgHumidity ) {
    this.avgHumidity = avgHumidity;
  }

  public void setDailyWillItRain( double dailyWillItRain ) {
    this.dailyWillItRain = dailyWillItRain;
  }

  public void setDailyChanceOfRain( double dailyChanceOfRain ) {
    this.dailyChanceOfRain = dailyChanceOfRain;
  }

  public void setDailyWillItSnow( double dailyWillItSnow ) {
    this.dailyWillItSnow = dailyWillItSnow;
  }

  public void setDailyChanceOfSnow( double dailyChanceOfSnow ) {
    this.dailyChanceOfSnow = dailyChanceOfSnow;
  }

  public void setCondition( Condition conditionObject ) {
    this.ConditionObject = conditionObject;
  }

  public void setUv( double uv ) {
    this.uv = uv;
  }
}