package gosynmod.client.render.entity;

import gosynmod.client.model.ModelVortex;
import gosynmod.common.Reference;
import gosynmod.common.entity.other.EntityVortex;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVortex extends RenderLiving<EntityVortex>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/vortex.png");
	
	public RenderVortex(RenderManager manager) {
		super(manager, new ModelVortex(), 0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVortex entity) {
		return TEXTURES;
	}
	
}
