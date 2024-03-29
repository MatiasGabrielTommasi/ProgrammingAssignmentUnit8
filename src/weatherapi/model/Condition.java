package weatherapi.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Condition {
  private String text;
  private String icon;
  private double code;


 // Getter Methods 

  public Condition(JsonNode conditionNode) {
		try {
			this.text = conditionNode.get("text").asText();
			this.icon = conditionNode.get("icon").asText();
			this.code = conditionNode.get("code").asDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}	
}

public String getText() {
    return text;
  }

  public String getIcon() {
    return "http:" + icon;
  }

  public double getCode() {
    return code;
  }

  public void setText( String text ) {
    this.text = text;
  }

  public void setIcon( String icon ) {
    this.icon = icon;
  }

  public void setCode( float code ) {
    this.code = code;
  }
}