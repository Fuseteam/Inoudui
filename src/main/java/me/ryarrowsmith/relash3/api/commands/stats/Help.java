package me.ryarrowsmith.relash3.api.commands.stats;

import me.ryarrowsmith.relash3.api.Utils;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 06/03/2017.
 */
public class Help extends Utils {

    public void help(Message trigger){

        TextChannel channel = trigger.getTextChannel();

        if(!channel.getType().equals(ChannelType.PRIVATE)){

            try {

                channel.sendMessage(makeEmbed("Check your DMs!", null).build()).queue();

            } catch (PermissionException e){

                channel.sendMessage("Check your DMs!").queue();
            }
        }

        trigger.getAuthor().openPrivateChannel().queue((PrivateChannel pc) -> {

            try {

                pc.sendMessage(makeEmbed("Relash Help", "Commands:", "Random: ></>flip\n></>bird\n></>cat\n></>dog", "Information: ></>ginfo\n></>ghelp\n></>info\n></>ping\n></>uinfo").build()).queue();

            } catch (PermissionException e){

                pc.sendMessage("Relash Help").queue();
            }

        });
    }
}
