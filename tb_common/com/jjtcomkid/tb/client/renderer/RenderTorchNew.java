package com.jjtcomkid.tb.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import com.jjtcomkid.tb.TorchBurnout;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class RenderTorchNew implements ISimpleBlockRenderingHandler {

	@Override
	public int getRenderId() {
		return TorchBurnout.renderID;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int metadata = renderer.blockAccess.getBlockMetadata(x, y, z);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		double d0 = 0.4000000059604645D;
		double d1 = 0.5D - d0;
		double d2 = 0.20000000298023224D;
		int burnt = 0;

		if (metadata > 5) {
			burnt = 6;
		}

		if (metadata == 1 || metadata == 6) {
			renderer.renderTorchAtAngle(block, x - d1, y + d2, z, -d0, 0.0D, burnt);
		} else if (metadata == 2 || metadata == 7) {
			renderer.renderTorchAtAngle(block, x + d1, y + d2, z, d0, 0.0D, burnt);
		} else if (metadata == 3 || metadata == 8) {
			renderer.renderTorchAtAngle(block, x, y + d2, z - d1, 0.0D, -d0, burnt);
		} else if (metadata == 4 || metadata == 9) {
			renderer.renderTorchAtAngle(block, x, y + d2, z + d1, 0.0D, d0, burnt);
		} else {
			renderer.renderTorchAtAngle(block, x, y, z, 0.0D, 0.0D, burnt);
		}

		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

}
