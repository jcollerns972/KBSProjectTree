package areas;

import org.powbot.api.Area;
import org.powbot.api.Tile;

public class myAreas {
    public static Tile deathAreaBotLeft = new Tile(3226,3211);
    public static Tile deathAreaTopRight = new Tile(3217,3226);
    public static Tile cowPenBotLeft = new Tile(3193,3284);
    public static Tile cowPenTopRight = new Tile(3210,3301);
    public static Tile midCowPenBotLeft = new Tile(3199,3290);
    public static Tile midCowPenTopRight = new Tile(3204,3295);

    public static Area cowArea = new Area(cowPenBotLeft,cowPenTopRight);
    public static Area midCowArea = new Area(midCowPenBotLeft,midCowPenTopRight);
    public static Area deathArea = new Area(deathAreaBotLeft,deathAreaTopRight);
}
