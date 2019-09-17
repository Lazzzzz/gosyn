package gosynmod.client.event;

import gosynmod.common.Reference;
import gosynmod.common.handlers.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public class ClientEvents {

	static float timer = 0f;
	static float maxFog = 0.05f;
	static float steps = 0.00005f;

	@SubscribeEvent
	public static void texStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();

		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particles/particle_vortex"));
		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particles/particle_falling_leaf"));
	}

	@SubscribeEvent
	public static void onColorFog(EntityViewRenderEvent.RenderFogEvent.FogColors e) {
		if (Minecraft.getMinecraft().getRenderViewEntity() instanceof EntityPlayer) {
			e.setRed(77);
			e.setGreen(12);
			e.setBlue(72);

		}
	}

	@SubscribeEvent
	public static void onSetupFogDensity(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
		if (Minecraft.getMinecraft().getRenderViewEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().getRenderViewEntity();
			if (player.dimension == ConfigHandler.DIMENSION_GOSYN_ID && player.posY < 63) {
				if (timer < maxFog)
					timer += steps / 2;
				GlStateManager.setFog(GlStateManager.FogMode.EXP);
				event.setCanceled(true);
				event.setDensity(timer);
			} else {
				if (timer > 0)
					timer -= steps;
				if (timer != 0) {
					GlStateManager.setFog(GlStateManager.FogMode.EXP);
					event.setCanceled(true);
					event.setDensity(timer);
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void GlobalFog(DrawBlockHighlightEvent e) {
		
	}
}
