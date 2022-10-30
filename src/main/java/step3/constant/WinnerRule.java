package step3.constant;

import java.util.HashMap;
import java.util.Map;

public class WinnerRule {
    public static final Map<Integer, Integer> rules = new HashMap<>();

    public static void setWinnerRules() {
        rules.put(3,5000);
        rules.put(4,50000);
        rules.put(5,1500000);
        rules.put(6,2000000000);
    }


}