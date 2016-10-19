package com.jsf2leaf.model.markers;

import com.jsf2leaf.model.Color;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bartosz Wesolowski on 18.10.2016.
 */
public final class MarkerIconTypes {

    /**
     * Return Marker Type with the bound to the passed color. If no value was found it returns the defaultValue.
     * @param color
     */
    static MarkerIconType getForColor(final List<MarkerIconType> markerTypes, final Color color, final MarkerIconType defaultValue) {
        return markerTypes.stream()
                .filter(markerType -> color == markerType.getColor()).findFirst().orElse(defaultValue);
    }

    /**
     * Return Marker Type with the bound to the passed color. If no marker type was found it returns the {@link com.jsf2leaf.model.MarkerType#BLUE}
     * @param color
     */
    static MarkerIconType getForColor(final List<MarkerIconType> markerTypes, final Color color) {
        return getForColor(markerTypes, color, new MarkerIconType(null, null));
    }

    /**
     * Markers that look like pin.
     */
    public static class PinMarkers {
        private static final List<MarkerIconType> pinMarkers;

        public static final MarkerIconType BLUE = new MarkerIconType(Color.BLUE, "pin/blue.png");
        public static final MarkerIconType BLACK = new MarkerIconType(Color.BLACK, "pin/black.png");
        public static final MarkerIconType RED = new MarkerIconType(Color.RED, "pin/red.png");
        public static final MarkerIconType GREEN = new MarkerIconType(Color.GREEN, "pin/green.png");
        public static final MarkerIconType ORANGE = new MarkerIconType(Color.ORANGE, "pin/orange.png");
        public static final MarkerIconType YELLOW = new MarkerIconType(Color.YELLOW, "pin/yellow.png");
        public static final MarkerIconType CYAN = new MarkerIconType(Color.CYAN, "pin/cyan.png");
        public static final MarkerIconType PURPLE = new MarkerIconType(Color.PURPLE, "pin/purple.png");
        public static final MarkerIconType PINK = new MarkerIconType(Color.PINK, "pin/pink.png");
        public static final MarkerIconType DARK_BROWN = new MarkerIconType(Color.DARK_BROWN, "pin/dark_brown.png");
        public static final MarkerIconType BRIGHT_BLUE = new MarkerIconType(Color.BRIGHT_BLUE, "pin/bright_blue.png");

        static {
            pinMarkers = Arrays.asList(BLUE, BLACK, RED, GREEN, ORANGE, YELLOW, CYAN, PURPLE, PINK, DARK_BROWN, BRIGHT_BLUE);
        }

        public static MarkerIconType getForColor(final Color color, final MarkerIconType defaultValue) {
            return MarkerIconTypes.getForColor(pinMarkers, color, defaultValue);
        }

        public static MarkerIconType getForColor(final Color color) {
            return MarkerIconTypes.getForColor(pinMarkers, color, BLUE);
        }
    }
    /**
     * Markers that look like houses.
     */
    public static class HouseMarkers {
        private static final List<MarkerIconType> houseMarkers;

        public static final MarkerIconType BLUE = new MarkerIconType(Color.BLUE, "house/blue.png");
        public static final MarkerIconType BLACK = new MarkerIconType(Color.BLACK, "house/black.png");
        public static final MarkerIconType RED = new MarkerIconType(Color.RED, "house/red.png");
        public static final MarkerIconType GREEN = new MarkerIconType(Color.GREEN, "house/green.png");
        public static final MarkerIconType ORANGE = new MarkerIconType(Color.ORANGE, "house/orange.png");
        public static final MarkerIconType YELLOW = new MarkerIconType(Color.YELLOW, "house/yellow.png");
        public static final MarkerIconType CYAN = new MarkerIconType(Color.CYAN, "house/cyan.png");
        public static final MarkerIconType PURPLE = new MarkerIconType(Color.PURPLE, "house/purple.png");
        public static final MarkerIconType PINK = new MarkerIconType(Color.PINK, "house/pink.png");
        public static final MarkerIconType DARK_BROWN = new MarkerIconType(Color.DARK_BROWN, "house/dark_brown.png");
        public static final MarkerIconType BRIGHT_BLUE = new MarkerIconType(Color.BRIGHT_BLUE, "house/bright_blue.png");

        static {
            houseMarkers = Arrays.asList(HouseMarkers.BLUE, HouseMarkers.BLACK, HouseMarkers.RED, HouseMarkers.GREEN,
                    HouseMarkers.ORANGE, HouseMarkers.YELLOW, HouseMarkers.CYAN, HouseMarkers.PURPLE,
                    HouseMarkers.PINK, HouseMarkers.DARK_BROWN, HouseMarkers.BRIGHT_BLUE);
        }

        public static MarkerIconType getForColor(final Color color, final MarkerIconType defaultValue) {
            return MarkerIconTypes.getForColor(houseMarkers, color, defaultValue);
        }

        public static MarkerIconType getForColor(final Color color) {
            return MarkerIconTypes.getForColor(houseMarkers, color, BLUE);
        }
    }
}
