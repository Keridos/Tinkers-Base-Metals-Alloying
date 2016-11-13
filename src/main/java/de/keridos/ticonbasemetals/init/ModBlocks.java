package de.keridos.ticonbasemetals.init;

import net.minecraft.block.Block;

/**
 * Created by Keridos on 04.10.14.
 * This Class manages all blocks and TileEntities that this mod uses.
 */
public class ModBlocks {
    public static Block blockElectricLight;
    public static Block blockCarbonLight;
    public static Block blockPhantomLight;
    public static Block blockSmallElectricLight;
    public static Block blockUVLight;
    public static Block blockUVLightBlock;
    public static Block blockGrowLight;

    public static void setupBlocks() {
        //blockElectricLight = new BlockElectricFloodlight();
    }

    public static void registerBlocks() {
        //GameRegistry.registerBlock(blockElectricLight, Names.Blocks.ELECTRIC_FLOODLIGHT);

    }
}
