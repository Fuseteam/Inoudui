package me.ryarrowsmith.relash3.commands.random.animal;

import me.ryarrowsmith.relash3.utils.BotUtils;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public final class Dog extends BotUtils
{
	
	public void dog(Message trigger)
	{
		
		final MessageChannel channel = trigger.getChannel();
		final String image = getImage("shibes");
		
		try
		{
			
			channel.sendMessage(makeEmbed("\uD83D\uDC36", null).setImage(image).build()).queue();
			
		}
		catch (PermissionException e)
		{
			
			channel.sendMessage("\uD83D\uDC36 " + image).queue();
			
		}
	}
}