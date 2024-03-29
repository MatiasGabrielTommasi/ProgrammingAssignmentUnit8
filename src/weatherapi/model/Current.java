package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Current {
  private double lastUpdatedEpoch;
  private String lastUpdated;
  private double tempC;
  private double tempF;
  private boolean isDay;
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
  private double visKm;
  private double visMiles;
  private double uv;
  private double gustMph;
  private double gustKph;


 // Getter Methods 

  public Current(JsonNode currentNode) {
		try {
			this.lastUpdatedEpoch = currentNode.get("last_updated_epoch").asDouble();
			this.lastUpdated = currentNode.get("last_updated").asText();
			this.tempC = currentNode.get("temp_c").asDouble();
			this.tempF = currentNode.get("temp_f").asDouble();
			this.isDay = currentNode.get("is_day").asBoolean();
			this.ConditionObject = new Condition(currentNode.get("condition"));
			this.windMph = currentNode.get("wind_mph").asDouble();
			this.windKph = currentNode.get("wind_kph").asDouble();
			this.windDegree = currentNode.get("wind_degree").asDouble();
			this.windDir = currentNode.get("wind_dir").asText();
			this.pressureMb = currentNode.get("pressure_mb").asDouble();
			this.pressureIn = currentNode.get("pressure_in").asDouble();
			this.precipMm = currentNode.get("precip_mm").asDouble();
			this.precipIn = currentNode.get("precip_in").asDouble();
			this.humidity = currentNode.get("humidity").asDouble();
			this.cloud = currentNode.get("cloud").asDouble();
			this.feelslikeC = currentNode.get("feelslike_c").asDouble();
			this.feelslikeF = currentNode.get("feelslike_f").asDouble();
			this.visKm = currentNode.get("vis_km").asDouble();
			this.visMiles = currentNode.get("vis_miles").asDouble();
			this.uv = currentNode.get("uv").asDouble();
			this.gustMph = currentNode.get("gust_mph").asDouble();
			this.gustKph = currentNode.get("gust_kph").asDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}	
}

public double getLastUpdatedEpoch() {
    return lastUpdatedEpoch;
  }

  public String getLastUpdated() {
    return lastUpdated;
  }

  public double getTempC() {
    return tempC;
  }

  public double getTempF() {
    return tempF;
  }

  public Boolean getIsDay() {
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

  public double getVisKm() {
    return visKm;
  }

  public double getVisMiles() {
    return visMiles;
  }

  public double getUv() {
    return uv;
  }

  public double getGustMph() {
    return gustMph;
  }

  public double getGustKph() {
    return gustKph;
  }

  public void setLastUpdatedEpoch( double last_updated_epoch ) {
    this.lastUpdatedEpoch = last_updated_epoch;
  }

  public void setLastUpdated( String last_updated ) {
    this.lastUpdated = last_updated;
  }

  public void setTempC( double temp_c ) {
    this.tempC = temp_c;
  }

  public void setTempF( double temp_f ) {
    this.tempF = temp_f;
  }

  public void setIsDay( Boolean is_day ) {
    this.isDay = is_day;
  }

  public void setCondition( Condition conditionObject ) {
    this.ConditionObject = conditionObject;
  }

  public void setWindMph( double wind_mph ) {
    this.windMph = wind_mph;
  }

  public void setWindKph( double wind_kph ) {
    this.windKph = wind_kph;
  }

  public void setWindDegree( double wind_degree ) {
    this.windDegree = wind_degree;
  }

  public void setWindDir( String wind_dir ) {
    this.windDir = wind_dir;
  }

  public void setPressureMb( double pressure_mb ) {
    this.pressureMb = pressure_mb;
  }

  public void setPressureIn( double pressure_in ) {
    this.pressureIn = pressure_in;
  }

  public void setPrecipMm( double precip_mm ) {
    this.precipMm = precip_mm;
  }

  public void setPrecipIn( double precip_in ) {
    this.precipIn = precip_in;
  }

  public void setHumidity( double humidity ) {
    this.humidity = humidity;
  }

  public void setCloud( double cloud ) {
    this.cloud = cloud;
  }

  public void setFeelslikeC( double feelslike_c ) {
    this.feelslikeC = feelslike_c;
  }

  public void setFeelslikeF( double feelslike_f ) {
    this.feelslikeF = feelslike_f;
  }

  public void setVisKm( double vis_km ) {
    this.visKm = vis_km;
  }

  public void setVisMiles( double vis_miles ) {
    this.visMiles = vis_miles;
  }

  public void setUv( double uv ) {
    this.uv = uv;
  }

  public void setGustMph( double gust_mph ) {
    this.gustMph = gust_mph;
  }

  public void setGustKph( double gust_kph ) {
    this.gustKph = gust_kph;
  }
}