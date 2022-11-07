package leaf

import Script
import constants.*
import org.powbot.api.Condition.wait
import org.powbot.api.rt4.Equipment.Slot
import org.powbot.api.rt4.Equipment.itemAt
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Game.tab
import org.powbot.api.rt4.Inventory.stream
import org.powbot.api.script.tree.Leaf
import java.util.concurrent.Callable

class equipItems(script: Script) : Leaf<Script>(script, "Equipping items...") {

    override fun execute() {
        if (stream().name(myConstants.weapon).first().valid() && !itemAt(Slot.MAIN_HAND).valid()) {
            if (tab(Game.Tab.INVENTORY)) {
                if (stream().name(myConstants.weapon).first().interact("Wield")) {
                    wait(Callable { itemAt(Slot.MAIN_HAND).name() == myConstants.weapon }, 50, 100)
                }
            }
        }
        if (stream().name(myConstants.shield).first().valid() && !itemAt(Slot.OFF_HAND).valid()) {
            if (tab(Game.Tab.INVENTORY)) {
                if (stream().name(myConstants.shield).first().interact("Wield")) {
                    wait(Callable { itemAt(Slot.MAIN_HAND).name() == myConstants.shield }, 50, 100)
                }
            }
        }
        }
}
