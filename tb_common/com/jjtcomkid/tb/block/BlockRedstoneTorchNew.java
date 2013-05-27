/**
 * 
 */
package com.jjtcomkid.tb.block;

import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.world.IBlockAccess;

/**
 * Torch Burnout
 * 
 * @author jjtcomkid
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockRedstoneTorchNew extends BlockRedstoneTorch {

	private boolean torchActive = false;

	public BlockRedstoneTorchNew(boolean par2) {
		super(76, par2);
		torchActive = par2;
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		if (torchActive)
			return 4;
		else
			return 0;
	}

}
