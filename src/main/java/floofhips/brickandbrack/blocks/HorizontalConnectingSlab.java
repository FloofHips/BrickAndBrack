package floofhips.brickandbrack.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class HorizontalConnectingSlab extends SlabBlock {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public HorizontalConnectingSlab(AbstractBlock.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, SlabType.BOTTOM).setValue(SHAPE, StairsShape.STRAIGHT).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
	        builder.add(FACING, TYPE, SHAPE, WATERLOGGED);
	    }
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	        Direction direction = context.getClickedFace();
	        BlockPos blockpos = context.getClickedPos();
	        BlockState existingBlockstate = context.getLevel().getBlockState(blockpos);
	        BlockState blockstate = this.defaultBlockState();
	        if (existingBlockstate.is(this)) {
	            blockstate = blockstate.setValue(FACING, context.getHorizontalDirection())
	            		.setValue(TYPE, SlabType.DOUBLE)
	            		.setValue(WATERLOGGED, Boolean.valueOf(false));
	            return blockstate.setValue(SHAPE, getShape(blockstate, context.getLevel(), blockpos));
	        } else {
		        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
		        blockstate = blockstate.setValue(FACING, context.getHorizontalDirection())
		        		.setValue(TYPE, direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double)blockpos.getY() > 0.5D)) ? SlabType.BOTTOM : SlabType.TOP)
		        		.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
		        return blockstate.setValue(SHAPE, getShape(blockstate, context.getLevel(), blockpos));
	        }
	    }
	
	//Returns the shape a block should take based on its neighbors.
	private static StairsShape getShape(BlockState state, IBlockReader world, BlockPos pos) {
	        Direction direction = state.getValue(FACING);

	        BlockState frontNeighborState = world.getBlockState(pos.relative(direction.getOpposite()));
	        if (canConnect(state, frontNeighborState)) {
	            Direction frontNeighborDirection = frontNeighborState.getValue(FACING);
	            if (frontNeighborDirection.getAxis() != direction.getAxis() && canTakeShape(state, world, pos, frontNeighborDirection))
	               return frontNeighborDirection == direction.getCounterClockWise() ? StairsShape.INNER_LEFT : StairsShape.INNER_RIGHT;
	        }
	        
	        BlockState backNeighborState = world.getBlockState(pos.relative(direction));
	        if (canConnect(state, backNeighborState)) {
	            Direction backNeighborDirection = backNeighborState.getValue(FACING);
	            if (backNeighborDirection.getAxis() != direction.getAxis() && canTakeShape(state, world, pos, backNeighborDirection.getOpposite()))
	               return backNeighborDirection == direction.getCounterClockWise() ? StairsShape.OUTER_LEFT : StairsShape.OUTER_RIGHT;
	        }

	        return StairsShape.STRAIGHT;
	    }
	
	//Returns false if the directional block is already connected to another block that makes it the "straight" shape.
	private static boolean canTakeShape(BlockState state, IBlockReader world, BlockPos pos, Direction direction) {
	        BlockState neighborState = world.getBlockState(pos.relative(direction));
	        return !canConnect(state, neighborState) || neighborState.getValue(FACING) != state.getValue(FACING);
	    }
	
	//Returns true if the neighboring blockstate should be able to affect the shape of "this" blockstate.
	public static boolean canConnect(BlockState thisState, BlockState neighborState) {
			if (neighborState.getBlock() instanceof HorizontalConnectingSlab)
				return (neighborState.getValue(TYPE) == SlabType.BOTTOM) == (thisState.getValue(TYPE) == SlabType.BOTTOM);
			if (neighborState.getBlock() instanceof HorizontalConnectingBlock)
				return thisState.getValue(TYPE) != SlabType.BOTTOM;
			//if (neighborState.getBlock() instanceof StairsBlock)
			//	return neighborState.getValue(BlockStateProperties.HALF) == Half.BOTTOM && thisState.getValue(TYPE) == SlabType.BOTTOM || neighborState.getValue(BlockStateProperties.HALF) == Half.TOP && thisState.getValue(TYPE) == SlabType.TOP;
	        return false;
	    }
	
	public BlockState updateShape(BlockState thisState, Direction directionToNeighbor, BlockState neighborState, IWorld world, BlockPos thisPos, BlockPos neighborPos) {
        if (thisState.getValue(WATERLOGGED))
            world.getLiquidTicks().scheduleTick(thisPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        return directionToNeighbor.getAxis().isHorizontal() ? thisState.setValue(SHAPE, getShape(thisState, world, thisPos)) : super.updateShape(thisState, directionToNeighbor, neighborState, world, thisPos, neighborPos);
    }

}
