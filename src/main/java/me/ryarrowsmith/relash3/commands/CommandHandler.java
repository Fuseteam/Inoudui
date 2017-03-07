package me.ryarrowsmith.relash3.commands;

import me.ryarrowsmith.relash3.commands.general.Help;
import me.ryarrowsmith.relash3.commands.random.Flip;
import me.ryarrowsmith.relash3.commands.random.animal.Bird;
import me.ryarrowsmith.relash3.commands.random.animal.Cat;
import me.ryarrowsmith.relash3.commands.random.animal.Dog;
import me.ryarrowsmith.relash3.commands.stats.Ginfo;
import me.ryarrowsmith.relash3.commands.stats.Info;
import me.ryarrowsmith.relash3.commands.stats.Ping;
import me.ryarrowsmith.relash3.commands.stats.Uinfo;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.time.OffsetDateTime;

public final class CommandHandler extends ListenerAdapter
{
	
	private final String[] prefixes = {"<@287566190421868544>", "></>", "r!"};
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		
		Boolean ignore = true;
		String used = "";
		for (String prefix : prefixes)
		{
			
			if (event.getMessage().getRawContent().startsWith(prefix))
			{
				
				ignore = false;
				used = prefix;
				break;
			}
		}
		if (ignore) return;
		String content = event.getMessage().getRawContent().replaceFirst(used, "");
		Message message = event.getMessage();
		try
		{
			message.addReaction("⚙").queue();
		}
		catch (PermissionException e)
		{
			e.printStackTrace();
		}
		final OffsetDateTime time = event.getMessage().getCreationTime();
		System.out.println("[" + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + "] [" + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator() + "] " + event.getMessage().getRawContent());
		String[] args = content.trim().toLowerCase().split(" ");
		switch (args[0])
		{
			
			case "bird":
				
				new Bird().bird(message);
				break;
			
			case "cate":
			case "cat":
				
				new Cat().cat(message);
				break;
			
			case "doge":
			case "dog":
				
				new Dog().dog(message);
				break;
			
			case "coin":
			case "coinflip":
			case "flip":
				
				new Flip().flip(message);
				return;
			
			case "ginfo":
				
				new Ginfo().gInfo(message);
				break;
			
			case "info":
				
				new Info().info(message);
				break;
			
			case "pong":
			case "pung":
			case "pang":
			case "peng":
			case "ping":
				
				new Ping().ping(message);
				break;

			case "uinfo":

				new Uinfo().uinfo(message);

			default:
				
				new Help().help(message);
				break;
		}
	}
}