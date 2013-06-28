/**
 * 
 */
package com.jjtcomkid.tb.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

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
        int basicMetadata = 0;
        if (metadata == 1 || metadata == 3)
            basicMetadata = 8;
        renderer.setOverrideBlockTexture(TorchBurnout.lantern.getIcon(0, basicMetadata));
        addInventoryBox(block, renderer, 4.0F, 0.0F, 4.0F, 8, 1, 8);
        addInventoryBox(block, renderer, 10.5F, 1.0F, 4.5F, 1, 8, 1);
        addInventoryBox(block, renderer, 4.5F, 1.0F, 4.5F, 1, 8, 1);
        addInventoryBox(block, renderer, 4.5F, 1.0F, 10.5F, 1, 8, 1);
        addInventoryBox(block, renderer, 10.5F, 1.0F, 10.5F, 1, 8, 1);
        addInventoryBox(block, renderer, 4.0F, 9.0F, 4.0F, 8, 1, 8);
        addInventoryBox(block, renderer, 5.0F, 10.0F, 5.0F, 6, 1, 6);
        addInventoryBox(block, renderer, 6.0F, 11.0F, 6.0F, 4, 1, 4);
        addInventoryBox(block, renderer, 6.5F, 12.0F, 7.5F, 1, 1, 1);
        addInventoryBox(block, renderer, 8.5F, 12.0F, 7.5F, 1, 1, 1);
        addInventoryBox(block, renderer, 6.5F, 13.0F, 7.5F, 3, 1, 1);
        renderer.setOverrideBlockTexture(Block.glowStone.getIcon(0, 0));
        addInventoryBox(block, renderer, 6.0F, 1.0F, 6.0F, 4, 6, 4);
        renderer.clearOverrideBlockTexture();
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int metadata = world.getBlockMetadata(x, y, z);
        int basicMetadata = metadata;
        if (metadata > 7)
            basicMetadata = metadata - 8;
        float xOffset = 4.0F;
        float yOffset = 0.0F;
        float zOffset = 4.0F;
        if (basicMetadata != 0 && basicMetadata != 1)
            yOffset = 2.0F;
        if (basicMetadata == 2)
            xOffset = 0.0F;
        if (basicMetadata == 3)
            xOffset = 8.0F;
        if (basicMetadata == 4)
            zOffset = 0.0F;
        if (basicMetadata == 5)
            zOffset = 8.0F;

        renderer.setOverrideBlockTexture(TorchBurnout.lantern.getIcon(0, metadata));
        addBox(block, x, y, z, renderer, xOffset, yOffset, zOffset, 8, 1, 8);
        addBox(block, x, y, z, renderer, xOffset + 6.5F, yOffset + 1.0F, zOffset + 0.5F, 1, 8, 1);
        addBox(block, x, y, z, renderer, xOffset + 0.5F, yOffset + 1.0F, zOffset + 0.5F, 1, 8, 1);
        addBox(block, x, y, z, renderer, xOffset + 0.5F, yOffset + 1.0F, zOffset + 6.5F, 1, 8, 1);
        addBox(block, x, y, z, renderer, xOffset + 6.5F, yOffset + 1.0F, zOffset + 6.5F, 1, 8, 1);
        addBox(block, x, y, z, renderer, xOffset, yOffset + 9.0F, zOffset, 8, 1, 8);
        addBox(block, x, y, z, renderer, xOffset + 1.0F, yOffset + 10.0F, zOffset + 1.0F, 6, 1, 6);
        addBox(block, x, y, z, renderer, xOffset + 2.0F, yOffset + 11.0F, zOffset + 2.0F, 4, 1, 4);
        if (basicMetadata == 0 || basicMetadata == 6) {
            addBox(block, x, y, z, renderer, xOffset + 2.5F, yOffset + 12.0F, zOffset + 3.5F, 1, 1, 1);
            addBox(block, x, y, z, renderer, xOffset + 4.5F, yOffset + 12.0F, zOffset + 3.5F, 1, 1, 1);
            addBox(block, x, y, z, renderer, xOffset + 2.5F, yOffset + 13.0F, zOffset + 3.5F, 3, 1, 1);
        } else {
            addBox(block, x, y, z, renderer, xOffset + 3.5F, yOffset + 12.0F, zOffset + 2.5F, 1, 1, 1);
            addBox(block, x, y, z, renderer, xOffset + 3.5F, yOffset + 12.0F, zOffset + 4.5F, 1, 1, 1);
            addBox(block, x, y, z, renderer, xOffset + 3.5F, yOffset + 13.0F, zOffset + 2.5F, 1, 1, 3);
        }
        renderer.setOverrideBlockTexture(renderer.getBlockIcon(Block.glowStone));
        addBox(block, x, y, z, renderer, xOffset + 2.0F, yOffset + 1.0F, zOffset + 2.0F, 4, 6, 4);
        renderer.clearOverrideBlockTexture();
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    private void addBox(Block block, int x, int y, int z, RenderBlocks renderer, double originX, double originY, double originZ, int width, int height, int depth) {
        renderer.setRenderBounds(originX / 16, originY / 16, originZ / 16, (originX + width) / 16, (originY + height) / 16, (originZ + depth) / 16);
        renderer.renderStandardBlock(block, x, y, z);
    }

    private void addInventoryBox(Block block, RenderBlocks renderer, double originX, double originY, double originZ, int width, int height, int depth) {
        double originY2 = originY + 3;
        renderer.setRenderBounds(originX / 16, originY2 / 16, originZ / 16, (originX + width) / 16, (originY2 + height) / 16, (originZ + depth) / 16);
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
