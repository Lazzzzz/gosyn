package gosynmod.common.handlers;

import gosynmod.client.entityRender.RenderKenpy;
import gosynmod.client.entityRender.RenderVortex;
import gosynmod.common.entity.agressive.entityKenpy.EntityKenpy;
import gosynmod.common.entity.other.EntityVortex;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityKenpy.class, new IRenderFactory<EntityKenpy>() {

			@Override
			public Render<? super EntityKenpy> createRenderFor(RenderManager manager) {
				return new RenderKenpy(manager);

			}

		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVortex.class, new IRenderFactory<EntityVortex>() {

			@Override
			public Render<? super EntityVortex> createRenderFor(RenderManager manager) {
				return new RenderVortex(manager);

			}

		});
	}
}
