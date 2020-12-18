package de.masusniper.bs.main;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import de.masusniper.bs.commands.BlockScriptCommand;
import de.masusniper.bs.editor.BookSignedEvent;

public class BlockScript extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		System.out.println("Enabling BlockScript");
		
		//Commands
		
		this.getCommand("bs").setExecutor(new BlockScriptCommand());
		
		//Events
		getServer().getPluginManager().registerEvents(new BookSignedEvent(), this);
		
		//Files and Directories
		File scriptsFolder = new File("blockscripts");
		if(!scriptsFolder.exists())
		{
			scriptsFolder.mkdir();
		}
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("Disabling BlockScript");
	}
}
