package gosynmod.common.init;

import java.util.ArrayList;
import java.util.List;

import gosynmod.common.items.ItemAiguiteGem;
import gosynmod.common.items.ItemCreseolEmptyTablet;
import gosynmod.common.items.ItemCreseolTablet;
import gosynmod.common.items.ItemDebug;
import gosynmod.common.items.ItemMelynchStick;
import gosynmod.common.items.tools.aiguite.ToolsAiguiteAxe;
import gosynmod.common.items.tools.aiguite.ToolsAiguitePickaxe;
import gosynmod.common.items.tools.aiguite.ToolsAiguiteShovel;
import gosynmod.common.items.tools.aiguite.ToolsAiguiteSword;
import gosynmod.common.items.tools.melynch.ToolsMelynchAxe;
import gosynmod.common.items.tools.melynch.ToolsMelynchPickaxe;
import gosynmod.common.items.tools.melynch.ToolsMelynchShovel;
import gosynmod.common.items.tools.melynch.ToolsMelynchSword;
import net.minecraft.item.Item;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item MELYNCH_STICK 		  = new ItemMelynchStick();
	public static final Item AIGUITE_GEM 		  = new ItemAiguiteGem();
	public static final Item DEBUG		   		  = new ItemDebug();
	public static final Item CRESEOL_TABLET_EMPTY = new ItemCreseolEmptyTablet();
	public static final Item CRESEOL_TABLET 	  = new ItemCreseolTablet();
	
	public static final Item MELYNCH_SWORD   = new ToolsMelynchSword();
	public static final Item MELYNCH_AXE 	 = new ToolsMelynchAxe();
	public static final Item MELYNCH_PICKAXE = new ToolsMelynchPickaxe();
	public static final Item MELYNCH_SHOVEL  = new ToolsMelynchShovel();
		
	public static final Item AIGUITE_SWORD   = new ToolsAiguiteSword();
	public static final Item AIGUITE_AXE 	 = new ToolsAiguiteAxe();
	public static final Item AIGUITE_PICKAXE = new ToolsAiguitePickaxe();
	public static final Item AIGUITE_SHOVEL  = new ToolsAiguiteShovel();
}
