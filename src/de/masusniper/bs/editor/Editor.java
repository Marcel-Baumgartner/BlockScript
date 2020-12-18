package de.masusniper.bs.editor;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Editor 
{
	public static void OpenFile(Player player, String filename)
	{
		try
		{
			player.sendMessage(ChatColor.AQUA + "Loading file " + Paths.get("blockscripts" , filename));
			
			List<String> lines = Files.readAllLines(Paths.get("blockscripts" , filename), Charset.defaultCharset());
			
			player.sendMessage(ChatColor.AQUA + "Loaded " + lines.size() + " lines.");
					
			ItemStack book = new ItemStack(Material.WRITABLE_BOOK, 1);
			
			BookMeta meta = (BookMeta) book.getItemMeta();
			
			meta.setDisplayName(filename);
			
			int i = 1;
			String page = "";
			for(String s : lines)
			{
				if(i < 15)
				{
					page += s + "\n";
				}
				else
				{
					meta.addPage(page);
					page = "";
					page += s + "\n";
					i = 0;
				}
				i++;
			}
			if(lines.size() < 15)
			{
				meta.addPage(page);
			}
			
			book.setItemMeta(meta);
			
			player.getInventory().addItem(book);
		}
		catch(Exception ex)
		{
			player.sendMessage(ChatColor.RED + "Error: " + ex.getMessage());
			return;
		}
	}
}