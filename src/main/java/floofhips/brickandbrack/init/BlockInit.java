package floofhips.brickandbrack.init;
import floofhips.brickandbrack.ModItemGroup;
import floofhips.brickandbrack.blocks.HorizontalConnectingBlock;
import floofhips.brickandbrack.blocks.HorizontalConnectingSlab;
import floofhips.brickandbrack.blocks.HorizontalConnectingStairs;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {

    // Roofing

    public static final RegistryObject<Block> ROOFING_BLOCK = register("roofing_block", () -> new HorizontalConnectingBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<Block> ROOFING_SLAB = register("roofing_slab", () -> new HorizontalConnectingSlab(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<Block> ROOFING_STAIRS = register("roofing_stairs", () -> new HorizontalConnectingStairs(() -> Blocks.AIR.defaultBlockState(), AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> TILE_BLOCK = register("tile_block", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    // Plants

    // LightSources

    // Panes

    //Vanilla+ (Block Variations)

    //Special Blocks

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
