import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {

    public String countOfAtoms(String formula) {

        TreeMap<Character, Integer> parentMap = new TreeMap<>();
        Stack<HashMap<Character, Integer>> stack = new Stack<>();

        for (int i = 0; i < formula.length(); i++) {

        }
    }

    int rec(int quesitonIdx, List<List<String>> qustionTags, boolean[] candididatePicked,
            List<List<String>> candidatesKeywords) {
            
            // retun whin idx is out of bon

            // try to match current questionIdx to any candidate if keyword exist and is not visited
            // add ans = max(ans, 1 + rec(idx + 1....))
    }
}
