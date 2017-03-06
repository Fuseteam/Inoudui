package me.ryarrowsmith.relash3.utils;

import java.util.HashSet;
import java.util.Set;

public class BotSettings
{
	public static final Set<String> GLOBAL_ADMINS = new HashSet<>();
	public static final Set<String> GLOBAL_DONORS = new HashSet<>();
	
	// Bot Token
	public static String botToken = "Mjg3NTY2MTkwNDIxODY4NTQ0.C52LgQ.IURbXYYKZQb9uGBy0tiaX5N2pbQ";
	
	// Bot Settings
	public static Boolean botAudioEnabled = false;
	public static String botGame = "></>help";
	
	// Bot Utilities
	public static long botStartTime = System.currentTimeMillis();
	public static String botVersion = "1.0.0-BETA";
	
	// Hashmap Settings
	static
	{
		// Admins
		GLOBAL_ADMINS.add("287537617287905281"); // RYArrowsmith#8070
		GLOBAL_ADMINS.add("174596615275806720"); // Reece#7982
		
		// Donors
	}
	
	private BotSettings()
	{
	}
}
