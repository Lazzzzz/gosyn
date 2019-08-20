package gosynmod.client.render.entity;

import gosynmod.client.model.ModelKenpy;
import gosynmod.common.Reference;
import gosynmod.common.entity.agressive.entityKenpy.EntityKenpy;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKenpy extends RenderLiving<EntityKenpy>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/kenpy.png");
	
	public RenderKenpy(RenderManager manager) {
		super(manager, new ModelKenpy(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityKenpy entity) {
		return TEXTURES;
	}
	
}
