import java.util.HashSet;
import java.util.Set;

public class AllSubsetsOfSet {
    public static void main(String[] args) {
        String s = "abcd";
        Set<String> set = allSubsets(s);
        for(String subset : set) {
            System.out.println(subset);
        }
    }

    static Set<String> allSubsets(String s) {
        Set<String> subsets = new HashSet<>();
        if(s.length() == 1) {
            subsets.add(s);
            return subsets;
        }

        char firstChar = s.charAt(0);
        subsets.add(String.valueOf(firstChar));
        String restString = s.substring(1);

        Set<String> otherSubsets = allSubsets(restString);

        subsets.addAll(otherSubsets);

        for(String temp : otherSubsets) {
            subsets.add(firstChar + temp);
        }
        return subsets;
    }
}
