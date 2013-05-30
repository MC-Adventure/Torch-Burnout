package com.jjtcomkid.tb;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.jjtcomkid.core.handler.LogHandler;
import com.jjtcomkid.core.handler.OverrideHandler;
import com.jjtcomkid.tb.block.BlockLantern;
import com.jjtcomkid.tb.block.BlockRedstoneTorchNew;
import com.jjtcomkid.tb.block.BlockTorchNew;
import com.jjtcomkid.tb.item.ItemTorchNew;
import com.jjtcomkid.tb.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@Mod(modid = "TorchBurnout", name = "Torch Burnout", version = "0.0.0")
public class TorchBurnout {
	@SidedProxy(clientSide = "com.jjtcomkid.tb.proxy.ClientProxy", serverSide = "com.jjtcomkid.tb.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static int renderTorchID;
	public static int renderLanternID;

	public static BlockTorchNew torchNew;
	public static BlockRedstoneTorchNew torchRedstoneNew;
	public static Block lantern = new BlockLantern(200).setLightValue(1.0F);

	public static final LogHandler logger = new LogHandler("TorchBurnout");

	@Mod.Init
	public void init(FMLInitializationEvent event) {
		logger.info("Overiding vanilla torches.");
		for (String name : OreDictionary.getOreNames()) {
			logger.info(name);
		}

		if (OverrideHandler.removeRecipesWithResult(new ItemStack(Block.torchWood, 4)) == 2) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.torchWood, 4, 14), new Object[] { "X", "#", 'X', Item.coal, '#', "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.torchWood, 4, 14), new Object[] { "X", "#", 'X', new ItemStack(Item.coal, 1, 1), '#', "stickWood" }));
		} else {
			logger.severe("Unable to replace torch recipes");
		}
		GameRegistry.addSmelting(Block.torchWood.blockID, new ItemStack(Block.torchWood, 1), 0);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TorchBurnout.lantern, 4), new Object[] { "XXX", "#Y#", "XXX", 'X', "plankWood", '#', "stickWood", 'Y', Block.glowStone}));

		Block.blocksList[50] = null;
		Block.blocksList[76] = null;
		torchNew = (BlockTorchNew) new BlockTorchNew().setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("torchNew");
		torchRedstoneNew = (BlockRedstoneTorchNew) new BlockRedstoneTorchNew(true).setHardness(0.0F).setLightValue(0.8F / 3F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("notGate").setCreativeTab(CreativeTabs.tabRedstone);

		OverrideHandler.replaceBlock(Block.torchWood, torchNew);
		OverrideHandler.replaceBlock(Block.torchRedstoneActive, torchRedstoneNew);

		proxy.registerRenderInformation();

		GameRegistry.registerTileEntity(com.jjtcomkid.tb.tileentity.TileEntityTorchNew.class, "Torch");

		Item.itemsList[50] = null;
		GameRegistry.registerBlock(torchNew, ItemTorchNew.class, "torchNew");
		GameRegistry.registerBlock(lantern, "lantern");

		for (int i = 0; i <= 14; i++) {
			ItemStack torchNewBlockStack = new ItemStack(torchNew, 1, i);
			if (i == 0) {
				LanguageRegistry.addName(torchNewBlockStack, "Lit Torch");
			} else if (i < 14) {
				LanguageRegistry.addName(torchNewBlockStack, "Partially Burnt Torch");
			} else {
				LanguageRegistry.addName(torchNewBlockStack, "Unlit Torch");
			}
		}
		LanguageRegistry.addName(new ItemStack(lantern, 1), "Lantern");

	}

}
