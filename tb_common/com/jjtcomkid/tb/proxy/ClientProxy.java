package com.jjtcomkid.tb.proxy;

import com.jjtcomkid.tb.client.renderer.RenderLantern;
import com.jjtcomkid.tb.client.renderer.RenderTorchNew;

import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderInformation() {
		super.registerRenderInformation();
		RenderingRegistry.registerBlockHandler(new RenderTorchNew());
		RenderingRegistry.registerBlockHandler(new RenderLantern());
	}

}
