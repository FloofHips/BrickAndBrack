package floofhips.brickandbrack.datagen;

import floofhips.brickandbrack.BrickAndBrack;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGen extends BlockTagsProvider {
    public BlockTagGen(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, BrickAndBrack.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
    }
}
