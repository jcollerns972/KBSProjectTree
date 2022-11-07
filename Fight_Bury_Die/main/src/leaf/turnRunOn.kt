package leaf

import Script
import org.powbot.api.script.tree.Leaf

class turnRunOn(script: Script) : Leaf<Script>(script, "Turning run power on...") {

    override fun execute() {
        println("RunOnCode")
    }
}