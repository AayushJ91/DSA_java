import java.util.HashSet;

public class trial {
    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        set.add('v');
        System.out.println(set);
        set.add('a');
        System.out.println(set);
        set.add('V');
        System.out.println(set);
        set.add('A');
        System.out.println(set);
    }
}
