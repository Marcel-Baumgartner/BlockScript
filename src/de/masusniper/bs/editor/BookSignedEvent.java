package de.masusniper.bs.editor;

import java.io.FileWriter;
import java.nio.file.Paths;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import net.md_5.bungee.api.ChatColor;

public class BookSignedEvent implements Listener
{
	@EventHandler
    public void onBookSign(PlayerEditBookEvent event) 
	{  
        if(event.isSigning())
        {
        	try
        	{
        		FileWriter fw = new FileWriter((Paths.get("blockscripts", event.getNewBookMeta().getDisplayName()).toString()));
        		event.getPlayer().sendMessage(ChatColor.AQUA + "Saving to " + (Paths.get("blockscripts", event.getNewBookMeta().getDisplayName()).toString()));
            	
        		int count = 0;
        		
            	for(int i = 1; i == event.getNewBookMeta().getPageCount(); i++)
            	{
            		fw.write(event.getNewBookMeta().getPage(i));
            		count++;
            	}
            	
            	event.getPlayer().sendMessage(ChatColor.AQUA + "" + count + " lines has been written.");
            	
            	fw.close();
            	event.getPlayer().sendMessage(ChatColor.GREEN + "File sucessfully saved");
            	event.getPlayer().getInventory().remove(event.getPlayer().getInventory().getItemInMainHand());
        	}
        	catch(Exception ex)
        	{
        		event.getPlayer().sendMessage(ChatColor.RED + "Error saving file: " + ex.getMessage());
        	}
        }
    }
}
