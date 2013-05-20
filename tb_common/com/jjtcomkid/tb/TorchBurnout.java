package com.jjtcomkid.tb;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jjtcomkid.core.handler.LogHandler;
import com.jjtcomkid.core.handler.OverrideHandler;
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

	public static int renderID;

	public static BlockTorchNew torchNew;

	public static final LogHandler logger = new LogHandler("TorchBurnout");

	@Mod.Init
	public void init(FMLInitializationEvent event) {
		logger.info("Overiding vanilla torches.");

		Block.blocksList[50] = null;
		torchNew = new BlockTorchNew();

		OverrideHandler.replaceBlock(Block.torchWood, torchNew);

		proxy.registerRenderInformation();

		GameRegistry.registerTileEntity(com.jjtcomkid.tb.tileentity.TileEntityTorchNew.class, "Torch");

		Item.itemsList[50] = null;
		GameRegistry.registerBlock(torchNew, ItemTorchNew.class, "torchNew");

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
	}

}
