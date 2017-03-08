package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class Help extends RelashCommand {

    public void help(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final String commands = "`Informative:`\n❗ <~ help - Sends you help.\n⏱ <~ ping - Pings Relash's connection.\n`Random:`\n\uD83D\uDC26\n <~ bird - Returns a random bird.\n\uD83D\uDC31 <~ cat - Returns a random cat.\n\uD83E\uDD23 <~ dice - Rolls a 6-sided die.\n\uD83D\uDC36 <~ dog - Returns a random dog.\n\uD83D\uDD18 <~ flip - Flips a coin.";
        final String checkPM = "\uD83D\uDCEB Check your private messages for help! \uD83D\uDCEB";

        if(!channel.getType().equals(ChannelType.PRIVATE)){

            try {

                channel.sendMessage(makeEmbed(" ", checkPM).build()).queue();

            } catch (PermissionException exception){

                channel.sendMessage(checkPM).queue();
            }
        }

        try {

            trigger.getAuthor().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(makeEmbed("❗❗ Relash Help ❗❗", "", "Commands: " + commands).build()).queue());

        } catch (PermissionException exception) {

            trigger.getAuthor().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage("❗❗ Relash Help ❗❗\n" + commands).queue());
        }
    }
}