package io.bfnt.relash.commands.random;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.security.SecureRandom;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Flip extends RelashCommand {

    public void flip(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        String result;

        if(new SecureRandom().nextInt(2) + 1 == 1){

            result = "\uD83D\uDD18 Result: Heads.";

        } else {

            result = "\uD83D\uDD18 Result: Tails.";
        }

        try {

            channel.sendMessage(makeEmbed(result, "").build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage(makeEmbed(result, "").build()).queue();
        }
    }
}