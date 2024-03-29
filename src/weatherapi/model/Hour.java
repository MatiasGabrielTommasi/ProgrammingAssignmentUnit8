package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Hour {
  private double timeEpoch;
  private String time;
  private double tempC;
  private double tempF;
  private double isDay;
  private Condition ConditionObject;
  private double windMph;
  private double windKph;
  private double windDegree;
  private String windDir;
  private double pressureMb;
  private double pressureIn;
  private double precipMm;
  private double precipIn;
  private double humidity;
  private double cloud;
  private double feelslikeC;
  private double feelslikeF;
  private double windchillC;
  private double windchillF;
  private double heatindexC;
  private double heatindexF;
  private double dewpointC;
  private double dewpointF;
  private double willItRain;
  private double chanceOfRain;
  private double willItSnow;
  private double chanceOfSnow;
  private double visKm;
  private double visMiles;
  private double gustMph;
  private double gustKph;
  private double uv;

  public Hour(JsonNode hourNode) {
		try {
			this.timeEpoch = hourNode.get("time_epoch").asDouble();
			this.time = hourNode.get("time").asText();
			this.tempC = hourNode.get("temp_c").asDouble();
			this.tempF = hourNode.get("temp_f").asDouble();
			this.isDay = hourNode.get("is_day").asDouble();
			this.ConditionObject = new Condition(hourNode.get("condition"));
			this.windMph = hourNode.get("wind_mph").asDouble();
			this.windKph = hourNode.get("wind_kph").asDouble();
			this.windDegree = hourNode.get("wind_degree").asDouble();
			this.windDir = hourNode.get("wind_dir").asText();
			this.pressureMb = hourNode.get("pressure_mb").asDouble();
			this.pressureIn = hourNode.get("pressure_in").asDouble();
			this.precipMm = hourNode.get("precip_mm").asDouble();
			this.precipIn = hourNode.get("precip_in").asDouble();
			this.humidity = hourNode.get("humidity").asDouble();
			this.cloud = hourNode.get("cloud").asDouble();
			this.feelslikeC = hourNode.get("feelslike_c").asDouble();
			this.feelslikeF = hourNode.get("feelslike_f").asDouble();
			this.windchillC = hourNode.get("windchill_c").asDouble();
			this.windchillF = hourNode.get("windchill_f").asDouble();
			this.heatindexC = hourNode.get("heatindex_c").asDouble();
			this.heatindexF = hourNode.get("heatindex_f").asDouble();
			this.dewpointC = hourNode.get("dewpoint_c").asDouble();
			this.dewpointF = hourNode.get("dewpoint_f").asDouble();
			this.willItRain = hourNode.get("will_it_rain").asDouble();
			this.chanceOfRain = hourNode.get("chance_of_rain").asDouble();
			this.willItSnow = hourNode.get("will_it_snow").asDouble();
			this.chanceOfSnow = hourNode.get("chance_of_snow").asDouble();
			this.visKm = hourNode.get("vis_km").asDouble();
			this.visMiles = hourNode.get("vis_miles").asDouble();
			this.gustMph = hourNode.get("gust_mph").asDouble();
			this.gustKph = hourNode.get("gust_kph").asDouble();
			this.uv = hourNode.get("uv").asDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

  public double getTimeEpoch() {
    return timeEpoch;
  }

  public String getTime() {
    return time;
  }

  public double getTempC() {
    return tempC;
  }

  public double getTempF() {
    return tempF;
  }

  public double getIsDay() {
    return isDay;
  }

  public Condition getCondition() {
    return ConditionObject;
  }

  public double getWindMph() {
    return windMph;
  }

  public double getWindKph() {
    return windKph;
  }

  public double getWindDegree() {
    return windDegree;
  }

  public String getWindDir() {
    return windDir;
  }

  public double getPressureMb() {
    return pressureMb;
  }

  public double getPressureIn() {
    return pressureIn;
  }

  public double getPrecipMm() {
    return precipMm;
  }

  public double getPrecipIn() {
    return precipIn;
  }

  public double getHumidity() {
    return humidity;
  }

  public double getCloud() {
    return cloud;
  }

  public double getFeelslikeC() {
    return feelslikeC;
  }

  public double getFeelslikeF() {
    return feelslikeF;
  }

  public double getWindchillC() {
    return windchillC;
  }

  public double getWindchillF() {
    return windchillF;
  }

  public double getHeatindexC() {
    return heatindexC;
  }

  public double getHeatindexF() {
    return heatindexF;
  }

  public double getDewpointC() {
    return dewpointC;
  }

  public double getDewpointF() {
    return dewpointF;
  }

  public double getWillItRain() {
    return willItRain;
  }

  public double getChanceOfRain() {
    return chanceOfRain;
  }

  public double getWillItSnow() {
    return willItSnow;
  }

  public double getChanceOfSnow() {
    return chanceOfSnow;
  }

  public double getVisKm() {
    return visKm;
  }

  public double getVisMiles() {
    return visMiles;
  }

  public double getGustMph() {
    return gustMph;
  }

  public double getGustKph() {
    return gustKph;
  }

  public double getUv() {
    return uv;
  }

  public void setTimeEpoch( double timeEpoch ) {
    this.timeEpoch = timeEpoch;
  }

  public void setTime( String time ) {
    this.time = time;
  }

  public void setTempC( double tempC ) {
    this.tempC = tempC;
  }

  public void setTempF( double tempF ) {
    this.tempF = tempF;
  }

  public void setIsDay( double isDay ) {
    this.isDay = isDay;
  }

  public void setCondition( Condition conditionObject ) {
    this.ConditionObject = conditionObject;
  }

  public void setWindMph( double windMph ) {
    this.windMph = windMph;
  }

  public void setWindKph( double windKph ) {
    this.windKph = windKph;
  }

  public void setWindDegree( double windDegree ) {
    this.windDegree = windDegree;
  }

  public void setWindDir( String windDir ) {
    this.windDir = windDir;
  }

  public void setPressureMb( double pressureMb ) {
    this.pressureMb = pressureMb;
  }

  public void setPressureIn( double pressureIn ) {
    this.pressureIn = pressureIn;
  }

  public void setPrecipMm( double precipMm ) {
    this.precipMm = precipMm;
  }

  public void setPrecipIn( double precipIn ) {
    this.precipIn = precipIn;
  }

  public void setHumidity( double humidity ) {
    this.humidity = humidity;
  }

  public void setCloud( double cloud ) {
    this.cloud = cloud;
  }

  public void setFeelslikeC( double feelslikeC ) {
    this.feelslikeC = feelslikeC;
  }

  public void setFeelslikeF( double feelslikeF ) {
    this.feelslikeF = feelslikeF;
  }

  public void setWindchillC( double windchillC ) {
    this.windchillC = windchillC;
  }

  public void setWindchillF( double windchillF ) {
    this.windchillF = windchillF;
  }

  public void setHeatindexC( double heatindexC ) {
    this.heatindexC = heatindexC;
  }

  public void setHeatindexF( double heatindexF ) {
    this.heatindexF = heatindexF;
  }

  public void setDewpointC( double dewpointC ) {
    this.dewpointC = dewpointC;
  }

  public void setDewpointF( double dewpointF ) {
    this.dewpointF = dewpointF;
  }

  public void setWillItRain( double willItRain ) {
    this.willItRain = willItRain;
  }

  public void setChanceOfRain( double chanceOfRain ) {
    this.chanceOfRain = chanceOfRain;
  }

  public void setWillItSnow( double willItSnow ) {
    this.willItSnow = willItSnow;
  }

  public void setChanceOfSnow( double chanceOfSnow ) {
    this.chanceOfSnow = chanceOfSnow;
  }

  public void setVisKm( double visKm ) {
    this.visKm = visKm;
  }

  public void setVisMiles( double visMiles ) {
    this.visMiles = visMiles;
  }

  public void setGustMph( double gustMph ) {
    this.gustMph = gustMph;
  }

  public void setGustKph( double gustKph ) {
    this.gustKph = gustKph;
  }

  public void setUv( double uv ) {
    this.uv = uv;
  }
}