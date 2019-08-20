package gosynmod.common.init;

import gosynmod.common.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolsTypeInit {
	//ARMOR
	public static final ArmorMaterial PYRODES_ARMOR   = EnumHelper.addArmorMaterial("pyrodes_armor", Reference.MOD_ID + ":pyrodes", 30, new int[] {4, 7, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f);

	
	//TOOLS
	public static final ToolMaterial AIGUITE_TOOL   = EnumHelper.addToolMaterial("aiguite_tool", 2, 300, 7.0F, 2.5F, 20);
}
