package floofhips.brickandbrack.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.block.SlabBlock.TYPE;

public class ChainsBlock extends RotatedPillarBlock {
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    public ChainsBlock(Properties properties) {
        super(properties);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, AXIS);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getClickedPos();
        return this.defaultBlockState()
                .setValue(UP, false)
                .setValue(DOWN, false)
                .setValue(AXIS, context.getClickedFace().getAxis());
    }

    public static boolean canConnect(BlockState thisState, BlockState neighborState) { //cant even use this somehow!!!!!
        if (neighborState.getBlock() instanceof ChainsBlock)
            return (neighborState.getValue(AXIS) == thisState.getValue(AXIS));
        return false;
    }
}