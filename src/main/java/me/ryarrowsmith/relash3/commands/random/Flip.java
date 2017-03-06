package me.ryarrowsmith.relash3.commands.random;

import me.ryarrowsmith.relash3.utils.BotUtils;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.util.Random;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public final class Flip extends BotUtils
{
	
	public void flip(Message trigger)
	{
		
		String r = "Tails";
		if (new Random().nextInt(2) == 1) r = "Heads";
		
		final String result = "Result: " + r + ".";
		
		try
		{
			
			trigger.getChannel().sendMessage(makeEmbed(result, null).build()).queue();
			
		}
		catch (PermissionException e)
		{
			
			trigger.getChannel().sendMessage(result).queue();
		}
	}
}