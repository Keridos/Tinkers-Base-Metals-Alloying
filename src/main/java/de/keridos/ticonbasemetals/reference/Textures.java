package de.keridos.ticonbasemetals.reference;

/**
 * Created by Keridos on 04.10.14.
 * This Class stores the location of textures for the mods items and blocks.
 */
public class Textures {
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final class Block {
        private static final String MODEL_TEXTURE_LOCATION = RESOURCE_PREFIX + "textures/blocks/";
        public static final String SMALL_FLUORESCENT_FLOODLIGHT_TEXTURE_OFF = MODEL_TEXTURE_LOCATION + "fluorescentSmallLight_off.png";
        public static final String SMALL_FLUORESCENT_FLOODLIGHT_TEXTURE_ON = MODEL_TEXTURE_LOCATION + "fluorescentSmallLight_on.png";
        public static final String SQUARE_FLUORESCENT_FLOODLIGHT_TEXTURE_OFF = MODEL_TEXTURE_LOCATION + "fluorescentSquareLight_off.png";
        public static final String SQUARE_FLUORESCENT_FLOODLIGHT_TEXTURE_ON = MODEL_TEXTURE_LOCATION + "fluorescentSquareLight_on.png";
        public static final String GROW_LIGHT_TEXTURE_ON = MODEL_TEXTURE_LOCATION + "growLight_on.png";
        public static final String GROW_LIGHT_TEXTURE_ON_LAMPS = MODEL_TEXTURE_LOCATION + "growLight_on_lamps.png";
        public static final String GROW_LIGHT_TEXTURE_OFF = MODEL_TEXTURE_LOCATION + "growLight_off.png";
    }

    public static final class Gui {
        private static final String GUI_TEXTURE_LOCATION = RESOURCE_PREFIX + "textures/gui/";
        public static final String CARBON_FLOODLIGHT = GUI_TEXTURE_LOCATION + "carbonFloodlight.png";
        public static final String ELECTRIC_FLOODLIGHT = GUI_TEXTURE_LOCATION + "electricFloodlight.png";
    }
}
