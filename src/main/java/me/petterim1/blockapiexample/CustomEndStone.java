package me.petterim1.blockapiexample;

import cn.nukkit.block.BlockEndStone;

import cn.nukkit.level.Level;
import cn.nukkit.level.particle.PortalParticle;

public class CustomEndStone extends BlockEndStone {

    // remember to use
    // me.petterim1.blockapi.API.setRandomTickingEnabled(blockId, true)
    // if you want to have random block updates for blocks that doesn't normally have this function
    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_RANDOM) {
            level.addParticle(new PortalParticle(this.add(0, 2, 0)));
            return Level.BLOCK_UPDATE_RANDOM;
        }
        return 0;
    }
}
