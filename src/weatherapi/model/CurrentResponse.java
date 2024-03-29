package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class CurrentResponse {
	  Location location;
	  Current current;

	  public CurrentResponse(JsonNode locationNode, JsonNode currentNode) {
			try {
				this.location = new Location(locationNode);
				this.current = new Current(currentNode);
			} catch (Exception e) {
				e.printStackTrace();
			}	
	}

	public Location getLocation() {
	    return location;
	  }

	  public Current getCurrent() {
	    return current;
	  }

	  public void setLocation( Location locationObject ) {
	    this.location = locationObject;
	  }

	  public void setCurrent( Current currentObject ) {
	    this.current = currentObject;
	  }
}