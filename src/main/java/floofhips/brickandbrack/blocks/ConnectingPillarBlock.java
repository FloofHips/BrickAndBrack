package floofhips.brickandbrack.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class ConnectingPillarBlock extends SixWayBlock/* implements IWaterLoggable */{
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public ConnectingPillarBlock(Properties properties) {
        super(0.2F, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, UP, DOWN, AXIS);
    }

    public BlockState rotate(BlockState context, Rotation rotation) {
        switch(rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch((Direction.Axis)context.getValue(AXIS)) {
                    case X:
                        return context.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return context.setValue(AXIS, Direction.Axis.X);
                    default:
                        return context;
                }
            default:
                return context;
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IBlockReader iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockPos blockpos5 = blockpos.above();
        BlockPos blockpos6 = blockpos.below();
        BlockState blockstate = iblockreader.getBlockState(blockpos1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
        BlockState blockstate4 = iblockreader.getBlockState(blockpos5);
        BlockState blockstate5 = iblockreader.getBlockState(blockpos6);
        return  super.getStateForPlacement(context)
                .setValue(NORTH, Boolean.valueOf(this.canConnect(blockstate, blockstate.isFaceSturdy(iblockreader, blockpos1, Direction.SOUTH), Direction.SOUTH)))
                .setValue(EAST, Boolean.valueOf(this.canConnect(blockstate1, blockstate1.isFaceSturdy(iblockreader, blockpos2, Direction.WEST), Direction.WEST)))
                .setValue(SOUTH, Boolean.valueOf(this.canConnect(blockstate2, blockstate2.isFaceSturdy(iblockreader, blockpos3, Direction.NORTH), Direction.NORTH)))
                .setValue(WEST, Boolean.valueOf(this.canConnect(blockstate3, blockstate3.isFaceSturdy(iblockreader, blockpos4, Direction.EAST), Direction.EAST)))
                .setValue(UP, Boolean.valueOf(this.canConnect(blockstate4, blockstate4.isFaceSturdy(iblockreader, blockpos3, Direction.UP), Direction.UP)))
                .setValue(DOWN, Boolean.valueOf(this.canConnect(blockstate5, blockstate5.isFaceSturdy(iblockreader, blockpos4, Direction.DOWN), Direction.DOWN)))
                .setValue(AXIS, context.getClickedFace().getAxis());

              //  .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
}
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return stateIn.setValue(PROPERTY_BY_DIRECTION.get(facing), this.canConnect(facingState, facingState.isFaceSturdy(worldIn, facingPos, facing.getOpposite()), facing.getOpposite()));
    }

    private boolean canConnect(BlockState facingState, boolean solidSide, Direction opposite) {
      //  return facingState.is(this);
        Block block = facingState.getBlock();
        boolean flag = block instanceof ConnectingPillarBlock;
        boolean flag1 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(facingState, opposite);
        return !isExceptionForConnection(block) && solidSide || flag || flag1;

    }
}