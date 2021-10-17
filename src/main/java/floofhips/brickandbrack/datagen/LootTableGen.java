package floofhips.brickandbrack.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import floofhips.brickandbrack.BrickAndBrack;
import floofhips.brickandbrack.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.FishingLootTables;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeLootTableProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTableGen extends ForgeLootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> tables = ImmutableList.of(Pair.of(BlockProvider::new, LootParameterSets.BLOCK));

    public LootTableGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return tables;
    }

    private static class BlockProvider extends BlockLootTables
    {
        @Override
        protected void addTables()
        {
            // A few common examples for block drops (look in BlockLoot for more examples):
            this.dropSelf(BlockInit.BUSH_BLOCK.get());
            this.dropSelf(BlockInit.DIRTY_PEBBLES.get());
            this.dropSelf(BlockInit.LARGE_CHAINS.get());
            this.dropSelf(BlockInit.LATTICE_BLOCK.get());
            this.dropSelf(BlockInit.PEBBLED_DIRT.get());
            this.dropSelf(BlockInit.ROOFING_BLOCK.get());
            this.dropSelf(BlockInit.ROOFING_SLAB.get());
            this.dropSelf(BlockInit.ROOFING_STAIRS.get());
            this.dropSelf(BlockInit.SHRUB.get());
            this.dropSelf(BlockInit.TILE_BLOCK.get());
            this.dropSelf(BlockInit.OAK_POLE.get());

//            this.dropOther(ModBlocks.EXAMPLE_BLOCK.get(), Blocks.STONE);
//            this.add(ModBlocks.EXAMPLE_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.STONE));
        }

        @Override
        protected Iterable<Block> getKnownBlocks()
        {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(entityType -> entityType.getRegistryName() != null && BrickAndBrack.MOD_ID.equals(entityType.getRegistryName().getNamespace())).collect(Collectors.toSet());
        }
    }

}
