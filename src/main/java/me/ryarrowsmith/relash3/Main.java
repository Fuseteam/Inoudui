package me.ryarrowsmith.relash3;

import me.ryarrowsmith.relash3.api.CommandHandler;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.AccountTypeException;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public final class Main {

    public static void main(String[] args){

        JDA jda;

        try {

            jda = new JDABuilder(AccountType.BOT)
                    .setToken("-")
                    .setAudioEnabled(false)
                    .addListener(new CommandHandler())
                    .setGame(Game.of("></> help"))
                    .setStatus(OnlineStatus.ONLINE)
                    .buildBlocking();

        } catch (AccountTypeException|LoginException|InterruptedException|RateLimitedException exception){

            exception.printStackTrace();
            return;
        }
    }
}