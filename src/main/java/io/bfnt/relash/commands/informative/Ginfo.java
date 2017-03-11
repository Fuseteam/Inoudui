package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.time.temporal.ChronoUnit;

/**
 * Created by Ryan's PC on 09/03/2017.
 */
public class Ginfo extends RelashCommand {

    public void ginfo(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String error = "⚠ This is not a guild. ⚠";
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
        final String title = "📝 " + guild.getName().trim() + " 📝";
        String roles = "";
        for(Role role : guild.getRoles()){

            roles += role.getName() + ", ";
        }
        roles = roles.replace(", @everyone,", ".");
        final String info = String.format("🙇 Owner: %s\n🎧 Voice Channels: %d\n🖊 Text Channels: %d\n📓 Total Channels: %d\n👥 Members: %d\n👤Roles: (%d)\n%s\n🕛 Created: %s day(s) ago.", guild.getOwner().getUser().getName() + "#" + guild.getOwner().getUser().getDiscriminator(), guild.getVoiceChannels().size(), guild.getTextChannels().size(), guild.getVoiceChannels().size() + guild.getTextChannels().size(), guild.getMembers().size(), guild.getRoles().size(), roles, guild.getCreationTime().until(trigger.getCreationTime(), ChronoUnit.DAYS));
        try {

            channel.sendMessage(makeEmbed(title, "").addField("", info, true).setThumbnail(guild.getIconUrl()).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage(title + "\n" + info).queue();
        }
    }
}
