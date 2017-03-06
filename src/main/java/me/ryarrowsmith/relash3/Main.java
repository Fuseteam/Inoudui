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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public final class Main {

    public static void main(String[] args){

        JDA jda;

        try {

            jda = new JDABuilder(AccountType.BOT)
                    .setToken("Mjg3NTY2MTkwNDIxODY4NTQ0.C52LgQ.IURbXYYKZQb9uGBy0tiaX5N2pbQ")
                    .setAudioEnabled(false)
                    .addListener(new CommandHandler())
                    .setGame(Game.of("memes"))
                    .setStatus(OnlineStatus.ONLINE)
                    .buildBlocking();

        } catch (AccountTypeException|LoginException|InterruptedException|RateLimitedException exception){

            exception.printStackTrace();
            return;
        }

        String[] message = {"></>help", "dank memes", "beta is in still"};
        new Timer().scheduleAtFixedRate(new TimerTask() {

            int i = 0;
            @Override
            public void run() {

                if(i > message.length + 1) i = 0;
                jda.getPresence().setGame(Game.of(message[i]));
            }

        }, TimeUnit.MINUTES.toMillis(2), TimeUnit.MINUTES.toMillis(2));
    }
}