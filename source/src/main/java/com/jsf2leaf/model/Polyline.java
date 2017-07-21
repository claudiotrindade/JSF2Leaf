/*
A JSF2 Leaflet wrapper component for OpenStreetMap
Copyright (C) 2015 Leonardo Ciocari

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.*/

package com.jsf2leaf.model;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
	
	private List<LatLong> points = new ArrayList<LatLong>();
	private String popupMsg;
	private Style style = new Style();
	
	public String getPopupMsg() {
		return popupMsg;
	}

	public Polyline setPopupMsg(String popupMsg) {
		this.popupMsg = popupMsg;
		return this;
	}
	
	public String getColor() {
		return this.style.getColor();
	}

	public Polyline setColor(String color) {
		this.style.setColor(color);
		return this;
	}

	public int getWeight() {
		return this.style.getWeight();
	}

	/**
	 * Set the width of the Polyline
	 * @param weight Width in pixels
	 */
	public Polyline setWeight(int weight) {
		this.style.setWeight(weight);
		return this;
	}

	public Style getStyle() {
		return style;
	}

	/**
	 * Set the style of the Polyline
	 * @param style
	 */
	public Polyline setStyle(Style style) {
		this.style = style;
		return this;
	}

	public List<LatLong> getPoints() {
		return points;
	}

	public Polyline addPoint(List<LatLong> points) {
		this.points.addAll(points);
		return this;
	}
	
	public Polyline addPoint(LatLong point) {
		this.points.add(point);
		return this;
	}

	@Override
	public String toString() {
		return "Polyline [points=" + points.toString() + ", color=" + style.getColor() + ", weight="
				+ style.getWeight() + ", popupMsg=" + popupMsg + "]";
	}
	
}
