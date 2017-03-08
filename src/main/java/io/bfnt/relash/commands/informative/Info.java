package io.bfnt.relash.commands.informative;

import io.bfnt.relash.util.RelashCommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
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
        int users = 0;
        for(Guild guild : jda.getGuilds()){

            users += guild.getMembers().size();
        }
        final String info = "🙇Owner: RYArrowsmith#8070\n📚Library: JDA (Java Discord API)\n🔧API Version: 3.0.BETA2_145\n🤖Bot Version: 3.0.3\n-=+=-\n👥Guilds: " + jda.getGuilds().size() + "\n🎧Voice Channels: " + jda.getVoiceChannels().size() + "\n🖊Text Channels: " + jda.getTextChannels().size() + "\n📓Total Channels: " + (jda.getTextChannels().size() + jda.getVoiceChannels().size() + "\n👤Users: " + users + "\n-=+=-\n❗Invite: https://bfnt.io/relash-invite\n❔Support: https://bfnt.io/relash-support \n💵Donate: https://bfnt.io/relash-donate");

        try {

            channel.sendMessage(makeEmbed("❓ Relash Info ❓", "").addField("", info, true).setThumbnail(jda.getSelfUser().getEffectiveAvatarUrl()).build()).queue();

        } catch (PermissionException exception){

            channel.sendMessage("❓ Relash Info ❓\n" + info).queue();
        }
    }
}
