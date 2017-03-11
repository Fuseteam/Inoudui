package io.bfnt.relash.commands.random;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.exceptions.PermissionException;

/**
 * Created by Ryan's PC on 11/03/2017.
 */
public class Explore {

    public Invite getInvite(Guild guild){


    }

    public Invite createInvite(Guild guild){

        try {

            return guild.getPublicChannel().createInvite().complete();

        } catch (PermissionException e){

            return null;
        }
    }
}
