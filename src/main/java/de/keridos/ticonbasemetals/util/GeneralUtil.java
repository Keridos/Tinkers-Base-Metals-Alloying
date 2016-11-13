package de.keridos.ticonbasemetals.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Keridos on 28/11/2014.
 * This Class
 */
public class GeneralUtil {

    public static Item getMinecraftItem(String name) {
        Item item;
        item = GameData.getItemRegistry().getRaw(GameData.getItemRegistry().getId(new ResourceLocation("minecraft", name)));
        return item;
    }

    public static String safeLocalize(String text) {
        if (I18n.translateToLocal(text) != null) {
            return I18n.translateToLocal(text);
        } else {
            return I18n.translateToFallback(text);
        }
    }

    public static void registerBlockWithItem(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    public static void registerTinkerAlloys(Fluid alloy, int out, Fluid first, int inOne, Fluid second, int inTwo) {
        NBTTagList tagList = new NBTTagList();
        NBTTagCompound fluid = new NBTTagCompound();
        fluid.setString("FluidName", alloy.getName());
        fluid.setInteger("Amount", out);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", first.getName());
        fluid.setInteger("Amount", inOne);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", second.getName());
        fluid.setInteger("Amount", inTwo);
        tagList.appendTag(fluid);

        NBTTagCompound message = new NBTTagCompound();
        message.setTag("alloy", tagList);
        FMLInterModComms.sendMessage("tconstruct", "alloy", message);
    }

    public static void registerTinkerAlloys(Fluid alloy, int out, Fluid first, int inOne, Fluid second, int inTwo, Fluid third, int inThree) {
        NBTTagList tagList = new NBTTagList();
        NBTTagCompound fluid = new NBTTagCompound();
        fluid.setString("FluidName", alloy.getName());
        fluid.setInteger("Amount", out);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", first.getName());
        fluid.setInteger("Amount", inOne);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", second.getName());
        fluid.setInteger("Amount", inTwo);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", third.getName());
        fluid.setInteger("Amount", inThree);
        tagList.appendTag(fluid);

        NBTTagCompound message = new NBTTagCompound();
        message.setTag("alloy", tagList);
        FMLInterModComms.sendMessage("tconstruct", "alloy", message);
    }
}
