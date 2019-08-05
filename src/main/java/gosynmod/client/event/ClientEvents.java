package gosynmod.client.event;

import gosynmod.common.Reference;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = {
		net.minecraftforge.fml.relauncher.Side.CLIENT })

public class ClientEvents {

	public ClientEvents() {
	}

	@SubscribeEvent
	public static void texStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();

		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particles/particle_vortex"));
	}
}
