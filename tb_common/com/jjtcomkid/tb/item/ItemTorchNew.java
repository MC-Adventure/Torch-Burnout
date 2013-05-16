package com.jjtcomkid.tb.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

import com.jjtcomkid.tb.TorchBurnout;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTorchNew extends ItemBlock {

	public ItemTorchNew(int id) {
		super(id);
		hasSubtypes = true;
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
