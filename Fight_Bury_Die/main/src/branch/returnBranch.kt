package branch

import areas.myAreas
import Script
import leaf.*
import org.powbot.api.rt4.Equipment
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class ShouldWeEquipItems(script:Script) : Branch<Script>(script, "Equipping Items") {
    override val successComponent: TreeComponent<Script> = equipItems(script)
    override val failedComponent: TreeComponent<Script> = ShouldWeDropJunk(script)

    override fun validate(): Boolean {
        return !Equipment.itemAt(Equipment.Slot.MAIN_HAND).valid() || !Equipment.itemAt(Equipment.Slot.OFF_HAND).valid()
    }
}
class ShouldWeDropJunk(script:Script) : Branch<Script>(script, "Dropping Items") {
    override val successComponent: TreeComponent<Script> = dropJunk(script)
    override val failedComponent: TreeComponent<Script> = ShouldWeReturn(script)

    override fun validate(): Boolean {
        return Inventory.isNotEmpty()
    }
}
class ShouldWeReturn(script:Script) : Branch<Script>(script, "Return Branch") {
    override val successComponent: TreeComponent<Script> = returnToFightArea(script)
    override val failedComponent: TreeComponent<Script> = ShouldWeFight(script)

    override fun validate(): Boolean {
        return !myAreas.cowArea.contains(Players.local())
    }
}
