package gosynmod.common.handlers;

import java.io.File;

import gosynmod.common.Gosyn;
import gosynmod.common.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;

	public static void init(File file) {
		config = new Configuration(file);

		String category;

		category = "IDs Entity";

		config.addCustomCategoryComment(category, "Set ID's for ENTITY");

		category = "IDs GUI";

		config.addCustomCategoryComment(category, "Set ID's for GUI");

		category = "IDs Dimensions";

		config.addCustomCategoryComment(category, "Set ID's for Dimensions");

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
