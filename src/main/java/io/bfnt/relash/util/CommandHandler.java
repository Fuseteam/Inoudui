package io.bfnt.relash.util;

import io.bfnt.relash.commands.Help;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class CommandHandler extends ListenerAdapter {

    private final String[] prefixes = {"", ""};

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Boolean valid = true;
        String content = event.getMessage().getRawContent();
        String trigger = "";

        for(String prefix : prefixes){

            if(content.startsWith(prefix)){

                System.out.println(prefix);
                trigger = prefix;
                valid = false;
                break;
            }
        }
        if(!valid) return;
        Message message = event.getMessage();
        message.addReaction("⚙").queue();

        switch(content.replaceFirst(trigger, "").trim()){

            case "help": new Help().help(message); return;
        }
    }
}