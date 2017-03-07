package io.bfnt.relash.commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Help {

    public void giveHelp(Message message){

        message.getChannel().sendMessage("Relash is borked atm, recoding ftw").queue();
    }
}
