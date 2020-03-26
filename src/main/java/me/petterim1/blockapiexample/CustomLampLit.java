package me.petterim1.blockapiexample;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.block.BlockRedstoneLampLit;
import cn.nukkit.level.Level;

public class CustomLampLit extends BlockRedstoneLampLit { // it's recommended that custom blocks extends the original blocks

    @Override
    public int onUpdate(int type) {
        // you can read the stuff from CustomLamp if you haven't already
        // here we do just the opposite thing to turn it off
        if (type == Level.BLOCK_UPDATE_TOUCH) {
            this.level.setBlock(this, Block.get(BlockID.REDSTONE_LAMP), false, false);
            return Level.BLOCK_UPDATE_TOUCH;
        }

        // simple, right?
        return 0;
    }
}
