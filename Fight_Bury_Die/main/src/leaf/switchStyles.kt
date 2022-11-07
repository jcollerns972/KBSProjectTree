package leaf

import Script
import org.powbot.api.script.tree.Leaf

class switchStyles(script: Script) : Leaf<Script>(script, "Switching styles...") {

    override fun execute() {
        println("StyleSwitchCode")
    }
}