package gosynmod.common.init;

import java.util.ArrayList;
import java.util.List;

import gosynmod.common.items.ItemDebug;
import gosynmod.common.items.ItemMelynchStick;
import gosynmod.common.items.tools.ToolsMelynchAxe;
import gosynmod.common.items.tools.ToolsMelynchPickaxe;
import gosynmod.common.items.tools.ToolsMelynchShovel;
import gosynmod.common.items.tools.ToolsMelynchSword;
import net.minecraft.item.Item;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item MELYNCH_STICK = new ItemMelynchStick();
	public static final Item DEBUG		   = new ItemDebug();
	
	public static final Item MELYNCH_SWORD   = new ToolsMelynchSword();
	public static final Item MELYNCH_AXE 	 = new ToolsMelynchAxe();
	public static final Item MELYNCH_PICKAXE = new ToolsMelynchPickaxe();
	public static final Item MELYNCH_SHOVEL  = new ToolsMelynchShovel();
}
