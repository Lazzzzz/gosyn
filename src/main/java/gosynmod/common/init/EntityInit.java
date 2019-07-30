package gosynmod.common.init;

import gosynmod.common.Gosyn;
import gosynmod.common.Reference;
import gosynmod.common.entity.agressive.entityKenpy.EntityKenpy;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	public static void registerEntitites() {
		registerEntity("kenpy", EntityKenpy.class, 121, 50, 000000, 000000);
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1,
			int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id,
				Gosyn.instance, range, 1, true, color1, color2);

	}
}
