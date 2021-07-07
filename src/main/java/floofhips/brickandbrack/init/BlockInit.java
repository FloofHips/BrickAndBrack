package floofhips.brickandbrack.init;
import floofhips.brickandbrack.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final RegistryObject<Block> ROOFING_BLOCK = register("roofing_block", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

   // public static final RegistryObject<Block> HIGH_ROOFING_BLOCK = register("high_roofing_block", () -> new StairsBlock(() -> ROOFING_BLOCK.get().getStateForPlacement().hardnessAndResistance(2.0F, 6.0F)));

    private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return InitContent.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        InitContent.ITEMS.register(name, () ->new BlockItem(ret.get(), new Item.Properties().tab(ModItemGroup.BRICK_AND_BRACK)));
        return ret;
    }

    public static void register() {}
}
