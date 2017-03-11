package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 11/03/2017.
 */
public class Website extends RelashCommand {

    public void website(Message trigger){

        final String title = "🖥 My website is: ";
        final String website =  "<https://ryarrowsmith.github.io/>";
        final MessageChannel channel = trigger.getChannel();

        try {

            channel.sendMessage(makeEmbed(title, website).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage(title + website).queue();
        }
    }
}
