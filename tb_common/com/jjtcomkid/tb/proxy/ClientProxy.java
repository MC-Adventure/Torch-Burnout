package com.jjtcomkid.tb.proxy;

import com.jjtcomkid.tb.client.renderer.RenderTorchNew;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderInformation() {
		super.registerRenderInformation();
		RenderingRegistry.registerBlockHandler(new RenderTorchNew());
	}

}
