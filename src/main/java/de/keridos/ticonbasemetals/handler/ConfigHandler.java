package de.keridos.ticonbasemetals.handler;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by Keridos on 06.10.14.
 * This Class manages the configuration file.
 */
public class ConfigHandler {
    private static ConfigHandler instance = null;

    public static boolean electricFloodlight;
    public static boolean smallElectricFloodlight;
    public static boolean carbonFloodlight;
    public static boolean uvFloodlight;
    public static boolean growLight;
    public static float chanceToughTrait;
    public static int valueCrushingTrait;
    public static int timeoutFloodlights;
    public static boolean uvLightRendered;
    public static boolean IGWNotifierEnabled;

    public static float damageUVFloodlight;

    private ConfigHandler() {
    }

    public static ConfigHandler getInstance() {
        if (instance == null) {
            instance = new ConfigHandler();
        }
        return instance;
    }

    public void initConfig(Configuration config) {
        config.load();
        config.getCategory("alloys");
        /*electricFloodlight = config.getBoolean("electricFloodlightEnabled", "blocks", true, "Enables the electric FloodLight");
        smallElectricFloodlight = config.getBoolean("smallElectricFloodlightEnabled", "blocks", true, "Enables the small electric FloodLight");
        carbonFloodlight = config.getBoolean("carbonFloodlightEnabled", "blocks", true, "Enables the carbon FloodLight");
        uvFloodlight = config.getBoolean("uvFloodlightEnabled", "blocks", true, "Enables the UV FloodLight");
        growLight = config.getBoolean("growLightEnabled", "blocks", true, "Enables the Grow Light");
        */
        config.getCategory("traits");
        chanceToughTrait = config.getFloat("chanceToughTrait", "traits", 0.1F, 0F, 1F, "How big should the chance for the tough trait to ignore damage be?");
        valueCrushingTrait = config.getInt("valueCrushingTrait", "traits", 25, 0, 100, "How big should the damage increase for the crushing trait be (in %)?");
        config.save();
    }
}
