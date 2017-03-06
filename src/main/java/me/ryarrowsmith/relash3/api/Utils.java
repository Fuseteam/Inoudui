package me.ryarrowsmith.relash3.api;

import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Ryan's PC on 05/03/2017.
 */
public abstract class Utils {

    protected EmbedBuilder makeEmbed(String title, String description, String... fields){

        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(new Color(0,255,235));
        embed.setTitle(title, null);
        embed.setDescription(description);
        for(String field : fields){

            String arg = field.split(" ")[0];
            embed.addField(arg, field.replaceFirst(arg, ""), false);
        }

        return embed;
    }

    protected String getImage(String animal){

        String confused = "https://pbs.twimg.com/profile_images/746834035448610817/9sOJeHXL.jpg";
        String image;

        try {

            image = new Scanner(new URL("http://shibe.online/api/" + animal + "/?count=1").openStream()).next().replaceAll("[\\[\\]\"]", "");

        } catch (IOException e){

            image = confused;
        }

        return image;
    }
}
