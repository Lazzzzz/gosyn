package gosynmod.common.blocks.dungeons.stage1;

import net.minecraft.util.IStringSerializable;

public class enumFortnestBrickWalls {

	public static enum EnumType implements IStringSerializable {
		
		VARIANT_0(0, "variant_0"),
		VARIANT_1(1, "variant_1"),
		VARIANT_2(2, "variant_2");
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
		private final String name, unlocializedName;
		
		private EnumType(int meta, String name) {
			this(meta, name, name);
			
		}
		
		private EnumType(int meta, String name, String unlocializedName) {
			
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return this.meta;
		}
		
		public String getUnlocializedName() {
			return this.unlocializedName;
		
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		 public static EnumType byMetadata(int meta) {
			return META_LOOKUP[meta];
			
		}
		 
		 static {
			 for (EnumType enumtype : values() ) {
				 META_LOOKUP[enumtype.getMeta()] = enumtype;
			 }
		 }
		
	}
	
}
