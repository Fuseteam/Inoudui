package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 08/03/2017.
 */
public class Info extends RelashCommand {

    public void info(Message trigger){

        final MessageChannel channel = trigger.getChannel();
        final JDA jda = trigger.getJDA();
        final String info = "👥 Guilds: " + jda.getGuilds().size() + "\n🖊Text Channels: " + jda.getTextChannels().size() + "\n🎵Voice Channels: " + jda.getVoiceChannels().size() + "\n📓Total Channels: " + (jda.getTextChannels().size() + jda.getVoiceChannels().size() + "\n❗Invite: https://bfnt.io/relash-invite\n❔Support: https://bfnt.io/relash-support \n💵Donate: https://bfnt.io/relash-donate");

        try {

            channel.sendMessage(makeEmbed("❓ Relash Info ❓", "").addField("", info, true).setThumbnail(jda.getSelfUser().getEffectiveAvatarUrl()).build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage("❓ Relash Info ❓\n" + info).queue();
        }
    }
}
