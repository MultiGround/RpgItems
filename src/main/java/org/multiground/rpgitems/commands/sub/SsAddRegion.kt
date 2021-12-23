package org.multiground.rpgitems.commands.sub

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandPermission
import dev.jorel.commandapi.arguments.*
import dev.jorel.commandapi.executors.CommandExecutor
import org.bukkit.command.CommandSender
import org.multiground.rpgitems.Rpgitems
import org.multiground.rpgitems.type.ShardLoc


object SsAddRegion {
    fun deliver(): CommandAPICommand {
        return CommandAPICommand("add")
            .withPermission(CommandPermission.OP) // Required permissions
            .withArguments(StringArgument("name"))
            .withArguments(ItemStackArgument("item"))
            .withArguments(IntegerArgument("level"))
            .executes(CommandExecutor { sender: CommandSender?, args: Array<Any?> ->
                val loc = sender!!.server.getPlayer(sender.name)!!.location
                val ssLoc = ShardLoc(loc.x, loc.y, loc.z)
                val pl = Rpgitems.getPlugin(Rpgitems::class.java)
                val tag = "ShardPos.${args[0]}"
                pl.config.set("$tag.pos", ssLoc)
                pl.config.set("$tag.item", args[1])
                pl.config.set("$tag.levelLimit", args[2])
                sender.sendMessage("Location added: ${args[0]} at ${loc.x}, ${loc.y}, ${loc.z}")
            })
    }
}