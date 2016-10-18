package com.jsf2leaf.model;

import java.util.Random;

/**
 * Created by Bartek on 2016-06-11.
 */
public enum Color {
    BLUE("blue"),
    BLACK("black"),
    RED("red"),
    GREEN("green"),
    ORANGE("orange"),
    YELLOW("yellow"),

    DARK_GREEN("#008000"),
    DARK_BROWN("#663300"),
    BRIGHT_BROWN("#ff8000"),
    BRIGHT_BLUE("#3d0066"),
    PASTEL_GREEN("#00ff00");

    private static int nextColorNumber = 0;

    private static final Random random = new Random(System.nanoTime());
    /**
     * String representation of color. Accepts hex values
     */
    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Color getRandomColor() {
        final int index = random.nextInt(values().length) % values().length;
        return getColor(index);
    }

    public static Color getNextColor() {
        final Color color = getColor(nextColorNumber);
        nextColorNumber = (nextColorNumber + 1) % values().length;
        return color;
    }

    /**
     * Gets the color by the index from values(). Reduces index modulo values.length
     *
     * @param index
     * @return
     */
    public static Color getColor(final int index) {
        final int i = index % values().length;
        return values()[i];
    }
}
