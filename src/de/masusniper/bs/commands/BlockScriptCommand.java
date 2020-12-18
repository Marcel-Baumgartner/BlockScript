package de.masusniper.bs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.masusniper.bs.editor.Editor;

public class BlockScriptCommand implements CommandExecutor
{

	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] args) {
		
		if(!(arg0 instanceof Player))
		{
			arg0.sendMessage("You had to execute this command as a player");
			return false;
		}
		
		if(args.length < 1)
		{
			arg0.sendMessage("Syntax /bs <editor>");
			return false;
		}
		
		switch(args[0])
		{
			case "editor":
				if(args.length > 1)
				{
					Editor.OpenFile((Player) arg0, args[1]);
				}
				break;
			case "new":
				if(args.length > 1)
				{
					Editor.CreateFile((Player) arg0, args[1]);
				}
				break;
			
			default:
				arg0.sendMessage("Unknown argument " + args[0]);
				break;
		}
		
		return true;
	}

}
