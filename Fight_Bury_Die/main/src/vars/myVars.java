package vars;

import java.util.ArrayList;

public class myVars {
    public static myVars vars;
    public static myVars get() {
        return vars == null ? vars = new myVars() : vars;
    }
    public static void reset() {
        vars = null;
    }
    public int times_died;
    public String attack_style = "ACCURATE";
    public String strength_style = "AGGRESSIVE";
    public String defence_style = "DEFENSIVE";

}
