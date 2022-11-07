package leaf

import areas.myAreas
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class returnToFightArea(script: Script) : Leaf<Script>(script, "Returning to fight area...") {
    override fun execute() {
        var tile = myAreas.midCowArea.randomTile
        if(Movement.walkTo(tile))
        {
            Condition.wait({ myAreas.midCowArea.contains(Players.local())}, 1000,50)
        }
    }
}