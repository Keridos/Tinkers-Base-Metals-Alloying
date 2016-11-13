package de.keridos.ticonbasemetals.traits;

import de.keridos.ticonbasemetals.handler.ConfigHandler;
import de.keridos.ticonbasemetals.util.RandomUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Keridos on 02/08/2016.
 * This Class
 */
public class TraitTough extends AbstractTrait{
    public TraitTough() {
        super("tough", TextFormatting.DARK_GRAY);
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if (RandomUtil.getSuccess(ConfigHandler.chanceToughTrait)) {
            return damage;
        }                 else{
            return newDamage;
        }
    }
}
