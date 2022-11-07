import branch.ShouldWeEquipItems
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import org.powbot.mobile.service.ScriptUploader

@ScriptManifest(
    name = "fightBuryDieTree",
    description = "",
    version = "1.0.0",
    priv = true,
    author = "blaki")
class Script : TreeScript() {
    //private val logger = Logger.getLogger(this.javaClass.name)
    override val rootComponent: TreeComponent<*> by lazy {
        ShouldWeEquipItems(this)
    }

    override fun onStart() {
        super.onStart()
        addPaint()
    }

    private fun addPaint() {
        val p: Paint = PaintBuilder.newBuilder()
            .addString("Last leaf:") { lastLeaf.name }
            .y(45)
            .x(40)
            .trackSkill(Skill.Ranged)
            .trackSkill(Skill.Attack)
            .trackSkill(Skill.Strength)
            .trackSkill(Skill.Defence)
            .trackSkill(Skill.Hitpoints)
            .trackSkill(Skill.Prayer)
            .withoutDiscordWebhook()
            .build()
        addPaint(p)
    }
}

fun main(args: Array<String>) {
    ScriptUploader().uploadAndStart(
        "fightBuryDieTree",
        "",
        "localhost:5555",
        true,
        false
    )
}