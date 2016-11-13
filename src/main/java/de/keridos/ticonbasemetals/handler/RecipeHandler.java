package de.keridos.ticonbasemetals.handler;

/**
 * Created by Keridos on 28.02.14.
 * This Class adds all Recipes for this mod.
 */
public class RecipeHandler {
    private static RecipeHandler instance = null;

    private RecipeHandler() {
    }

    public static RecipeHandler getInstance() {
        if (instance == null) {
            instance = new RecipeHandler();
        }
        return instance;
    }

    public void initRecipes() {
       /*
            GameRegistry.addRecipe(new ItemStack(ModItems.rawFilament, 1), " L ", "RGR", " L ", 'R', new ItemStack(getMinecraftItem("redstone"), 1), 'G', new ItemStack(getMinecraftItem("gold_ingot"), 1), 'L', new ItemStack(getMinecraftItem("glowstone_dust"), 1));
            FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.rawFilament, 1), new ItemStack(ModItems.glowingFilament, 1), 0.1F);
            GameRegistry.addRecipe(new ItemStack(ModItems.lightBulb, 1), " G ", "GFG", " I ", 'G', new ItemStack(getMinecraftItem("glass_pane"), 1), 'F', new ItemStack(ModItems.glowingFilament, 1), 'I', new ItemStack(getMinecraftItem("iron_ingot"), 1));
       */
    }
}
