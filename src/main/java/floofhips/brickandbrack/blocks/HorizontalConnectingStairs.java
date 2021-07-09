package floofhips.brickandbrack.blocks;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class HorizontalConnectingStairs extends StairsBlock {

	public HorizontalConnectingStairs(Supplier<BlockState> state, Properties properties) {
		super(state, properties);
	}
	
}
