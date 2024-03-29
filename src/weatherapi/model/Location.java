package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Location {
  private String name;
  private String region;
  private String country;
  private String lat;
  private String lon;
  private String tzId;
  private double localtimeEpoch;
  private String localtime;


 // Getter Methods 

  public Location(JsonNode locationNode) {
		try {
			this.name = locationNode.get("name").asText();
			this.region = locationNode.get("region").asText();
			this.country = locationNode.get("country").asText();
			this.lat = locationNode.get("lat").asText();
			this.lon = locationNode.get("lon").asText();
			this.tzId = locationNode.get("tz_id").asText();
			this.localtimeEpoch = locationNode.get("localtime_epoch").asDouble();
			this.localtime = locationNode.get("localtime").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}	
}

public String getName() {
    return name;
  }

  public String getRegion() {
    return region;
  }

  public String getCountry() {
    return country;
  }

  public String getLat() {
    return lat;
  }

  public String getLon() {
    return lon;
  }

  public String getTzId() {
    return tzId;
  }

  public double getLocaltimeEpoch() {
    return localtimeEpoch;
  }

  public String getLocaltime() {
    return localtime;
  }

 // Setter Methods 

  public void setName( String name ) {
    this.name = name;
  }

  public void setRegion( String region ) {
    this.region = region;
  }

  public void setCountry( String country ) {
    this.country = country;
  }

  public void setLat( String lat ) {
    this.lat = lat;
  }

  public void setLon( String lon ) {
    this.lon = lon;
  }

  public void setTzId( String tzId ) {
    this.tzId = tzId;
  }

  public void setLocaltimeEpoch( double localtimeEpoch ) {
    this.localtimeEpoch = localtimeEpoch;
  }

  public void setLocaltime( String localtime ) {
    this.localtime = localtime;
  }
}