package com.jjtcomkid.tb.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

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
public class ItemTorchNew extends ItemBlock {

    public ItemTorchNew(int id) {
        super(id);
        hasSubtypes = true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int metadata) {
        if (metadata == 14)
            return TorchBurnout.torchNew.getIcon(0, 14);
        else
            return TorchBurnout.torchNew.getIcon(0, 0);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int damage = itemStack.getItemDamage();
        if (damage == 0)
            return "torchLit";
        else if (damage < 14)
            return "torchPartiallyLit-" + damage;
        else
            return "torchUnlit";
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean isHeld) {
        EntityPlayer player = (EntityPlayer) entity;

        if (player.inventory.hasItem(Block.torchWood.blockID))
            for (int itemSlot = slot; itemSlot < player.inventory.mainInventory.length; itemSlot++) {
                ItemStack invStack = player.inventory.getStackInSlot(itemSlot);

                if (invStack != null && invStack.itemID == Block.torchWood.blockID && invStack.getItemDamage() < 14) {
                    if (world.rand.nextInt(25) + world.rand.nextInt(25) + world.rand.nextInt(25) == 0)
                        player.inventory.setInventorySlotContents(itemSlot, new ItemStack(Block.torchWood, invStack.stackSize, invStack.getItemDamage() + 1));
                    if (invStack.getItemDamage() - 1 == 14)
                        player.playSound("random.fizz", 1.0F, 1.0F);
                }
            }
        super.onUpdate(itemStack, world, entity, slot, isHeld);

    }

}
