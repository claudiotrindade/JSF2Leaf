package com.jsf2leaf.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Feature {
	
	private List<Property> properties;
	private String geometry;
	private String popupMsg;
	private Style style;
	
	public Feature() {
		this.properties = new ArrayList<Property>();
		this.style = new Style();
	}
	
	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public String getGeometry() {
		return geometry;
	}
	
	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}
	
	public String getPopupMsg() {
		return popupMsg;
	}
	
	public void setPopupMsg(String popupMsg) {
		this.popupMsg = popupMsg;
	}
	
	public Style getStyle() {
		return style;
	}
	
	public void setStyle(Style style) {
		this.style = style;
	}
	
	public String toGeoJSON() {
		JSONObject geometryProperties = new JSONObject();
		if (this.properties != null && !this.properties.isEmpty()) {
			for (Property prop : this.properties) {
				if (prop != null && prop.getKey() != null
						&& prop.getValue() != null)
					geometryProperties.put(prop.getKey(), prop.getValue());
			}
		}

		JSONObject ret = new JSONObject();
		ret.put("type", "Feature");
		ret.put("properties", geometryProperties);
		ret.put("geometry", this.geometry.isEmpty() ? new JSONObject() : new JSONObject(this.geometry));
		return ret.toString();
	}
	
	@Override
    public String toString() {
        return "Feature [geometry=" + geometry
                + ", popupMsg=" + popupMsg
                + ", style=" + style
                + ", properties=" + properties.toString()
                + "]";
    }

}
