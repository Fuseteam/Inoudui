package io.bfnt.relash.util;

import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

/**
 * Created by Ryan's PC on 07/03/2017.
 */
public class RelashCommand {

    public EmbedBuilder makeEmbed(String title, String description, String... fields){

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(title, null);
        embed.setDescription(description);
        for(String field : fields){

            embed.addField(field.split(" ")[0], field.replaceFirst(field.split(" ")[0], ""), false);
        }
        embed.setColor( new Color(1,210,202));
        return embed;
    }
}