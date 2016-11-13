package de.keridos.ticonbasemetals.util;

import java.util.Random;

/**
 * Created by Keridos on 08/02/2016.
 * This Class
 */
public class RandomUtil {
    public static Random random;

    public static void init() {
        random = new Random();
    }

    public static boolean getSuccess(float chance) {
        return (random.nextFloat() > chance);
    }
}