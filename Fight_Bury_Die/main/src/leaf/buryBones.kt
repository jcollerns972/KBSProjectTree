package leaf

import Script
import org.powbot.api.script.tree.Leaf

class buryBones(script: Script) : Leaf<Script>(script, "Burying bones...") {

    override fun execute() {
        println("BuryCode")
    }
}
