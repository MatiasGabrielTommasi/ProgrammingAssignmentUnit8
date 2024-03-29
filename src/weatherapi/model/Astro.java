package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Astro {
  private String sunrise;
  private String sunset;
  private String moonrise;
  private String moonset;
  private String moonPhase;
  private double moonIllumination;
  private boolean isMoonUp;
  private boolean isSunUp;


  public Astro(JsonNode astroNode) {
		try {
			  this.sunrise = astroNode.get("sunrise").asText();
			  this.sunset = astroNode.get("sunset").asText();
			  this.moonrise = astroNode.get("moonrise").asText();
			  this.moonset = astroNode.get("moonset").asText();
			  this.moonPhase = astroNode.get("moon_phase").asText();
			  this.moonIllumination = astroNode.get("moon_illumination").asDouble();
			  this.isMoonUp = astroNode.get("is_moon_up").asBoolean();
			  this.isSunUp = astroNode.get("is_sun_up").asBoolean();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

  public String getSunrise() {
    return sunrise;
  }

  public String getSunset() {
    return sunset;
  }

  public String getMoonrise() {
    return moonrise;
  }

  public String getMoonset() {
    return moonset;
  }

  public String getMoonPhase() {
    return moonPhase;
  }

  public double getMoonIllumination() {
    return moonIllumination;
  }

  public boolean getIsMoonUp() {
    return isMoonUp;
  }

  public boolean getIsSunUp() {
    return isSunUp;
  }

  public void setSunrise( String sunrise ) {
    this.sunrise = sunrise;
  }

  public void setSunset( String sunset ) {
    this.sunset = sunset;
  }

  public void setMoonrise( String moonrise ) {
    this.moonrise = moonrise;
  }

  public void setMoonset( String moonset ) {
    this.moonset = moonset;
  }

  public void setMoonPhase( String moon_phase ) {
    this.moonPhase = moon_phase;
  }

  public void setMoonIllumination( double moon_illumination ) {
    this.moonIllumination = moon_illumination;
  }

  public void setIsMoonUp( boolean is_moon_up ) {
    this.isMoonUp = is_moon_up;
  }

  public void setIsSunUp( boolean is_sun_up ) {
    this.isSunUp = is_sun_up;
  }
}