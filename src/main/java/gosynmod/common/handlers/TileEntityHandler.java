package gosynmod.common.handlers;

import gosynmod.common.Reference;
import gosynmod.common.blocks.tileEntity.counter.TileEntitySpiritCounter;
import gosynmod.common.blocks.tileEntity.magicalMushrooom.TileEntityMagicalMushroooms;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntitySpiritCounter.class, Reference.MOD_ID + ":colorpicker");
		GameRegistry.registerTileEntity(TileEntityMagicalMushroooms.class, Reference.MOD_ID + ":mushroooms");
	}

}
