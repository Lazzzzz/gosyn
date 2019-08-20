package gosynmod.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * NewProject - Undefined Created using Tabula 7.0.1
 */
public class ModelMagicalMushrooom extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer shape1_1;
	public ModelRenderer shape4;
	public ModelRenderer shape4_1;
	public ModelRenderer shape4_2;
	public ModelRenderer shape4_3;
	public ModelRenderer shape;
	public ModelRenderer shape_1;
	public ModelRenderer shape4_4;
	public ModelRenderer shape4_5;
	public ModelRenderer shape_2;
	public ModelRenderer shape_3;

	public ModelMagicalMushrooom() {
		this.textureWidth = 16;
		this.textureHeight = 16;
		this.shape4_1 = new ModelRenderer(this, 0, 23);
		this.shape4_1.setRotationPoint(-1.0F, 19.0F, -1.0F);
		this.shape4_1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
		this.shape_3 = new ModelRenderer(this, 0, 23);
		this.shape_3.setRotationPoint(-5.8F, 19.1F, 3.4F);
		this.shape_3.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
		this.setRotateAngle(shape_3, -0.136659280431156F, 0.0F, 0.045553093477052F);
		this.shape4_5 = new ModelRenderer(this, 0, 19);
		this.shape4_5.setRotationPoint(3.9F, 21.6F, -3.7F);
		this.shape4_5.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.setRotateAngle(shape4_5, 0.0F, 0.40980330836826856F, 0.22759093446006054F);
		this.shape_1 = new ModelRenderer(this, 50, 0);
		this.shape_1.setRotationPoint(-6.0F, 22.0F, 4.0F);
		this.shape_1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
		this.setRotateAngle(shape_1, 0.136659280431156F, 0.31869712141416456F, 0.0F);
		this.shape_2 = new ModelRenderer(this, 50, 0);
		this.shape_2.setRotationPoint(3.0F, 22.0F, 5.0F);
		this.shape_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape_2, 0.0F, 0.31869712141416456F, 0.0F);
		this.shape1_1 = new ModelRenderer(this, 0, 17);
		this.shape1_1.setRotationPoint(-7.5F, 19.3F, -4.0F);
		this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(shape1_1, -0.18203784098300857F, 0.5009094953223726F, 0.0F);
		this.shape4_3 = new ModelRenderer(this, 0, 25);
		this.shape4_3.setRotationPoint(-0.7F, 21.7F, -6.4F);
		this.shape4_3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.setRotateAngle(shape4_3, 0.0F, 0.40980330836826856F, -0.091106186954104F);
		this.shape4_4 = new ModelRenderer(this, 50, 0);
		this.shape4_4.setRotationPoint(4.3F, 22.0F, -3.4F);
		this.shape4_4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape4_4, 0.0F, 0.40980330836826856F, 0.22759093446006054F);
		this.shape4 = new ModelRenderer(this, 50, 0);
		this.shape4.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.shape4.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
		this.setRotateAngle(shape4, 0.091106186954104F, 0.31869712141416456F, 0.0F);
		this.shape1 = new ModelRenderer(this, 50, 0);
		this.shape1.setRotationPoint(-7.0F, 20.5F, -4.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.setRotateAngle(shape1, -0.18203784098300857F, 0.5009094953223726F, 0.0F);
		this.shape = new ModelRenderer(this, 0, 18);
		this.shape.setRotationPoint(1.9F, 21.0F, 4.2F);
		this.shape.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
		this.setRotateAngle(shape, 0.0F, 0.31869712141416456F, 0.0F);
		this.shape4_2 = new ModelRenderer(this, 50, 0);
		this.shape4_2.setRotationPoint(0.0F, 22.6F, -6.0F);
		this.shape4_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape4_2, 0.0F, 0.40980330836826856F, -0.091106186954104F);
	}

	public void renderAll() {
		float f5 = 0.0625f;
		this.shape4_1.render(f5);
		this.shape_3.render(f5);
		this.shape4_5.render(f5);
		this.shape_1.render(f5);
		this.shape_2.render(f5);
		this.shape1_1.render(f5);
		this.shape4_3.render(f5);
		this.shape4_4.render(f5);
		this.shape4.render(f5);
		this.shape1.render(f5);
		this.shape.render(f5);
		this.shape4_2.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
