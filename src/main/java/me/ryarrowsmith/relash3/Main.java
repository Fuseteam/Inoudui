package me.ryarrowsmith.relash3;

import me.ryarrowsmith.relash3.commands.CommandHandler;
import me.ryarrowsmith.relash3.utils.BotSettings;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.AccountTypeException;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public final class Main
{
	
	public static void main(String[] args)
	{
		
		JDA jda;
		
		try
		{
			
			jda = new JDABuilder(AccountType.BOT)
					  .setToken(BotSettings.botToken)
					  .setAudioEnabled(BotSettings.botAudioEnabled)
					  .addListener(new CommandHandler())
					  .setGame(Game.of(BotSettings.botGame))
					  .setStatus(OnlineStatus.ONLINE)
					  .buildBlocking();
			
		}
		catch (AccountTypeException | LoginException | InterruptedException | RateLimitedException exception)
		{
			
			exception.printStackTrace();
			return;
		}
		
		String[] message = {"></>help", "dank memes", "beta is in still"};
		new Timer().scheduleAtFixedRate(new TimerTask()
		{
			
			int i = 0;
			
			@Override
			public void run()
			{
				
				if (i > message.length + 1) i = 0;
				jda.getPresence().setGame(Game.of(message[i]));
			}
			
		}, TimeUnit.MINUTES.toMillis(2), TimeUnit.MINUTES.toMillis(2));
	}
}