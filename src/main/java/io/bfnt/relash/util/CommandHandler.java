package io.bfnt.relash.util;

import io.bfnt.relash.commands.Help;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class CommandHandler extends ListenerAdapter {

    private final String[] prefixes = {"", ""};

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Boolean ignore = true;
        String content = event.getMessage().getRawContent();
        String trigger = "";

        for(String prefix : prefixes){

            if(content.startsWith(prefix)){

                trigger = prefix;
                ignore = false;
                break;
            }
        }
        if(ignore) return;
        Message message = event.getMessage();
        message.addReaction("⚙").queue();

        switch(content.replaceFirst(trigger, "").trim()){

            case "help": new Help().giveHelp(message); return;
        }
    }
}