package gosynmod.client.render.block;

import org.lwjgl.opengl.GL11;

import gosynmod.client.model.blocks.ModelMagicalMushrooom;
import gosynmod.common.Reference;
import gosynmod.common.blocks.tileEntity.magicalMushrooom.TileEntityMagicalMushroooms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMagicalMushrooom extends TileEntitySpecialRenderer<TileEntityMagicalMushroooms> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(
			Reference.MOD_ID + ":textures/blocks/plants/magic_mushrooom");
	private static final ModelMagicalMushrooom MODEL = new ModelMagicalMushrooom();

	@Override
	public void render(TileEntityMagicalMushroooms te, double x, double y, double z, float partialTicks,
			int destroyStage, float alpha) {
		GL11.glPushMatrix(); // ouvre une matrix
		GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D); // déplace le bloc sur les coordonnés et le centre
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F); // met droit le bloc (par défaut il est à l'envers)
		this.bindTexture(TEXTURE); // affiche la texture
		MODEL.renderAll(); // rend le modèle
		GL11.glPopMatrix(); // ferme la matrix
	}
}
