package rexfracht868454.teleportbow;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeManager {

    public void loadRecipes() {
        teleportBow();
    }

    private void teleportBow() {
        ItemStack teleportBow = new ItemStack(Material.BOW);
        ItemMeta teleportBowMeta = teleportBow.getItemMeta();
        teleportBowMeta.setDisplayName("§l§3TeleportBow");
        teleportBowMeta.setLocalizedName("teleportBow");
        teleportBow.setItemMeta(teleportBowMeta);
        teleportBow.addUnsafeEnchantment(Enchantment.LUCK, 1);

        ShapedRecipe teleportBowRecipe = new ShapedRecipe(teleportBow);
        teleportBowRecipe.shape("*S/", "S*/", "*S/");
        teleportBowRecipe.setIngredient('/', Material.STICK);
        teleportBowRecipe.setIngredient('S', Material.STRING);
        teleportBowRecipe.setIngredient('*', Material.ENDER_PEARL);
        Bukkit.getServer().addRecipe(teleportBowRecipe);
    }
}
