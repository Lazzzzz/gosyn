package gosynmod.common.handlers;

import java.io.File;

import gosynmod.common.Gosyn;
import gosynmod.common.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;
	
	public static int ENTITY_KENPY_ID = 121;
	
	public static int DIMENSION_GOSYN_ID = 130;

	public static void init(File file) {
		config = new Configuration(file);

		String category;

		//ENTITY
		
		category = "IDs Entity";

		ENTITY_KENPY_ID = config.getInt("ENTITY_KENPY_ID", category, ENTITY_KENPY_ID,
				2, 1000, "");		
		
		config.addCustomCategoryComment(category, "Set ID's for ENTITY");

		//GUI
		
		category = "IDs GUI";
		
		config.addCustomCategoryComment(category, "Set ID's for GUI");

		//DIM
		
		category = "IDs Dimensions";
		
		DIMENSION_GOSYN_ID = config.getInt("DIMENSION_GOSYN_ID", category, DIMENSION_GOSYN_ID,
				2, 1000, "");

		config.addCustomCategoryComment(category, "Set ID's for Dimensions");

		//GEN
		
		category = "World Gen & max Entity";

		config.addCustomCategoryComment(category, "World Gen & max Entity");
		config.save();
	}

	public static void registerConfig(FMLPreInitializationEvent event) {
		Gosyn.config = new File(event.getModConfigurationDirectory() + "/" +  Reference.MOD_ID);
		Gosyn.config.mkdirs();
		init(new File(Gosyn.config.getPath(), Reference.MOD_ID + ".cfg"));
	}

}
