package gosynmod.client.model;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * NewProject - Undefined
 * Created using Tabula 7.0.1
 */
public class ModelSpirit extends AdvancedModelBase {
    public AdvancedModelRenderer body;
    public AdvancedModelRenderer body1;
    public AdvancedModelRenderer headMain;
    public AdvancedModelRenderer tail1;
    public AdvancedModelRenderer cloth;
    public AdvancedModelRenderer tail2;
    public AdvancedModelRenderer tail3;
    public AdvancedModelRenderer jaw;
    public AdvancedModelRenderer topHead;
    public AdvancedModelRenderer teath1;
    public AdvancedModelRenderer teath2;

	private ModelAnimator animator;
    
    public ModelSpirit() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.headMain = new AdvancedModelRenderer(this, 44, 0);
        this.headMain.setRotationPoint(0.0F, -0.6F, -0.2F);
        this.headMain.addBox(-2.5F, -5.0F, 0.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(headMain, 0.091106186954104F, 0.0F, 0.0F);
        this.topHead = new AdvancedModelRenderer(this, 0, 27);
        this.topHead.setRotationPoint(0.0F, -5.0F, 2.6F);
        this.topHead.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 7, 0.0F);
        this.setRotateAngle(topHead, -0.36425021489121656F, 0.0F, 0.0F);
        this.tail1 = new AdvancedModelRenderer(this, 74, 22);
        this.tail1.setRotationPoint(0.5F, -0.7F, -0.1F);
        this.tail1.addBox(-1.0F, -2.0F, -3.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(tail1, 0.4553564018453205F, 0.0F, 0.0F);
        this.body = new AdvancedModelRenderer(this, 71, 4);
        this.body.setRotationPoint(0.0F, 13.5F, 2.5F);
        this.body.addBox(-1.0F, -2.0F, -3.0F, 2, 2, 3, 0.0F);
        this.teath1 = new AdvancedModelRenderer(this, 47, 12);
        this.teath1.setRotationPoint(0.9F, 0.0F, 4.0F);
        this.teath1.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(teath1, 0.0F, 0.0F, 0.22759093446006054F);
        this.tail2 = new AdvancedModelRenderer(this, 74, 31);
        this.tail2.setRotationPoint(0.0F, 0.1F, -2.0F);
        this.tail2.addBox(-1.6F, -2.6F, -3.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(tail2, 0.4553564018453205F, 0.0F, 0.0F);
        this.teath2 = new AdvancedModelRenderer(this, 57, 12);
        this.teath2.setRotationPoint(-1.9F, 0.3F, 4.1F);
        this.teath2.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(teath2, 0.0F, 0.0F, -0.22759093446006054F);
        this.cloth = new AdvancedModelRenderer(this, 11, 5);
        this.cloth.setRotationPoint(0.5F, -2.9F, 0.6F);
        this.cloth.addBox(-2.0F, -0.2F, -2.5F, 4, 12, 5, 0.0F);
        this.setRotateAngle(cloth, -0.36425021489121656F, 0.0F, 0.0F);
        this.body1 = new AdvancedModelRenderer(this, 72, 13);
        this.body1.setRotationPoint(-0.5F, 0.5F, -2.2F);
        this.body1.addBox(-1.0F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(body1, 0.6373942428283291F, 0.0F, 0.0F);
        this.jaw = new AdvancedModelRenderer(this, 45, 17);
        this.jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.jaw.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(jaw, -0.31869712141416456F, 0.0F, 0.0F);
        this.tail3 = new AdvancedModelRenderer(this, 86, 5);
        this.tail3.setRotationPoint(0.0F, -0.1F, -2.5F);
        this.tail3.addBox(-1.0F, -2.0F, -7.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(tail3, -0.5462880558742251F, 0.0F, 0.0F);
        this.body.addChild(this.headMain);
        this.headMain.addChild(this.topHead);
        this.body1.addChild(this.tail1);
        this.jaw.addChild(this.teath1);
        this.tail1.addChild(this.tail2);
        this.jaw.addChild(this.teath2);
        this.body1.addChild(this.cloth);
        this.body.addChild(this.body1);
        this.headMain.addChild(this.jaw);
        this.tail2.addChild(this.tail3);
		animator = ModelAnimator.create();
		updateDefaultPose();
    
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer AdvancedModelRenderer, float x, float y, float z) {
        AdvancedModelRenderer.rotateAngleX = x;
        AdvancedModelRenderer.rotateAngleY = y;
        AdvancedModelRenderer.rotateAngleZ = z;
    }
}
