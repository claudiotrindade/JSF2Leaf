package com.jsf2leaf.model;

public class Feature {
	
	private String geometry;
	private String popupMsg;
	private Style style = new Style();
	
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
	
	

}
