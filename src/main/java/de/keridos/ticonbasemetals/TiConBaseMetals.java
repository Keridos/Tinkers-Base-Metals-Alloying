package de.keridos.ticonbasemetals;

import com.google.common.collect.Lists;
import de.keridos.ticonbasemetals.core.proxy.CommonProxy;
import de.keridos.ticonbasemetals.handler.ConfigHandler;
import de.keridos.ticonbasemetals.handler.RecipeHandler;
import de.keridos.ticonbasemetals.item.Items;
import de.keridos.ticonbasemetals.reference.Reference;
import de.keridos.ticonbasemetals.util.RandomUtil;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

import java.lang.reflect.Field;
import java.util.List;

import static de.keridos.ticonbasemetals.Fluids.adamantineFluid;
import static de.keridos.ticonbasemetals.MaterialTraits.adamantine;
import static slimeknights.tconstruct.library.utils.HarvestLevels.COBALT;


/**
 * Created by Keridos on 28.02.14.
 * This Class is the Main Class of the Mod.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class TiConBaseMetals {
    @Mod.Instance(Reference.MOD_ID)
    public static TiConBaseMetals instance;

    @SidedProxy(clientSide = Reference.PROXY_LOCATION + ".ClientProxy", serverSide = Reference.PROXY_LOCATION + ".CommonProxy")
    public static CommonProxy proxy;

    private static ConfigHandler configHandler = null;
    private static RecipeHandler recipeHandler = null;

    private List<MaterialIntegration> integrateList = Lists.newArrayList(); // List of materials needed to be integrated

    //@NetworkCheckHandler()
    //public boolean matchModVersions(Map<String, String> remoteVersions, Side side) {
    //    return remoteVersions.containsKey("FloodLights") && Reference.VERSION.equals(remoteVersions.get("FloodLights"));
    //}

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configHandler = ConfigHandler.getInstance();
        configHandler.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
        Items.setupItems();
        Fluids.register();
        proxy.preInit();
        registerTinkerMaterials();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        recipeHandler = RecipeHandler.getInstance();
        recipeHandler.initRecipes();
        RandomUtil.init();
        proxy.initHandlers();
        for (MaterialIntegration m : integrateList) {
            m.integrateRecipes();
        }
    }

    @Mod.EventHandler
    public static void postInit(FMLServerStartingEvent event) {

    }


    private void registerTinkerMaterial(String oreSuffix, Material material, Fluid fluid, int headDura, float headSpeed, float headAttack, float handleMod, int handleDura, int extra, int headLevel, boolean craft, boolean cast) {
        TinkerRegistry.addMaterialStats(material, new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel));
        TinkerRegistry.addMaterialStats(material, new HandleMaterialStats(handleMod, handleDura));
        TinkerRegistry.addMaterialStats(material, new ExtraMaterialStats(extra));

        Item item = null;
        Field[] items = Items.class.getDeclaredFields();
        for (Field i : items) {
            if (i.getName().contains(StringUtils.uncapitalize(oreSuffix) +"_ingot")){
                Item r = null;
                try {
                    r = (Item) i.get(i.getType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                item = r;
            }
        }
        if (item == null) {
            return;
        }
        material.setFluid(fluid).setCraftable(craft).setCastable(cast).addItem(item, 1, Material.VALUE_Ingot);
        material.setRepresentativeItem(item);

        proxy.setRenderInfo(material);
        MaterialIntegration integration = new MaterialIntegration(material, fluid, oreSuffix);
        integration.integrate();
        integrateList.add(integration);
    }


    /**
     * Registers materials and associated fluids and stats into tconstruct
     */
    private void registerTinkerMaterials() {

        // Name, material,fluid,headdura,headspeed,headattack,handlemod,handledura,extra,
        registerTinkerMaterial("Adamantine", adamantine, adamantineFluid, 910 , 9.8f , 7.9f , 2.3f, 350, 350, COBALT, false, true);

    }
}
