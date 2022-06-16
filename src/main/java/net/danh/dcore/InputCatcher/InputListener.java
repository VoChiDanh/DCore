package net.danh.dcore.InputCatcher;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static net.danh.dcore.InputCatcher.Main.*;
import static net.danh.dcore.InputCatcher.Utils.*;
import static net.danh.dcore.Utils.Chat.lowerStrings;
import static net.danh.dcore.Utils.Chat.papi;
import static net.danh.dcore.Utils.Player.sendPlayerMessage;
import static net.danh.dcore.DCore.getInstance;

public class InputListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String m = ChatColor.stripColor(event.getMessage());
        if (input_all.containsKey(p)) {
            event.setCancelled(true);
            InputType_All type_all = input_all.get(p);
            if (lowerStrings(type_all.getCancelList()).contains(m.toLowerCase())) {
                input_all.remove(p);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        sendPlayerMessage(p, papi(p, type_all.getCancel()));
                    }
                }.runTask(getInstance());
            }
            else {
                if (type_all.getMethod() == InputEnums.InputMethod.ONE || type_all.getMethod() == InputEnums.InputMethod.AGAIN) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            callInputEvent(p, m);
                        }
                    }.runTask(getInstance());
                }
            }
        } else if (input_number.containsKey(p)) {
            event.setCancelled(true);
            InputType_Number type_number = input_number.get(p);
            if (lowerStrings(type_number.getCancelList()).contains(m.toLowerCase())) {
                input_number.remove(p);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        sendPlayerMessage(p, papi(p, type_number.getCancel()));
                    }
                }.runTask(getInstance());
            }
            else {
                if (isNumber(m)) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            doLast(p, m, type_number);
                        }
                    }.runTask(getInstance());
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            sendPlayerMessage(p, papi(p, type_number.getNot_a_number()));
                        }
                    }.runTask(getInstance());
                    if (type_number.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
            }
        } else if (input_text.containsKey(p)) {
            event.setCancelled(true);
            InputType_Text type_text = input_text.get(p);
            if (lowerStrings(type_text.getCancelList()).contains(m.toLowerCase())) {
                input_text.remove(p);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        sendPlayerMessage(p, papi(p, type_text.getCancel()));
                    }
                }.runTask(getInstance());
            } else {
                if (isText(m)) {

                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            sendPlayerMessage(p, papi(p, type_text.getNot_a_text()));
                        }
                    }.runTask(getInstance());
                    if (type_text.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
            }
        } else {
            event.setCancelled(false);
        }
    }

    private static void doLast(Player p, String m, InputType_Number n) {
        switch (n.getNumberFormat()) {
            case BYTE:
                if (isByte(m)) {
                    switch (n.getNumberType()) {
                        case POSITIVE:
                            if (Byte.parseByte(m) >= 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case NEGATIVE:
                            if (Byte.parseByte(m) < 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case ALL:
                            callInputEvent(p, m);
                    }
                }
                else {
                    sendPlayerMessage(p, papi(p, n.getInvalid_format_number()));
                    if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
            case SHORT:
                if (isShort(m)) {
                    switch (n.getNumberType()) {
                        case POSITIVE:
                            if (Short.parseShort(m) >= 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case NEGATIVE:
                            if (Short.parseShort(m) < 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case ALL:
                            callInputEvent(p, m);
                    }
                }
                else {
                    sendPlayerMessage(p, papi(p, n.getInvalid_format_number()));
                    if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
            case INTEGER:
                if (isInteger(m)) {
                    switch (n.getNumberType()) {
                        case POSITIVE:
                            if (Integer.parseInt(m) >= 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case NEGATIVE:
                            if (Integer.parseInt(m) < 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case ALL:
                            callInputEvent(p, m);
                    }
                }
                else {
                    sendPlayerMessage(p, papi(p, n.getInvalid_format_number()));
                    if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
            case LONG:
                if (isLong(m)) {
                    switch (n.getNumberType()) {
                        case POSITIVE:
                            if (Long.parseLong(m) >= 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case NEGATIVE:
                            if (Long.parseLong(m) < 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case ALL:
                            callInputEvent(p, m);
                    }
                }
                else {
                    sendPlayerMessage(p, papi(p, n.getInvalid_format_number()));
                    if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
            case FLOAT:
                if (isFloat(m)) {
                    switch (n.getNumberType()) {
                        case POSITIVE:
                            if (Float.parseFloat(m) >= 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case NEGATIVE:
                            if (Float.parseFloat(m) < 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case ALL:
                            callInputEvent(p, m);
                    }
                }
                else {
                    sendPlayerMessage(p, papi(p, n.getInvalid_format_number()));
                    if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
            case DOUBLE:
                if (isDouble(m)) {
                    switch (n.getNumberType()) {
                        case POSITIVE:
                            if (Double.parseDouble(m) >= 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case NEGATIVE:
                            if (Double.parseDouble(m) < 0) callInputEvent(p, m);
                            else {
                                sendPlayerMessage(p, papi(p, n.getInvalid_number()));
                                if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                            }
                        case ALL:
                            callInputEvent(p, m);
                    }
                }
                else {
                    sendPlayerMessage(p, papi(p, n.getInvalid_format_number()));
                    if (n.getMethod() == InputEnums.InputMethod.ONE) input_number.remove(p);
                }
        }
    }
}
