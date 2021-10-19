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

    // The Vanilla+ Update (Block Variations)

    public static final RegistryObject<Block> PEBBLED_DIRT = register("pebbled_dirt", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> DIRTY_PEBBLES = register("dirty_pebbles", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.NETHER_GOLD_ORE)));
    public static final RegistryObject<Block> OAK_POLE = register("oak_pole", () -> new ConnectingPillarBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(2).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DIORITE_BRICKS = register("diorite_bricks", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GRANITE_BRICKS = register("granite_bricks", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANDESITE_BRICKS = register("andesite_bricks", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BASALT_BRICKS = register("basalt_bricks", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DIORITE_TILES = register("diorite_tiles", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GRANITE_TILES = register("granite_tiles", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANDESITE_TILES = register("andesite_tiles", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BASALT_TILES = register("basalt_tiles", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_ENDSTONE = register("chiseled_endstone", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_PRISMARINE = register("chiseled_prismarine", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> OBSIDIAN_BRICKS = register("obsidian_bricks", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

    // The Home Improvement Update

    public static final RegistryObject<Block> SLATE_ROOFING_BLOCK = register("slate_roofing_block", () -> new HorizontalConnectingBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<Block> SLATE_ROOFING_SLAB = register("slate_roofing_slab", () -> new HorizontalConnectingSlab(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
	public static final RegistryObject<Block> SLATE_ROOFING_STAIRS = register("slate_roofing_stairs", () -> new HorizontalConnectingStairs(() -> Blocks.AIR.defaultBlockState(), AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> SLATE_TILE_BLOCK = register("slate_tile_block", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CLAY_ROOFING_BLOCK = register("clay_roofing_block", () -> new HorizontalConnectingBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CLAY_ROOFING_SLAB = register("clay_roofing_slab", () -> new HorizontalConnectingSlab(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CLAY_ROOFING_STAIRS = register("clay_roofing_stairs", () -> new HorizontalConnectingStairs(() -> Blocks.AIR.defaultBlockState(), AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CLAY_TILE_BLOCK = register("clay_tile_block", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(5, 11).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    // The Dungeon Update

    public static final RegistryObject<Block> LARGE_CHAINS = register("large_chains", () -> new ChainsBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(2).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));

    // The Green Update

    public static final RegistryObject<Block> BUSH_BLOCK = register("bush_block", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(0.2F).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()));
    public static final RegistryObject<Block> SHRUB = register("shrub", () -> new Block(AbstractBlock.Properties.of(Material.DECORATION).strength(0.2F).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()));
    public static final RegistryObject<Block> LATTICE_BLOCK = register("lattice_block", () -> new PaneBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(2,2).harvestLevel(0).harvestTool(ToolType.AXE).requiresCorrectToolForDrops().sound(SoundType.SCAFFOLDING)));

    // The Factory Update

    // The Cozy Wozy Update

    // The Urban Update

    //registers

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
