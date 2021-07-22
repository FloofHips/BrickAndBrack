package floofhips.brickandbrack.init;
import floofhips.brickandbrack.ModItemGroup;
import floofhips.brickandbrack.blocks.*;
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

    public static final RegistryObject<Block> BUSH_BLOCK = register("bush_block", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(0.2F).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()));
    public static final RegistryObject<Block> SHRUB = register("shrub", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(0.2F).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()));

    // LightSources

    // Panes

    public static final RegistryObject<Block> LATTICE_BLOCK = register("lattice_block", () -> new PaneBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(2,2).harvestLevel(0).harvestTool(ToolType.AXE).requiresCorrectToolForDrops().sound(SoundType.SCAFFOLDING)));

    //Vanilla+ (Block Variations)

    public static final RegistryObject<Block> PEBBLED_DIRT = register("pebbled_dirt", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> DIRTY_PEBBLES = register("dirty_pebbles", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.NETHER_GOLD_ORE)));

    //Connectors

    public static final RegistryObject<Block> LARGE_CHAINS = register("large_chains", () -> new ConnectingPillarBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(2).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OAK_POLE = register("oak_pole", () -> new ConnectingPillarBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(2).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));

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
