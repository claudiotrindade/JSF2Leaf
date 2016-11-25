package com.jsf2leaf.options;

/**
 * Created by Bartosz Wesolowski on 24.11.2016.
 */
public enum Position {
    TOP_LEFT("topleft"), TOP_RIGHT("topright"), BOTTOM_RIGHT("bottomright"), BOTTOM_LEFT("bottomleft");

    Position(final String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
