package de.keridos.ticonbasemetals;

import de.keridos.ticonbasemetals.generic.BasicTinkerFluid;
import de.keridos.ticonbasemetals.reference.Reference;
import de.keridos.ticonbasemetals.util.GeneralUtil;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import java.lang.reflect.Field;

import static net.minecraftforge.fluids.FluidRegistry.registerFluid;

/**
 * Created by Keridos on 02/08/2016.
 * This Class
 */
public class Fluids {
    public static BasicTinkerFluid adamantineFluid = new BasicTinkerFluid("adamantine", 0xFF553A41, true, 538, 8, 3768);

    static void register() {
        Field[] declaredFields = Fluids.class.getDeclaredFields(); // Gets the blocks and ores declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    BasicTinkerFluid fluid = (BasicTinkerFluid) field.get(targetType); // Gets the field as a BasicTinkerFluid
                    registerFluid(fluid); // Registers the fluid into the game along wit its bucket

                    BlockMolten block = new BlockMolten(fluid);
                    // Sets names
                    block.setUnlocalizedName("molten_" + fluid.getName());
                    block.setRegistryName(Reference.MOD_ID, "molten_" + fluid.getName());
                    // Registers the fluid in its block form and its corresponding item (block/fluid as item in inventory)
                    GeneralUtil.registerBlockWithItem(block);
                    // Registers the fluid's model but only on the client side
                    TiConBaseMetals.proxy.registerFluidModels(fluid);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Registers special smeltery recipes (not alloying)
     */
}
