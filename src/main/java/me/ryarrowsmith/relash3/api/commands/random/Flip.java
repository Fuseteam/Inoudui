package me.ryarrowsmith.relash3.api.commands.random;

import me.ryarrowsmith.relash3.api.Utils;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.util.Random;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public final class Flip extends Utils {

    public void flip(Message trigger) {

        String r = "Tails";
        if(new Random().nextInt(2) == 1) r = "Heads";

        final String result = "Result: " + r + ".";

        try {

            trigger.getChannel().sendMessage(makeEmbed("Flipping a coin...", null).build()).queue((flip) -> flip.editMessage(makeEmbed( result, null).build()).queue());

        } catch (PermissionException e){

            trigger.getChannel().sendMessage("Flipping a coin...").queue((flip) -> flip.editMessage(result));
        }
    }
}