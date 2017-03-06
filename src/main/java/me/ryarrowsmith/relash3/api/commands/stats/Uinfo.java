package me.ryarrowsmith.relash3.api.commands.stats;

import me.ryarrowsmith.relash3.api.Utils;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public class Uinfo extends Utils {

    public void uinfo(Message trigger){

        final TextChannel channel = trigger.getTextChannel();
        final User user = trigger.getAuthor();
        final String title = "Information about: " + user.getName() + "#" + user.getDiscriminator();

        try {

            channel.sendMessage(makeEmbed("Information about: " + user.getName() + "#" + trigger.getAuthor().getDiscriminator(), null, "Game: " + user.getJDA().getPresence().getGame()).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage("Information about: " + user.getName() + "#" + user.getDiscriminator() + "\nGame: " + user.getJDA().getPresence().getGame()).queue();
        }
    }
}
