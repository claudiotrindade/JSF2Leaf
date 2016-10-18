package com.jsf2leaf.model;

import java.util.Random;

/**
 * Created by Bartek on 2016-06-11.
 */
public enum Color {
    BLUE("#0000FF"),
    BLACK("#000000"),
    RED("#FF0000"),
    GREEN("#008000"),
    ORANGE("#FFA500"),
    YELLOW("#FFFF00"),

	/*
		PROPONUJE WYRZUCIC DARK_GREEN BO JEST NIEROZROZNIALNY Z GREEN,
		ZAMIAST TEGO DORZUCIŁEM CI PURPLE
	*/
	DARK_GREEN("#008000"),
	PURPLE("bc00b5")
    DARK_BROWN("#663300"),
    BRIGHT_BROWN("#c86300"),
    BRIGHT_BLUE("#9999ff"),
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
