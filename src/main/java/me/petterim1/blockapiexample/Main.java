package me.petterim1.blockapiexample;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.plugin.PluginBase;

import java.util.HashMap;
import java.util.Map;

public class Main extends PluginBase {

    public void onEnable() {
        // you can only have one blocks per id
        // if the user has other plugins which can register custom blocks it may have good idea to have some kind of check or warning about them being overwritten
        if (me.petterim1.blockapi.API.getAllCustomBlocks().size() != 0) {
            // we could also only warn about the blocks we are going to register if getAllCustomBlocks().containsKey() their id
            getLogger().warning("There is already custom blocks registered");
            // it is also possible to clear all already registered custom blocks using
            // me.petterim1.blockapi.API.unregisterAll();
            // but please respect other plugins and don't do that if not really needed :)
        }

        // register custom blocks using registerBlocks method if you have multiple custom blocks
        // use registerBlock only when registering a single custom block to avoid unnecessary updates
        Map<Integer, Class<? extends Block>> myBlocks = new HashMap<>();
        myBlocks.put(BlockID.DIRT, CustomDirt.class);
        myBlocks.put(BlockID.REDSTONE_LAMP, CustomLamp.class);
        myBlocks.put(BlockID.LIT_REDSTONE_LAMP, CustomLampLit.class);
        me.petterim1.blockapi.API.registerBlocks(myBlocks);

        // this does nothing important
        // don't bother copying it to your plugin
        getLogger().info("There is currently " + me.petterim1.blockapi.API.getAllCustomBlocks().size() + " custom blocks registered");
    }
}
