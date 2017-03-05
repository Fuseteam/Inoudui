package me.ryarrowsmith.relash3.api.commands.stats;

import me.ryarrowsmith.relash3.api.Utils;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.time.temporal.ChronoUnit;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public final class Ping extends Utils {

    public void ping(Message trigger){

        final MessageChannel channel = trigger.getChannel();

        try {

            channel.sendMessage(makeEmbed("⏱ Pinging...", null).build()).queue((pinging) -> pinging.editMessage(makeEmbed("⏱ Ping: " + trigger.getCreationTime().until(pinging.getCreationTime(), ChronoUnit.MILLIS) + "ms", null).build()).queue());

        } catch (PermissionException e){

            channel.sendMessage("**⏱ Pinging...**").queue((pinging) -> pinging.editMessage("⏱ **Ping: " + trigger.getCreationTime().until(pinging.getCreationTime(), ChronoUnit.MILLIS) + "ms**").queue());
        }

    }
}