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
public class ModelSpiritCrawler extends AdvancedModelBase {
    public AdvancedModelRenderer neck;
    public AdvancedModelRenderer head_top;
    public AdvancedModelRenderer chest_right;
    public AdvancedModelRenderer jaw_middle;
    public AdvancedModelRenderer teeths_top;
    public AdvancedModelRenderer jaw_bottom;
    public AdvancedModelRenderer teeths_bottom;
    public AdvancedModelRenderer chest_left;
    public AdvancedModelRenderer shoulder_right;
    public AdvancedModelRenderer tail_3;
    public AdvancedModelRenderer shoulder_left;
    public AdvancedModelRenderer arm_left;
    public AdvancedModelRenderer hand_left;
    public AdvancedModelRenderer claw_left_1;
    public AdvancedModelRenderer claw_left_2;
    public AdvancedModelRenderer arm_right;
    public AdvancedModelRenderer hand_right;
    public AdvancedModelRenderer claw_right_1;
    public AdvancedModelRenderer claw_right_2;
    public AdvancedModelRenderer tail_2;
    public AdvancedModelRenderer tail_1;

	private ModelAnimator animator;
    
    public ModelSpiritCrawler() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.claw_left_2 = new AdvancedModelRenderer(this, 7, 60);
        this.claw_left_2.setRotationPoint(0.8F, 0.9F, -2.8F);
        this.claw_left_2.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(claw_left_2, 0.18203784098300857F, -0.18203784098300857F, -0.136659280431156F);
        this.claw_left_1 = new AdvancedModelRenderer(this, 0, 60);
        this.claw_left_1.setRotationPoint(-0.9F, 1.0F, -2.8F);
        this.claw_left_1.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(claw_left_1, 0.22759093446006054F, 0.31869712141416456F, 0.0F);
        this.shoulder_right = new AdvancedModelRenderer(this, 0, 31);
        this.shoulder_right.setRotationPoint(4.9F, 2.3F, 1.8F);
        this.shoulder_right.addBox(0.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.setRotateAngle(shoulder_right, -0.18203784098300857F, 0.0F, 0.0F);
        this.neck = new AdvancedModelRenderer(this, 48, 5);
        this.neck.setRotationPoint(0.0F, 11.9F, -0.6F);
        this.neck.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(neck, -0.136659280431156F, 0.0F, 0.0F);
        this.tail_2 = new AdvancedModelRenderer(this, 25, 10);
        this.tail_2.setRotationPoint(0.5F, 0.4F, 4.9F);
        this.tail_2.addBox(-2.5F, 0.0F, 0.0F, 4, 3, 5, 0.0F);
        this.setRotateAngle(tail_2, -0.31869712141416456F, -0.045553093477052F, 0.045553093477052F);
        this.head_top = new AdvancedModelRenderer(this, 60, 0);
        this.head_top.setRotationPoint(0.0F, 0.7F, 0.2F);
        this.head_top.addBox(-2.5F, -5.0F, -5.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(head_top, -0.045553093477052F, 0.0F, 0.091106186954104F);
        this.teeths_top = new AdvancedModelRenderer(this, 60, 11);
        this.teeths_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.teeths_top.addBox(-2.5F, 0.0F, -5.0F, 5, 1, 5, 0.0F);
        this.chest_left = new AdvancedModelRenderer(this, 23, 19);
        this.chest_left.setRotationPoint(0.9F, -0.4F, 0.1F);
        this.chest_left.addBox(-6.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
        this.setRotateAngle(chest_left, -0.045553093477052F, 0.0F, -0.36425021489121656F);
        this.tail_3 = new AdvancedModelRenderer(this, 22, 0);
        this.tail_3.setRotationPoint(0.3F, 0.5F, 3.5F);
        this.tail_3.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 5, 0.0F);
        this.setRotateAngle(tail_3, -0.4553564018453205F, 0.045553093477052F, -0.18203784098300857F);
        this.hand_right = new AdvancedModelRenderer(this, 0, 51);
        this.hand_right.setRotationPoint(-0.6F, 6.0F, 0.1F);
        this.hand_right.addBox(-1.0F, 0.0F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(hand_right, 0.136659280431156F, -0.136659280431156F, 0.091106186954104F);
        this.arm_left = new AdvancedModelRenderer(this, 31, 40);
        this.arm_left.setRotationPoint(-0.9F, 0.3F, 0.6F);
        this.arm_left.addBox(-1.0F, 0.4F, -1.5F, 2, 7, 2, 0.0F);
        this.setRotateAngle(arm_left, 0.091106186954104F, 0.045553093477052F, 0.091106186954104F);
        this.tail_1 = new AdvancedModelRenderer(this, 5, 8);
        this.tail_1.setRotationPoint(0.5F, 0.6F, 4.2F);
        this.tail_1.addBox(-2.5F, 0.0F, 0.0F, 3, 2, 6, 0.0F);
        this.setRotateAngle(tail_1, 0.22759093446006054F, -0.045553093477052F, 0.045553093477052F);
        this.teeths_bottom = new AdvancedModelRenderer(this, 63, 29);
        this.teeths_bottom.setRotationPoint(0.0F, -0.7F, 0.1F);
        this.teeths_bottom.addBox(-2.0F, 0.0F, -3.0F, 4, 1, 3, 0.0F);
        this.setRotateAngle(teeths_bottom, -0.091106186954104F, 0.0F, 0.0F);
        this.jaw_middle = new AdvancedModelRenderer(this, 63, 21);
        this.jaw_middle.setRotationPoint(0.0F, -0.1F, -1.1F);
        this.jaw_middle.addBox(-2.5F, 0.0F, -3.0F, 5, 1, 3, 0.0F);
        this.setRotateAngle(jaw_middle, 1.1838568316277536F, 0.0F, 0.0F);
        this.shoulder_left = new AdvancedModelRenderer(this, 30, 31);
        this.shoulder_left.setRotationPoint(-5.7F, 2.4F, 2.1F);
        this.shoulder_left.addBox(-2.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.setRotateAngle(shoulder_left, -0.136659280431156F, -0.091106186954104F, 0.22759093446006054F);
        this.arm_right = new AdvancedModelRenderer(this, 0, 40);
        this.arm_right.setRotationPoint(0.7F, 0.5F, 0.6F);
        this.arm_right.addBox(-1.0F, 0.4F, -1.5F, 2, 7, 2, 0.0F);
        this.setRotateAngle(arm_right, 0.22759093446006054F, 0.045553093477052F, -0.22759093446006054F);
        this.chest_right = new AdvancedModelRenderer(this, 3, 19);
        this.chest_right.setRotationPoint(-0.1F, 0.3F, 0.0F);
        this.chest_right.addBox(0.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
        this.setRotateAngle(chest_right, 0.0F, 0.0F, 0.136659280431156F);
        this.claw_right_1 = new AdvancedModelRenderer(this, 20, 60);
        this.claw_right_1.setRotationPoint(-0.3F, 0.9F, -2.6F);
        this.claw_right_1.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(claw_right_1, 0.40980330836826856F, 0.4553564018453205F, 0.27314402793711257F);
        this.jaw_bottom = new AdvancedModelRenderer(this, 65, 37);
        this.jaw_bottom.setRotationPoint(0.0F, 0.2F, -2.5F);
        this.jaw_bottom.addBox(-2.0F, 0.0F, -3.0F, 4, 1, 3, 0.0F);
        this.setRotateAngle(jaw_bottom, -0.7740535232594852F, 0.0F, 0.0F);
        this.hand_left = new AdvancedModelRenderer(this, 30, 51);
        this.hand_left.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.hand_left.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(hand_left, 0.27314402793711257F, 0.0F, 0.0F);
        this.claw_right_2 = new AdvancedModelRenderer(this, 30, 60);
        this.claw_right_2.setRotationPoint(1.4F, 0.9F, -2.7F);
        this.claw_right_2.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(claw_right_2, 0.27314402793711257F, -0.045553093477052F, 0.0F);
        this.hand_left.addChild(this.claw_left_2);
        this.hand_left.addChild(this.claw_left_1);
        this.chest_right.addChild(this.shoulder_right);
        this.tail_3.addChild(this.tail_2);
        this.neck.addChild(this.head_top);
        this.head_top.addChild(this.teeths_top);
        this.chest_right.addChild(this.chest_left);
        this.chest_right.addChild(this.tail_3);
        this.arm_right.addChild(this.hand_right);
        this.shoulder_left.addChild(this.arm_left);
        this.tail_2.addChild(this.tail_1);
        this.jaw_bottom.addChild(this.teeths_bottom);
        this.head_top.addChild(this.jaw_middle);
        this.chest_left.addChild(this.shoulder_left);
        this.shoulder_right.addChild(this.arm_right);
        this.neck.addChild(this.chest_right);
        this.hand_right.addChild(this.claw_right_1);
        this.jaw_middle.addChild(this.jaw_bottom);
        this.arm_left.addChild(this.hand_left);
        this.hand_right.addChild(this.claw_right_2);
        
		animator = ModelAnimator.create();
		updateDefaultPose();
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.neck.render(f5);
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
