package org.multiground.rpgitems.commands.sub

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandPermission
import dev.jorel.commandapi.arguments.StringArgument
import dev.jorel.commandapi.executors.CommandExecutor
import org.bukkit.command.CommandSender
import org.multiground.rpgitems.Rpgitems

object SsRemRegion {
    fun deliver(): CommandAPICommand {
        return CommandAPICommand("rem")
            .withPermission(CommandPermission.OP) // Required permissions
            .withArguments(StringArgument("name"))
            .executes(CommandExecutor { sender: CommandSender?, args: Array<Any?> ->
                val pl = Rpgitems.getPlugin(Rpgitems::class.java)
                val tag = "ShardPos.${args[0]}"
                if(pl.config.contains(tag)){
                    pl.config.set("ShardPos.${args[0]}", "NaN")
                    sender?.sendMessage("Removed!")
                } else {
                    sender?.sendMessage("Location not found.")
                }
            })
    }
}