package com.jjtcomkid.tb.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.jjtcomkid.tb.TorchBurnout;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemLantern extends ItemBlock {

    public ItemLantern(int id) {
        super(id);
        hasSubtypes = true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damage) {
        if (damage == 1 || damage == 3)
            return TorchBurnout.lantern.getIcon(0, 6);
        else
            return TorchBurnout.lantern.getIcon(0, 0);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int damage = itemStack.getItemDamage();
        switch (damage) {
            case 1:
                return "netherLantern";
            case 2:
                return "lanternHook";
            case 3:
                return "netherLanternHook";
            default:
                return "lantern";

        }
    }

}
