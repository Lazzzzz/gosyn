package gosynmod.client.render.entity;

import gosynmod.client.model.ModelSpirit;
import gosynmod.common.Reference;
import gosynmod.common.entity.agressive.entitySpirit.EntitySpirit;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSpirit extends RenderLiving<EntitySpirit>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/spirit.png");
	
	public RenderSpirit(RenderManager manager) {
		super(manager, new ModelSpirit(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySpirit entity) {
		return TEXTURES;
	}
	
}
