/**
 * 
 */
package com.jjtcomkid.tb.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
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
public class BlockLantern extends Block {
    public BlockLantern(int par1) {
        super(par1, Material.wood);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName("lantern");
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.isBlockSolidOnSide(x - 1, y, z, EAST, true) || world.isBlockSolidOnSide(x + 1, y, z, WEST, true) || world.isBlockSolidOnSide(x, y, z - 1, SOUTH, true) || world.isBlockSolidOnSide(x, y, z + 1, NORTH, true) || world.isBlockSolidOnSide(x, y + 1, z, DOWN, true) || canPlaceLanternOn(world, x, y - 1, z);
    }

    public boolean canPlaceLanternOn(World world, int x, int y, int z) {
        if (world.doesBlockHaveSolidTopSurface(x, y, z))
            return true;
        else {
            int Id = world.getBlockId(x, y, z);
            return (Block.blocksList[Id] != null && Block.blocksList[Id].canPlaceTorchOnTop(world, x, y, z));
        }

    }

    @Override
    public int damageDropped(int metadata) {
        if (metadata <= 7)
            return 2;
        else
            return 3;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int metadata) {
        if (metadata <= 7)
            return Block.planks.getIcon(0, 0);
        else
            return Block.netherBrick.getIcon(0, 0);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int id, CreativeTabs tabs, List itemList) {
        for (int i = 0; i <= 3; i++)
            itemList.add(new ItemStack(id, 1, i));
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
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        int setMetadata = metadata;
        if (metadata == 0 && world.rand.nextBoolean())
            setMetadata = 1;
        if (metadata == 1)
            if (world.rand.nextBoolean())
                setMetadata = metadata + 7;
            else
                setMetadata = metadata + 8;
        if (metadata == 2) {
            if (side == 1 && canPlaceLanternOn(world, x, y - 1, z))
                if (world.rand.nextBoolean())
                    setMetadata = 0;
                else
                    setMetadata = 1;
            if (side == 2 && world.isBlockSolidOnSide(x, y, z + 1, NORTH, true))
                setMetadata = 5;
            if (side == 3 && world.isBlockSolidOnSide(x, y, z - 1, SOUTH, true))
                setMetadata = 4;
            if (side == 4 && world.isBlockSolidOnSide(x + 1, y, z, WEST, true))
                setMetadata = 3;
            if (side == 5 && world.isBlockSolidOnSide(x - 1, y, z, EAST, true))
                setMetadata = 2;
            if (side == 6 && world.isBlockSolidOnSide(x, y, z, DOWN, true))
                if (world.rand.nextBoolean())
                    setMetadata = 6;
                else
                    setMetadata = 7;
        }
        if (metadata == 3) {
            if (side == 1 && canPlaceLanternOn(world, x, y - 1, z))
                if (world.rand.nextBoolean())
                    setMetadata = 8;
                else
                    setMetadata = 9;
            if (side == 2 && world.isBlockSolidOnSide(x, y, z + 1, NORTH, true))
                setMetadata = 13;
            if (side == 3 && world.isBlockSolidOnSide(x, y, z - 1, SOUTH, true))
                setMetadata = 12;
            if (side == 4 && world.isBlockSolidOnSide(x + 1, y, z, WEST, true))
                setMetadata = 11;
            if (side == 5 && world.isBlockSolidOnSide(x - 1, y, z, EAST, true))
                setMetadata = 10;
            if (side == 6 && world.isBlockSolidOnSide(x, y, z, DOWN, true))
                if (world.rand.nextBoolean())
                    setMetadata = 14;
                else
                    setMetadata = 15;
        }
        return setMetadata;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister icon) {
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        int metadata = world.getBlockMetadata(x, y, z);
        int basicMetadata = metadata;
        if (metadata > 5)
            basicMetadata = metadata - 8;
        float xOffset = 0.25F;
        float yOffset = 0.0F;
        float zOffset = 0.25F;
        if (basicMetadata != 0 && basicMetadata != 1)
            yOffset = 0.125F;
        if (basicMetadata == 2)
            xOffset = 0.0F;
        if (basicMetadata == 3)
            xOffset = 0.5F;
        if (basicMetadata == 4)
            zOffset = 0.0F;
        if (basicMetadata == 5)
            zOffset = 0.5F;

        setBlockBounds(xOffset, yOffset, zOffset, xOffset + 0.5F, yOffset + 0.875F, zOffset + 0.5F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return true;
    }

}
