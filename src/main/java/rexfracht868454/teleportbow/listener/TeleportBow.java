package rexfracht868454.teleportbow.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.projectiles.ProjectileSource;

public class TeleportBow implements Listener {

    @EventHandler
    public void onTeleportBow(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile.getType() == EntityType.ARROW) {
            ProjectileSource shooter = projectile.getShooter();

            if (shooter instanceof Player) {
                Player player = (Player) shooter;
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                ItemMeta itemMeta = itemStack.getItemMeta();

                if (itemMeta.getLocalizedName().equals("teleportBow")) {
                    player.teleport(projectile.getLocation());
                }
            }
        }
    }
}
