package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 09/03/2017.
 */
public class Ginfo extends RelashCommand {

    public void ginfo(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String error = "\\o/ this is not a guild \\o/";
        final String info = "";

        if(!channel.getType().equals(ChannelType.TEXT)){

            try {

                channel.sendMessage(makeEmbed(error, "").build()).queue();

            } catch (PermissionException e){

                channel.sendMessage(error).queue();
            }

            return;
        }

        final TextChannel guildChannel = trigger.getTextChannel();
        try {

            channel.sendMessage(makeEmbed(guildChannel.getName(), info).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage(info).queue();
        }
    }
}
