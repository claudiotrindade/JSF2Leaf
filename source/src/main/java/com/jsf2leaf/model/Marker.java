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

import com.jsf2leaf.model.markers.MarkerIconType;
import com.jsf2leaf.model.markers.MarkerIconTypes;

public class Marker {

    public static final MarkerIconType DEFAULT = MarkerIconTypes.PinMarkers.BLUE;

    private LatLong position;
    private String popupMsg;
    private Pulse pulse;
    private MarkerIconType markerIconType;

    public Marker() {
        this(new LatLong("", ""));
    }

    /**
     * Creates a marker with specified portion, with no popup message and no pulsing and with {@link #DEFAULT} icon type
     * @param position
     */
    public Marker(LatLong position) {
        this(position, "");
    }

    public Marker(LatLong position, String popupMsg) {
        this(position, popupMsg, null);
    }

    public Marker(LatLong position, String popupMsg, Pulse pulse) {
        this(position, popupMsg, pulse, null);
    }

    public Marker(LatLong position, String popupMsg, Pulse pulse, MarkerIconType markerType) {
        this.position = position;
        this.popupMsg = popupMsg;
        this.pulse = pulse != null ? pulse : new Pulse(false);
        this.markerIconType = markerType != null ? markerType : DEFAULT;
    }

    public LatLong getPosition() {
        return position;
    }

    public Marker setPosition(LatLong position) {
        this.position = position;
        return this;
    }

    public String getPopupMsg() {
        return popupMsg;
    }

    public Marker setPopupMsg(String popupMsg) {
        this.popupMsg = popupMsg;
        return this;
    }

    public Pulse getPulse() {
        return pulse;
    }

    public void setPulse(Pulse pulse) {
        this.pulse = pulse;
    }

    public Marker setMarkerIconType(final MarkerIconType markerIconType) {
        this.markerIconType = markerIconType;
        return this;
    }

    /**
     * Name of the image file used to display this marker.
     * @return
     */
    public String getFileName() {
        return this.markerIconType.getFileName();
    }
    @Override
    public String toString() {
        return "Marker [position=" + position.toString()
                + ", popupMsg=" + popupMsg
                + ", pulse=" + pulse
                + "]";
    }

}
