package tp2;

import java.util.ArrayList;
import java.util.Collection;

public class Interview {
    /**
     * Finds all pairs within values which sum up to targetSum
     * @param values All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */
    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum) {
        ArrayList<MatchingPair> list = new ArrayList<>();
        Integer[] valeur1 = values.toArray(new Integer[values.size()]);
        Integer[] valeur2 = values.toArray(new Integer[values.size()]);

        for (int i = 0; i < values.size(); i++) {
            if (valeur1[i] != null) {
                int formePaire = targetSum - valeur1[i];
                for (int j = 0; j < values.size(); j++) {
                    if (i != j && formePaire == valeur2[j]) {
                        valeur1[j] = null;
                        MatchingPair paire = new MatchingPair(formePaire, valeur1[i]);
                        list.add(paire);
                    }
                }
                valeur1[i] = null;
            }
        }
        return list;
    }
}

