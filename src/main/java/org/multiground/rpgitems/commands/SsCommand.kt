package org.multiground.rpgitems.commands

import dev.jorel.commandapi.CommandAPICommand
import org.multiground.rpgitems.commands.sub.SsAddRegion
import org.multiground.rpgitems.commands.sub.SsRemRegion

object SsCommand {
    fun register() {
        CommandAPICommand("sshard")
            .withSubcommand(SsAddRegion.deliver())
            .withSubcommand(SsRemRegion.deliver())
    }
}