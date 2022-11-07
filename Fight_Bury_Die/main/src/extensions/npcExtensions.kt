package extensions

import areas.myAreas
import org.powbot.api.rt4.Npc
import org.powbot.api.rt4.Npcs

fun Npcs.nearestNpc(vararg names: String): Npc
{
    return stream().within(myAreas.cowArea).name(*names).filtered{ npc: Npc -> !npc.inCombat() }.nearest().first();
}