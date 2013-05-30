package com.jjtcomkid.tb.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.jjtcomkid.tb.TorchBurnout;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommonProxy implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public void registerRenderInformation() {
		TorchBurnout.renderTorchID = RenderingRegistry.getNextAvailableRenderId();
		TorchBurnout.renderLanternID = RenderingRegistry.getNextAvailableRenderId();
	}

}
