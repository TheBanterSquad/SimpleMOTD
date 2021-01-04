package me.sedders123.SimpleMOTD;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public final class App extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        config.addDefault("motd", "");
        config.options().copyDefaults(true);
        saveConfig();

       // Enable our class to check for new players using onPlayerJoin()
       getServer().getPluginManager().registerEvents(this, this);

       getCommand("smotd").setExecutor(this);
       getCommand("smreload").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Handle /smotd reload
        if (args.length > 0){
            if(args[0] != "reload"){
                return false;
            }
        }

        if(!(sender instanceof Player) || ((Player)sender).hasPermission("simplemotd.reload")){
            // Not player so must be console
            reloadConfig();
            config = getConfig();
            Bukkit.getLogger().info("[SimpleMOTD] Config reloaded");
            if (sender instanceof Player) {
                sender.sendMessage(ChatColor.GREEN + "[SimpleMOTD] Config reloaded!");
            }
            return true;
        }
        return false;
    }

    // This method checks for incoming players and sends them a message
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String motd = config.getString("motd");
        if (motd != null && !motd.trim().isEmpty()) {
            motd = ChatColor.translateAlternateColorCodes('&', motd);
            player.sendMessage(motd.split("\\\\n"));
        }
    }
}