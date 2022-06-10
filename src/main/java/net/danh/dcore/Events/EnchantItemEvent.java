package net.danh.dcore.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EnchantItemEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final String enchant;
    private final Integer level;

    public EnchantItemEvent(Player player, String enchant, Integer level) {
        this.player = player;
        this.enchant = enchant;
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public String getEnchant() {
        return enchant;
    }

    public Player getPlayer() {
        return player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
