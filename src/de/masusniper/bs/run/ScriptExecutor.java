package de.masusniper.bs.run;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScriptExecutor 
{
	ArrayList<String> commands = new ArrayList<String>();
	
	public static void RunFile(String filename)
	{
		try
		{
			List<String> lines = Files.readAllLines(Paths.get("blockscripts" , filename), Charset.defaultCharset());
			
			String all = "";
			
			for(String s : lines)
			{
				all += s;
			}
			
			String[] commands = all.split(";");
			
			ScriptExecutor exec = new ScriptExecutor(commands);
			exec.Run();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error at running file " + filename);
		}
	}
	
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
