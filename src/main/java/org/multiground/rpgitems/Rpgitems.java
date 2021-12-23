package org.multiground.rpgitems;

import org.bukkit.plugin.java.JavaPlugin;
import org.multiground.rpgitems.commands.SsCommand;

public final class Rpgitems extends JavaPlugin {

    Rpgitems plugin;
    @Override
    public void onEnable() {
        getLogger().info("Loading Plugins!");
        plugin = this;
        plugin.saveDefaultConfig();
        SsCommand.INSTANCE.register();
    }

    @Override
    public void onDisable() {

    }

    public Rpgitems getPlugin() {
        return plugin;
    }
}
