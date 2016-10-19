package com.jsf2leaf.model;

import java.util.Random;

/**
 * Created by Bartek on 2016-06-11.
 */
public enum Color {
    BLUE("#2E85CB"),
    BLACK("#000000"),
    RED("#CB2D29"),
    GREEN("#5CCB2B"),
    ORANGE("#E66700"),
    YELLOW("#EEF109"),
	CYAN("#07E4D2"),
	PURPLE("#9200B6"),
	PINK("FF87FB"),
    DARK_BROWN("#754015"),
    BRIGHT_BLUE("#93C2E7");

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
