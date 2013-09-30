package com.mctoybox.chatreplacer;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class ChatListener implements Listener {
	private MainClass mainClass;
	
	public ChatListener(Plugin plugin) {
		this.mainClass = (MainClass) plugin;
	}
	
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		if (event.getPlayer().hasPermission("chatreplacer.override"))
			return;
		String message = event.getMessage(), foundMessage;
		if (mainClass.getConfig().getString("messages." + message, "") == "") {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes(mainClass.getColourCodeChar(), mainClass.getConfig().getString("config.disallowed-message")));
		}
		else {
			foundMessage = mainClass.getConfig().getString("messages." + message);
			mainClass.debugLog(message + ", " + foundMessage);
			event.setMessage(ChatColor.translateAlternateColorCodes(mainClass.getColourCodeChar(), foundMessage));
		}
	}
}
