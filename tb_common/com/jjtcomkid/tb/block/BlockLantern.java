/**
 * 
 */
package com.jjtcomkid.tb.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.jjtcomkid.tb.TorchBurnout;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockLantern extends Block {
	public BlockLantern(int par1) {
		super(par1, Material.wood);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}

	@Override
	public int getRenderType() {
		return TorchBurnout.renderLanternID;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = Block.planks.getIcon(0, 0);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

}
