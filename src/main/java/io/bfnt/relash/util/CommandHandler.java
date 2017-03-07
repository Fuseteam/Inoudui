package io.bfnt.relash.util;

import io.bfnt.relash.commands.Help;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class CommandHandler extends ListenerAdapter {

    private final String[] prefixes = {"r!"};

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Boolean valid = false;
        String content = event.getMessage().getRawContent();
        String triggerPrefix = "";

        for(String prefix : prefixes){

            if(content.startsWith(prefix)){

                triggerPrefix = prefix;
                valid = true;
                break;
            }
        }
        if(!valid) return;
        Message message = event.getMessage();
        message.addReaction("⚙").queue();

        System.out.println(content);
        switch(content.replaceFirst(triggerPrefix, "").trim()){

            case "meow": break;
            case "help": new Help().help(message); break;
        }
    }
}