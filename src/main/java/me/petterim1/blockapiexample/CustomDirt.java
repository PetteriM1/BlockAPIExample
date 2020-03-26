package me.petterim1.blockapiexample;

import cn.nukkit.Player;
import cn.nukkit.block.BlockDirt;
import cn.nukkit.item.Item;

public class CustomDirt extends BlockDirt { // it's recommended that custom blocks extends the original blocks

    @Override
    public String getName() {
        // our dirt block is now called stone because why not
        // you can test this for example by giving a dirt block using /give command and it should show this as the name
        return "Stone";
    }

    @Override
    public boolean onActivate(Item item, Player player) {
        // if we for some reason want that using a hoe to a normal dirt block makes it to be a diamond block instead of a farmland block we can copy the original method from Nukkit and do some changes to it
        if (item.isHoe()) {
            item.useOn(this);
            this.getLevel().setBlock(this, this.getDamage() == 0 ? get(DIAMOND_BLOCK) : get(DIRT), true); // see this line
            // yep, that's not a farmland block
            // btw this.getDamage() != 0 means we have a coarse dirt block here
            return true;
        }
        return false;
    }

    @Override
    public int getDropExp() {
        return 1; // imagine getting xp from dirt
    }
}
