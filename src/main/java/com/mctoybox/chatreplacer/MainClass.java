package com.mctoybox.chatreplacer;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin implements Listener {
	private char ColourCodeChar;
	private boolean debug;
	
	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new ChatListener(this), this);
		
		setColourCodeChar(getConfig().getString("config.colour-code-char", "^").charAt(0));
		debug = getConfig().getBoolean("config.debug", false);
	}
	
	public void debugLog(String message) {
		if (debug)
			getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[ChatReplacer] " + message);
	}
	
	public char getColourCodeChar() {
		return ColourCodeChar;
	}
	
	public void setColourCodeChar(char colourCodeChar) {
		ColourCodeChar = colourCodeChar;
	}
}
