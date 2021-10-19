package floofhips.brickandbrack.datagen;

import floofhips.brickandbrack.BrickAndBrack;
import floofhips.brickandbrack.init.BlockInit;
import floofhips.brickandbrack.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;


public class LanguageGen extends LanguageProvider
{
    public LanguageGen(DataGenerator gen) {
        super(gen, BrickAndBrack.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        this.addItem(ItemInit.TUNGSTEN_INGOT, "Tungsten Ingot");

        this.addBlock(BlockInit.BUSH_BLOCK, "Bush Block");
        this.addBlock(BlockInit.DIRTY_PEBBLES, "Dirty Pebbles");
        this.addBlock(BlockInit.LARGE_CHAINS, "Large Chains");
        this.addBlock(BlockInit.LATTICE_BLOCK, "Lattice Block");
        this.addBlock(BlockInit.PEBBLED_DIRT, "Pebbled Dirt");
        this.addBlock(BlockInit.CLAY_ROOFING_BLOCK, "Clay Roofind Block");
        this.addBlock(BlockInit.CLAY_ROOFING_SLAB, "Clay Roofing Slab");
        this.addBlock(BlockInit.CLAY_ROOFING_STAIRS, "Clay Roofing Stairs");
        this.addBlock(BlockInit.CLAY_TILE_BLOCK, "Clay Tile Block");
        this.addBlock(BlockInit.SLATE_ROOFING_BLOCK, "Slate Roofind Block");
        this.addBlock(BlockInit.SLATE_ROOFING_SLAB, "Slate Roofing Slab");
        this.addBlock(BlockInit.SLATE_ROOFING_STAIRS, "Slate Roofing Stairs");
        this.addBlock(BlockInit.SLATE_TILE_BLOCK, "Slate Tile Block");
        this.addBlock(BlockInit.SHRUB, "Shrub");
        this.addBlock(BlockInit.OAK_POLE, "Oak Pole");
        this.addBlock(BlockInit.DIORITE_BRICKS, "Diorite Bricks");
        this.addBlock(BlockInit.DIORITE_TILES, "Diorite Tiles");
        this.addBlock(BlockInit.ANDESITE_TILES , "Andesite Bricks");
        this.addBlock(BlockInit.ANDESITE_BRICKS, "Andesite Tiles");
        this.addBlock(BlockInit.GRANITE_BRICKS, "Granite Bricks");
        this.addBlock(BlockInit.GRANITE_TILES, "Granite Tiles");
        this.addBlock(BlockInit.BASALT_BRICKS, "Basalt Bricks");
        this.addBlock(BlockInit.BASALT_TILES, "Basalt Tiles");
        this.addBlock(BlockInit.OBSIDIAN_BRICKS, "Obsidian Bricks");
        this.addBlock(BlockInit.CHISELED_ENDSTONE, "Chiseled Endstone");
        this.addBlock(BlockInit.CHISELED_PRISMARINE, "Chiseled Prismarine");

        this.add("itemGroup.BrickAndBrack", "Brick & Brack");
    }

}