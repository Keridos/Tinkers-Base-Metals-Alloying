package de.keridos.ticonbasemetals.traits;

import de.keridos.ticonbasemetals.handler.ConfigHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Keridos on 02/08/2016.
 * This Class
 */
public class TraitCrushing extends AbstractTrait{
    public TraitCrushing() {
        super("crushing", TextFormatting.DARK_GRAY);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if (target.getHealth() < 0.5F * target.getMaxHealth()){
            return newDamage * (ConfigHandler.valueCrushingTrait/100F);
        } else {
            return newDamage;
        }
    }
}
