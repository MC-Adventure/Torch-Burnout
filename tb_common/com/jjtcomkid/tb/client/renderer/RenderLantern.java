/**
 * 
 */
package com.jjtcomkid.tb.client.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import com.jjtcomkid.tb.TorchBurnout;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@SideOnly(Side.CLIENT)
public class RenderLantern implements ISimpleBlockRenderingHandler {

	@Override
	public int getRenderId() {
		return TorchBurnout.renderLanternID;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		renderer.setOverrideBlockTexture(Block.planks.getIcon(0, 0));
		this.addInventoryBox(block, renderer, 4.0F, 0.0F, 4.0F, 8, 1, 8);
		this.addInventoryBox(block, renderer, 10.5F, 1.0F, 4.5F, 1, 8, 1);
		this.addInventoryBox(block, renderer, 4.5F, 1.0F, 4.5F, 1, 8, 1);
		this.addInventoryBox(block, renderer, 4.5F, 1.0F, 10.5F, 1, 8, 1);
		this.addInventoryBox(block, renderer, 10.5F, 1.0F, 10.5F, 1, 8, 1);
		this.addInventoryBox(block, renderer, 4.0F, 9.0F, 4.0F, 8, 1, 8);
		this.addInventoryBox(block, renderer, 5.0F, 10.0F, 5.0F, 6, 1, 6);
		this.addInventoryBox(block, renderer, 6.0F, 11.0F, 6.0F, 4, 1, 4);
		this.addInventoryBox(block, renderer, 6.5F, 12.0F, 7.5F, 1, 1, 1);
		this.addInventoryBox(block, renderer, 8.5F, 12.0F, 7.5F, 1, 1, 1);
		this.addInventoryBox(block, renderer, 6.5F, 13.0F, 7.5F, 3, 1, 1);
		renderer.setOverrideBlockTexture(Block.glowStone.getIcon(0, 0));
		this.addInventoryBox(block, renderer, 6.0F, 1.0F, 6.0F, 4, 6, 4);
		renderer.clearOverrideBlockTexture();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		renderer.setOverrideBlockTexture(Block.planks.getIcon(0, 0));
		this.addBox(block, x, y, z, renderer, 4.0F, 0.0F, 4.0F, 8, 1, 8);
		this.addBox(block, x, y, z, renderer, 10.5F, 1.0F, 4.5F, 1, 8, 1);
		this.addBox(block, x, y, z, renderer, 4.5F, 1.0F, 4.5F, 1, 8, 1);
		this.addBox(block, x, y, z, renderer, 4.5F, 1.0F, 10.5F, 1, 8, 1);
		this.addBox(block, x, y, z, renderer, 10.5F, 1.0F, 10.5F, 1, 8, 1);
		this.addBox(block, x, y, z, renderer, 4.0F, 9.0F, 4.0F, 8, 1, 8);
		this.addBox(block, x, y, z, renderer, 5.0F, 10.0F, 5.0F, 6, 1, 6);
		this.addBox(block, x, y, z, renderer, 6.0F, 11.0F, 6.0F, 4, 1, 4);
		this.addBox(block, x, y, z, renderer, 6.5F, 12.0F, 7.5F, 1, 1, 1);
		this.addBox(block, x, y, z, renderer, 8.5F, 12.0F, 7.5F, 1, 1, 1);
		this.addBox(block, x, y, z, renderer, 6.5F, 13.0F, 7.5F, 3, 1, 1);
		renderer.setOverrideBlockTexture(Block.glowStone.getIcon(0, 0));
		this.addBox(block, x, y, z, renderer, 6.0F, 1.0F, 6.0F, 4, 6, 4);
		renderer.clearOverrideBlockTexture();
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}
	
	private void addBox(Block block, int x, int y, int z, RenderBlocks renderer, double originX, double originY, double originZ, int width, int height, int depth) {
		renderer.setRenderBounds(originX / 16, originY / 16, originZ / 16, (originX + width) / 16, (originY + height) / 16, (originZ + depth) / 16);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.renderFaceYNeg(block, x, y, z, null);
	}
	
	private void addInventoryBox(Block block, RenderBlocks renderer, double originX, double originY, double originZ, int width, int height, int depth) {
		renderer.setRenderBounds(originX / 16, originY / 16, originZ / 16, (originX + width) / 16, (originY + height) / 16, (originZ + depth) / 16);
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, null);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, null);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, null);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, null);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, null);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, null);
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

}
