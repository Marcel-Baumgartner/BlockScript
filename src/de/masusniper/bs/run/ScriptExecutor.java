package de.masusniper.bs.run;

import java.util.ArrayList;

public class ScriptExecutor 
{
	ArrayList<String> commands = new ArrayList<String>();
	
	public ScriptExecutor(String command)
	{
		commands.add(command);
	}
	public ScriptExecutor(String[] commands)
	{
		for(String s : commands)
		{
			this.commands.add(s);
		}
	}
	
	public void Run()
	{
		for(String s : commands)
		{
			RunCommand(s);
		}
	}
	
	private void RunCommand(String command)
	{
		String[] parts = command.split(" ");
		
		switch(parts[0])
		{
			case "wall":
				BasicActions.Wall(parts[1]);
				break;
		}
	}
}
