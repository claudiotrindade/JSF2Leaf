package com.jsf2leaf.model.markers;

import com.jsf2leaf.model.Color;

/**
 * Type of a marker. Has a color and an image file for displaying it on map.
 * Created by Bartosz Wesolowski on 18.10.2016.
 */
public class MarkerIconType {

    MarkerIconType(final Color color, final String fileName) {
        this.color = color;
        this.fileName = fileName;
    }

    /**
     * Color of the marker. Opional.
     */
    private Color color;

    /**
     * Relative path to an image corresponding to the marker type. The file is located under resources/images/markers.
     * This image will be displayed on the map.
     */
    private String fileName;

    public Color getColor() {
        return this.color;
    }

    public String getFileName() {
        return this.fileName;
    }
}
