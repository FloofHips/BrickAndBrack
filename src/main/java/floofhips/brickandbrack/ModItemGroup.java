package floofhips.brickandbrack;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroup {

    public static final ItemGroup BRICK_AND_BRACK = new ItemGroup("BrickAndBrack") {
        @Override
        public ItemStack makeIcon() {
            return Items.ACACIA_BOAT.getDefaultInstance();
        }
    };
}