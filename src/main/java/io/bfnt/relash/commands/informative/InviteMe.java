package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 11/03/2017.
 */
public class InviteMe extends RelashCommand {

    public void invite(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String title = "❗ My invite link is: ";
        final String link = "https://bfnt.io/relash-invite";

        try {

            channel.sendMessage(makeEmbed(title, link).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage(title + link).queue();
        }
    }
}
