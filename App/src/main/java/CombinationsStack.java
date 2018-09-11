import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CombinationsStack {
    public static void main(String[] args) {
        char[] chars = {'a','c','d'};
        for(Set<Character> s : combinationsStack(chars, 2)) {
            for(Character c : s) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static Set<Set<Character>> combinationsStack(final char[] chars, int k){
        Stack<Set<Character>> stack = new Stack<>();
        Set<Set<Character>> sets = new HashSet<>();
        for(char c : chars) {
            Set<Character> set = new HashSet<>();
            set.add(c);
            stack.push(set);
        }

        while(stack.size() != 0) {
            Set<Character> set = stack.pop();
            for(char c : chars) {
                if(!set.contains(c)) {
                    set.add(c);
                    if(set.size() == k) {
                        if(sets.contains(set)) {
                            set.remove(c);
                        } else {
                            sets.add(set);
                            break;
                        }
                        //sets.add(set);
                    } else {
                        stack.push(set);
                    }
                }
            }
        }
        return sets;
    }
}
