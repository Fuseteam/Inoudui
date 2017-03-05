package me.ryarrowsmith.relash3.api.commands.random.animal;

import me.ryarrowsmith.relash3.api.Utils;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public final class Cat extends Utils {

    public void cat(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String image = getImage("cats");

        try {

            channel.sendMessage(makeEmbed("\uD83D\uDC31", null).setImage(image).build()).queue();

        } catch (PermissionException e){

            channel.sendMessage("\uD83D\uDC31 " + image).queue();

        }
    }
}