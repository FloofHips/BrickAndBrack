package floofhips.brickandbrack.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ItemInit {
    public static final RegistryObject<Item> TUNGSTEN_INGOT = InitContent.ITEMS.register("tungsten_ingot", () ->
           new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)) );

    public static void register() {}
}
