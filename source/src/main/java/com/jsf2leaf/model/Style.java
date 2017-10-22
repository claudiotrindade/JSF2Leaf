package com.jsf2leaf.model;

public class Style {
	
	private int weight = 3;
	private String color = "#3388ff";
	private double opacity = 1.0;
	private boolean fill = true;
	private String fillColor = "";
	private double fillOpacity = 0.2;
	
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * @param weight the weight to set
	 */
	public Style setWeight(int weight) {
		this.weight = weight;
		return this;
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @param color the color to set
	 */
	public Style setColor(String color) {
		this.color = color;
		return this;
	}
	
	/**
	 * @return the opacity
	 */
	public double getOpacity() {
		return opacity;
	}
	
	/**
	 * @param opacity the opacity to set
	 */
	public Style setOpacity(double opacity) {
		this.opacity = opacity;
		return this;
	}
	
	/**
	 * @return the fill
	 */
	public boolean isFill() {
		return fill;
	}
	
	/**
	 * @param fill the fill to set
	 */
	public Style setFill(boolean fill) {
		this.fill = fill;
		return this;
	}
	
	/**
	 * @return the fillColor
	 */
	public String getFillColor() {
		return fillColor;
	}
	
	/**
	 * @param fillColor the fillColor to set
	 */
	public Style setFillColor(String fillColor) {
		this.fillColor = fillColor;
		return this;
	}
	
	/**
	 * @return the fillOpacity
	 */
	public double getFillOpacity() {
		return fillOpacity;
	}
	
	/**
	 * @param fillOpacity the fillOpacity to set
	 */
	public Style setFillOpacity(double fillOpacity) {
		this.fillOpacity = fillOpacity;
		return this;
	}


	@Override
	public String toString() {
		return "Style [weight=" + weight
				+ ", color=" + color
				+ ", opacity=" + opacity 
				+ ", fill=" + fill
				+ ", fillColor=" + fillColor
				+ ", fillOpacity=" + fillOpacity
				+ "]";
	}
	
}
