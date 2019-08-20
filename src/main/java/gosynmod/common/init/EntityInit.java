package gosynmod.common.init;

import gosynmod.common.Gosyn;
import gosynmod.common.Reference;
import gosynmod.common.entity.agressive.entityKenpy.EntityKenpy;
import gosynmod.common.entity.agressive.entitySpirit.EntitySpirit;
import gosynmod.common.entity.other.EntityVortex;
import gosynmod.common.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	public static void registerEntitites() {
		registerEntityEgg("kenpy", EntityKenpy.class, ConfigHandler.ENTITY_KENPY_ID, 50, 000000, 000000);
		registerEntityEgg("spirit", EntitySpirit.class, ConfigHandler.ENTITY_SPIRIT_ID, 50, 000000, 000000);
	
		registerEntity("vortex", EntityVortex.class, ConfigHandler.ENTITY_VORTEX_ID, 50);
	}


	private static void registerEntityEgg(String name, Class<? extends Entity> entity, int id, int range, int color1,
			int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id,
				Gosyn.instance, range, 1, true, color1, color2);

	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id,
				Gosyn.instance, range, 1, true);

	}
}
