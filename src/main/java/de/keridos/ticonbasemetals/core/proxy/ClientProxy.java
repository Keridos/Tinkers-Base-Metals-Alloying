package de.keridos.ticonbasemetals.core.proxy;

import de.keridos.ticonbasemetals.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.client.texture.MetalColoredTexture;
import slimeknights.tconstruct.library.materials.Material;

import javax.annotation.Nonnull;

/**
 * Created by Keridos on 28.02.14.
 * This Class is the proxy for the client.
 */
public class ClientProxy extends CommonProxy {
    private static final Minecraft minecraft = Minecraft.getMinecraft();

    public void registerItemModel(final Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName().toString().toLowerCase()));
    }

    public void registerItemModel(final Item item, int meta, final String variantName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().toString().toLowerCase()), variantName));
    }

    public void registerBlockModelAsItem(final Block block, int meta, final String blockName) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + blockName, "inventory"));
    }

    public void registerBlockModelAsItem(final Block block, int meta, final String blockName, String variantName) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + blockName, variantName));
    }

    @Override
    public void initRenderers() {

    }

    @Override
    public void preInit() {

    }


    @Override
    public void initHandlers() {

    }

    @Override
    public void setRenderInfo(final Material material) {
        material.setRenderInfo(new MaterialRenderInfo.BlockTexture("basemetals:blocks/" + material.getIdentifier() + "_block"));
    }

    private void specialRender(final Material material, final int f, final float shine, final float brightness, final float hueshift) {
        material.setRenderInfo(new MaterialRenderInfo.AbstractMaterialRenderInfo() {
            @Override
            public TextureAtlasSprite getTexture(TextureAtlasSprite baseTexture, String location) {
                return new MetalColoredTexture(baseTexture, location, f, shine, brightness, hueshift);
            }
        });
    }

    @Override
    public void registerFluidModels(Fluid fluid) {
        if (fluid == null) {
            return;
        }

        Block block = fluid.getBlock();
        if (block != null) {
            Item item = Item.getItemFromBlock(block);
            FluidStateMapper mapper = new FluidStateMapper(fluid);

            // item-model
            if (item != null) {
                ModelLoader.registerItemVariants(item);
                ModelLoader.setCustomMeshDefinition(item, mapper);
            }
            // block-model

            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }

    public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

        public final Fluid fluid;
        public final ModelResourceLocation location;

        public FluidStateMapper(Fluid fluid) {
            this.fluid = fluid;
            // have each block hold its fluid per nbt? hm
            this.location = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "fluid_block"), fluid.getName());
        }

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            return location;
        }

        @Nonnull
        @Override
        public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
            return location;
        }
    }
}