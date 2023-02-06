package rexfracht868454.teleportbow;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.projectiles.ProjectileSource;

import java.util.HashMap;
import java.util.UUID;

public class TeleportBowListener implements Listener {

    private HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();
    private Main plugin;

    public TeleportBowListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTeleportBow(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile.getType() == EntityType.ARROW) {
            ProjectileSource shooter = projectile.getShooter();

            if (shooter instanceof Player) {
                Player player = (Player) shooter;
                if (player.hasPermission("cmd.teleportBow.tp")) {
                    ItemStack itemStack = player.getInventory().getItemInMainHand();
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if (itemMeta.getLocalizedName().equals("teleportBow")) {
                        if (cooldown.containsKey(player.getUniqueId()) && cooldown.get(player.getUniqueId()) > System.currentTimeMillis()) {
                            event.setCancelled(true);
                            long remainingTime = cooldown.get(player.getUniqueId()) - System.currentTimeMillis();
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 2);
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "You can´t shoot for another " + ChatColor.YELLOW + remainingTime / 1000 + ChatColor.RED + " seconds"));
                        } else {
                            player.teleport(projectile.getLocation());
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + ""));
                            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (plugin.getConfig().getLong("cooldown") * 1000));
                        }
                    }
                }
            }
        }
    }
}
