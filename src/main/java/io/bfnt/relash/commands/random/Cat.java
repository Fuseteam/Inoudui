package io.bfnt.relash.commands.random;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Cat extends RelashCommand {

    public void cat(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String image = getAnimal("cats");

        try {

            channel.sendMessage(makeEmbed("🐱", "").setImage(image).build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage(getAnimal(image)).queue();
        }
    }
}