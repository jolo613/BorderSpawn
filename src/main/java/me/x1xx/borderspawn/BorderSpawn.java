package me.x1xx.borderspawn;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BorderSpawn extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(this, this);


       getServer().getScheduler().runTaskTimer(this, () -> getServer().getOnlinePlayers().forEach(this::checkInsideBorder), 0, 3);
    }

    private void checkInsideBorder(Player player) {
        // checks if player is inside border
        if (!player.getWorld().getWorldBorder().isInside(player.getLocation())) {
            // player is inside border
            // teleport to spawn
            getServer().dispatchCommand(getServer().getConsoleSender(), "spawn " + player.getName());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
