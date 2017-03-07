package io.bfnt.relash.commands;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Help extends RelashCommand {

    public void help(Message trigger){

        final TextChannel channel = trigger.getTextChannel();
        final String commands = "\uD83D\uDC31 <~ cat - Returns a random cat.\n\uD83D\uDC36 <~ dog - Returns a random dog.";

        try {

            channel.sendMessage(makeEmbed("❗❗ Relash Help ❗❗","", "Commands: " + commands).build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage("❗❗ Relash Help ❗❗\n" + commands).queue();
        }
    }
}