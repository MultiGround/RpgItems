package org.multiground.rpgitems

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class Starshard : Listener {
    @EventHandler
    fun starOpenEvent(event: PlayerInteractEvent){
        if(event.item?.type == Material.NETHER_STAR){

        }
    }
}