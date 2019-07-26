package gosynmod.common.init;

import gosynmod.common.dimension.DimensionLibraryGosyn;
import gosynmod.common.handlers.ConfigHandler;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit {
	public static final DimensionType GOSYN  = DimensionType.register("Gosyn", "_gosyn", ConfigHandler.DIMENSION_GOSYN_ID, DimensionLibraryGosyn.class, false);

	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_GOSYN_ID, GOSYN);
	}
}
