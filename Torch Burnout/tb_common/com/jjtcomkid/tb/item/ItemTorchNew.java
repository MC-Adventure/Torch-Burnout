package com.jjtcomkid.tb.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.jjtcomkid.tb.TorchBurnout;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTorchNew extends ItemBlock {

	public ItemTorchNew(int id) {
		super(id);
		this.hasSubtypes = true;
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		int metadata = this.getMetadata(itemStack.getItemDamage());
		if (world.getBlockTileEntity(x, y, z) == null) {
			TileEntity tileEntity = TorchBurnout.torchNew.createTileEntity(world, 15 - metadata);
			world.setBlockTileEntity(x, y, z, tileEntity);
		}
		return super.onItemUse(itemStack, entityPlayer, world, x, y, z, side, hitX, hitY, hitZ);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int metadata) {
		if (metadata == 15)
			return TorchBurnout.torchNew.getIcon(0, 15);
		else
			return TorchBurnout.torchNew.getIcon(0, 0);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

}
