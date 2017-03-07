package io.bfnt.relash.commands.random;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Cat extends RelashCommand {

    public void cat(Message trigger){

        final TextChannel channel = trigger.getTextChannel();
        final String image = getAnimal("cats");

        try {

            channel.sendMessage(makeEmbed("\uD83D\uDC31", "").setImage(image).build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage(getAnimal(image)).queue();
        }
    }
}