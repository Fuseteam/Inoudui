package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 09/03/2017.
 */
public class Ginfo extends RelashCommand {

    public void ginfo(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String error = "⚠ \\o/ this is not a guild \\o/ ⚠";
        if(!channel.getType().equals(ChannelType.TEXT)){

            try {

                channel.sendMessage(makeEmbed(error, "").build()).queue();

            } catch (PermissionException e){

                channel.sendMessage(error).queue();
            }

            return;
        }

        final TextChannel guildc = trigger.getTextChannel();
        final Guild guild = guildc.getGuild();
        final String title = "📝" + guild.getName().trim() + "📝";
        final String info = "";
        try {

            channel.sendMessage(makeEmbed(title, "").addField("", info, true).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage(title + "\n" + info).queue();
        }
    }
}
