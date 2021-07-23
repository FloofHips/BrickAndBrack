package floofhips.brickandbrack.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Direction.AxisDirection;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class ChainsBlock extends RotatedPillarBlock implements IWaterLoggable {
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    
    protected static final VoxelShape X_AABB = Block.box(0.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
    protected static final VoxelShape Y_AABB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    protected static final VoxelShape Z_AABB = Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 16.0D);

    public ChainsBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
       Axis axis = state.getValue(AXIS);
       switch(axis) {
       case X:
          return X_AABB;
       case Y:
          return Y_AABB;
       case Z:
          return Z_AABB;
       default:
    	  return Y_AABB;
       }
    }
    
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AXIS, UP, DOWN, WATERLOGGED);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    	Axis axis = context.getClickedFace().getAxis();
        BlockPos blockPos = context.getClickedPos();
        World world = context.getLevel();

        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState state =  this.defaultBlockState().setValue(AXIS, axis).setValue(WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
        return state.setValue(UP, canConnect(state, blockPos, AxisDirection.POSITIVE, world))
        		.setValue(DOWN, canConnect(state, blockPos, AxisDirection.NEGATIVE, world));
    }
    
    @Override
    public BlockState updateShape(BlockState thisState, Direction directionToNeighbor, BlockState neighborState, IWorld world, BlockPos thisPos, BlockPos neighborPos) {
    	if (thisState.getValue(WATERLOGGED))
            world.getLiquidTicks().scheduleTick(thisPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
    	BooleanProperty property = directionToNeighbor.getAxisDirection() == AxisDirection.POSITIVE ? UP : DOWN;
    	return thisState.setValue(property, canConnect(thisState, thisPos, directionToNeighbor, world));
    }
    
    public static boolean canConnect(BlockState thisState, BlockPos thisPos, AxisDirection neighborAxisDirection, IWorld world) {
    	Axis thisAxis = thisState.getValue(AXIS);
    	BlockPos neighborPos = thisPos.relative(thisAxis, neighborAxisDirection.getStep());
    	BlockState neighborState = world.getBlockState(neighborPos);
    	
        if (neighborState.getBlock() instanceof ChainsBlock)
            return (neighborState.getValue(AXIS) == thisAxis);
        return neighborState.isFaceSturdy(world, neighborPos, Direction.get(neighborAxisDirection.opposite(), thisAxis));
    }
    
    public static boolean canConnect(BlockState thisState, BlockPos thisPos, Direction neighborDirection, IWorld world) {
    	return thisState.getValue(AXIS) == neighborDirection.getAxis() && canConnect(thisState, thisPos, neighborDirection.getAxisDirection(), world);
    }
}