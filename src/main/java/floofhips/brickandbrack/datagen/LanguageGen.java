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
        this.addBlock(BlockInit.ROOFING_BLOCK, "Roofind Block");
        this.addBlock(BlockInit.ROOFING_SLAB, "Roofing Slab");
        this.addBlock(BlockInit.ROOFING_STAIRS, "Roofing Stairs");
        this.addBlock(BlockInit.SHRUB, "Shrub");
        this.addBlock(BlockInit.TILE_BLOCK, "Tile Block");
        this.addBlock(BlockInit.OAK_POLE, "Oak Pole");

        this.add("itemGroup.BrickAndBrack", "Brick & Brack");
    }

}