package de.keridos.ticonbasemetals;

import de.keridos.ticonbasemetals.traits.TraitCrushing;
import de.keridos.ticonbasemetals.traits.TraitTough;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Keridos on 02/08/2016.
 * This Class
 */
public class MaterialTraits {

    // new hardness levels

    // Init of new traits
    public static final AbstractTrait tough = new TraitTough();
    public static final AbstractTrait crushing = new TraitCrushing();




    public static Material adamantine = new Material("adamantine", TextFormatting.DARK_RED).addTrait(crushing, HeadMaterialStats.TYPE).addTrait(tough, HandleMaterialStats.TYPE).addTrait(tough, ExtraMaterialStats.TYPE);

}
