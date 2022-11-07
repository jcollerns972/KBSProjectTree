package leaf

import Script
import constants.myConstants
import org.powbot.api.Condition.sleep
import org.powbot.api.Random.nextGaussian
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Game.tab
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf

class dropJunk(script: Script) : Leaf<Script>(script, "Dropping Junk....") {
    override fun execute() {
        if (tab(Game.Tab.INVENTORY)) {
            for (i in 0..27) {
                if (Inventory.itemAt(i).name() !== myConstants.weapon && Inventory.itemAt(i).name() !== myConstants.shield) {
                    if (tab(Game.Tab.INVENTORY)) {
                        Inventory.itemAt(i).interact("Drop")
                    }
                }
            }
            sleep(nextGaussian(30, 180, 50.0))
        }
    }
}