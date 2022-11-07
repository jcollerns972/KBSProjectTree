package leaf

import Script
import org.powbot.api.script.tree.Leaf

class fightNpc(script: Script) : Leaf<Script>(script, "Attacking Npc...") {

    override fun execute() {
        println("FightCode")
    }
}