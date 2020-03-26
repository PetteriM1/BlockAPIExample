package me.petterim1.blockapiexample;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.block.BlockRedstoneLamp;
import cn.nukkit.level.Level;

public class CustomLamp extends BlockRedstoneLamp { // it's recommended that custom blocks extends the original blocks

    @Override
    public int onUpdate(int type) {
        // in Nukkit there is
        /*if (type == Level.BLOCK_UPDATE_NORMAL || type == Level.BLOCK_UPDATE_REDSTONE) {
            RedstoneUpdateEvent ev = new RedstoneUpdateEvent(this);
            getLevel().getServer().getPluginManager().callEvent(ev);
            if (ev.isCancelled()) {
                return 0;
            }
            if (this.level.isBlockPowered(this.getLocation())) {
                this.level.setBlock(this, Block.get(BlockID.LIT_REDSTONE_LAMP), false, false);
                return 1;
            }
        }*/

        // but we want the lamps to switch on/off ONLY when player touches them
        if (type == Level.BLOCK_UPDATE_TOUCH) {
            this.level.setBlock(this, Block.get(BlockID.LIT_REDSTONE_LAMP), false, false);
            return Level.BLOCK_UPDATE_TOUCH;
        }

        // notice that some blocks including lamps are different blocks when they are on and off
        // in this case we will also need to make a custom "lit lamp" block
        return 0;
    }
}
