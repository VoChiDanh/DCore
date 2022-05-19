package net.danh.dcore;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import net.danh.dcore.Utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @version 1.0
 */
public class DCore {

    /**
     * @return API Version
     */
    public static String getDCoreVersion() {
        return "v1.2-SNAPSHOT";
    }

    /**
     * @param message Message send to console with [DCore]
     */
    public static void dCoreLog(String... message) {
        for (String messages : message) {
            Bukkit.getLogger().info("[DCore] " + Chat.colorize(messages));
        }
    }

    /**
     * @param core Main of your plugins
     */
    public static void RegisterDCore(JavaPlugin core) {
        if (core.getServer().getPluginManager().getPlugin("ProtocolLib") == null) {
            dCoreLog("&cYou need ProtocolLib to use plugin " + core.getDescription().getName());
            core.getServer().getPluginManager().disablePlugin(core);
            return;
        }
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        RemoveDP(protocolManager, core);
        dCoreLog("&3" + core.getDescription().getName() + " is using DCore " + getDCoreVersion());
    }

    private static void RemoveDP(ProtocolManager protocolManager, JavaPlugin core) {
        protocolManager.addPacketListener(new PacketAdapter(core, ListenerPriority.NORMAL, PacketType.Play.Server.WORLD_PARTICLES) {
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                if (event.getPacketType() != PacketType.Play.Server.WORLD_PARTICLES)
                    return;

                if (packet.getNewParticles().read(0).getParticle() == Particle.DAMAGE_INDICATOR)
                    event.setCancelled(true);
            }
        });
    }

}
