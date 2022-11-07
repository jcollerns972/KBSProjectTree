package branch

import Script
import areas.myAreas
import constants.myConstants
import leaf.buryBones
import leaf.fightNpc
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class ShouldWeFight(script:Script) : Branch<Script>(script, "Dropping Items") {
    override val successComponent: TreeComponent<Script> = fightNpc(script)
    override val failedComponent: TreeComponent<Script> = ShouldWeBuryBones(script)

    override fun validate(): Boolean {
        return Players.local().valid()
                && myAreas.cowArea.contains(Players.local())
                && !Players.local().interacting().valid()
                && !Npcs.stream().interactingWithMe().first().valid()
                && Players.local().healthPercent() > 0
                && myConstants.logout != 1
    }
}
class ShouldWeBuryBones(script:Script) : Branch<Script>(script, "Dropping Items") {
    override val successComponent: TreeComponent<Script> = buryBones(script)
    override val failedComponent: TreeComponent<Script> = ShouldWeEquipItems(script)
    override fun validate(): Boolean {
        return Players.local().valid()
                && myAreas.cowArea.contains(Players.local())
                && !Players.local().interacting().valid()
                && !Npcs.stream().interactingWithMe().first().valid()
                && Players.local().healthPercent() > 0
                && myConstants.logout != 1
    }
}