package io.bfnt.relash.commands;

import net.dv8tion.jda.core.entities.Message;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Help {

    public void help(Message message){

        message.getChannel().sendMessage("No commands yet").queue();
    }
}
