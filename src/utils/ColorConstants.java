package utils;

import java.awt.Color;

public final class ColorConstants {

    public static final Color RICH_BLACK = new Color(0, 9, 20);
    public static final Color ROYAL_BLUE = new Color(1, 41, 95);
    public static final Color RED_CRAYOLA = new Color(238, 66, 102);
    public static final Color ATOMIC_TANGERINE = new Color(247, 138, 83);
    public static final Color SUNGLOW = new Color(255, 210, 63);
    public static final Color HONEYDEW = new Color(243, 252, 240);
    public static final Color BLUE_MUNSELL = new Color(0, 145, 173);


    private ColorConstants() throws InstantiationException {
        throw new InstantiationException("ColorConstants cannot be instantiated");
    }
}
