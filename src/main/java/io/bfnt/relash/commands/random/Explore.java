package io.bfnt.relash.commands.random;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 11/03/2017.
 */
public class Explore extends RelashCommand {

    public void explore(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String searching = "🔎 Searching...";
        final String found = "🔍 Found: ";
        final String link = "%s | https://discord.gg/%s";
        final Invite invite = makeInvite(trigger.getGuild());

        try {

            channel.sendMessage(makeEmbed(searching, "").build()).queue(search -> search.editMessage(makeEmbed(found, String.format(link, invite.getGuild().getName(), invite.getCode())).build()).queue());

        } catch (PermissionException e){

            channel.sendMessage(searching).queue(search -> search.editMessage(found + String.format(link, invite.getGuild(), invite.getCode())).queue());
        }
    }

    private Invite makeInvite(Guild guild){

        return guild.getPublicChannel().createInvite().complete();
    }
}
